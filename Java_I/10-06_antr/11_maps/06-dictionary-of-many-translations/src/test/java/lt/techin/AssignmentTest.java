package lt.techin;

import java.util.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    @Test void addsTranslationsWithoutLosingEarlierOnesAndPreservesOrder() {
        DictionaryOfManyTranslations d = new DictionaryOfManyTranslations();
        d.add("lie", "maata"); d.add("lie", "valehdella"); d.add("bow", "jousi"); d.add("bow", "kumartaa");
        assertEquals(List.of("maata", "valehdella"), d.translate(new String("lie")));
        assertEquals(List.of("jousi", "kumartaa"), d.translate("bow"));
    }
    @Test void returnsAnEmptyArrayListForUnknownAndRemovedWords() {
        DictionaryOfManyTranslations d = new DictionaryOfManyTranslations();
        assertNotNull(d.translate("missing")); assertTrue(d.translate("missing").isEmpty());
        d.add("word", "sana"); d.add("word", "ord"); d.remove("word");
        assertEquals(new ArrayList<String>(), d.translate("word"), "Remove all translations, not only one.");
    }
    @Test void removalDoesNotAffectOtherWordsAndRemovedWordsCanBeReadded() {
        DictionaryOfManyTranslations d = new DictionaryOfManyTranslations();
        d.add("word", "sana"); d.add("jungle", "viidakko"); d.remove("unknown");
        assertEquals(List.of("sana"), d.translate("word"));
        d.remove("word"); assertEquals(List.of("viidakko"), d.translate("jungle"));
        d.add("word", "new"); assertEquals(List.of("new"), d.translate("word"));
        assertTrue(d.translate("Word").isEmpty()); assertTrue(new DictionaryOfManyTranslations().translate("word").isEmpty());
    }
    @Test void retainsRepeatedTranslations() {
        DictionaryOfManyTranslations d = new DictionaryOfManyTranslations();
        d.add("word", "sana"); d.add("word", "sana"); d.add("word", "ord");
        assertEquals(List.of("sana", "sana", "ord"), d.translate("word"));
    }
    @Test void storesWordListsInAPrivateInstanceMap() throws Exception { requireMap(DictionaryOfManyTranslations.class); }


    private static void requireMap(Class<?> type) throws Exception {
        boolean found = false;
        for (Field field : type.getDeclaredFields()) {
            if (field.isSynthetic()) continue;
            assertTrue(Modifier.isPrivate(field.getModifiers()), "Keep storage fields private.");
            assertFalse(Modifier.isStatic(field.getModifiers()), "Each object must have independent storage.");
            if (Map.class.isAssignableFrom(field.getType())) found = true;
        }
        assertTrue(found, "Store associations in an instance Map field.");
    }
    private static void requireSingleHashMap(Class<?> type) throws Exception {
        requireMap(type);
        List<Field> fields = Arrays.stream(type.getDeclaredFields()).filter(f -> !f.isSynthetic()).toList();
        assertEquals(1, fields.size(), "Use the single HashMap field specified in the description.");
        assertEquals(HashMap.class, fields.get(0).getType(), "Declare the field as HashMap as requested.");
    }
}
