package lt.techin;

import java.util.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    @Test void findsStoredExplanationsAndMissingKeys() {
        Abbreviations a = new Abbreviations();
        assertFalse(a.hasAbbreviation("lol"));
        assertNull(a.findExplanationFor("lol"));
        a.addAbbreviation("lol", "laughing out loud");
        a.addAbbreviation("etc", "and so on");
        assertTrue(a.hasAbbreviation(new String("lol")), "Find an equal string key, not only the same object.");
        assertFalse(a.hasAbbreviation("lmao"));
        assertEquals("and so on", a.findExplanationFor("etc"));
        assertNull(a.findExplanationFor("lmao"));
    }
    @Test void preservesEveryMappingInThePdfExample() {
        Abbreviations a = new Abbreviations();
        a.addAbbreviation("e.g.", "for example"); a.addAbbreviation("etc.", "and so on");
        a.addAbbreviation("i.e.", "more precisely");
        assertEquals("for example", a.findExplanationFor("e.g."));
        assertEquals("more precisely", a.findExplanationFor("i.e."));
        assertFalse(a.hasAbbreviation("ETC."));
    }
    @Test void replacesExplanationsWithoutSharingDataBetweenInstances() {
        Abbreviations a = new Abbreviations();
        a.addAbbreviation("x", "first"); a.addAbbreviation("x", "second");
        assertEquals("second", a.findExplanationFor("x"), "A key has one current explanation.");
        assertNull(new Abbreviations().findExplanationFor("x"));
    }
    @Test void storesPairsInAPrivateInstanceMap() throws Exception { requireMap(Abbreviations.class); }


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
