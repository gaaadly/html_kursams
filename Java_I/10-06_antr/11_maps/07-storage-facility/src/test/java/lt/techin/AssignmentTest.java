package lt.techin;

import java.util.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    @Test void storesOrderedItemsIncludingDuplicatesInSeparateUnits() {
        StorageFacility f = new StorageFacility();
        f.add("a14", "ice skates"); f.add("a14", "ice hockey stick"); f.add("a14", "ice skates");
        f.add("f156", "rollerblades"); f.add("f156", "rollerblades");
        assertEquals(List.of("ice skates", "ice hockey stick", "ice skates"), f.contents(new String("a14")));
        assertEquals(List.of("rollerblades", "rollerblades"), f.contents("f156"));
    }
    @Test void missingUnitsReturnEmptyListsWithoutCreatingUnits() {
        StorageFacility f = new StorageFacility();
        assertNotNull(f.contents("missing")); assertTrue(f.contents("missing").isEmpty());
        assertTrue(f.storageUnits().isEmpty()); f.remove("missing", "item"); assertTrue(f.storageUnits().isEmpty());
        f.add("a", "one"); assertTrue(f.contents("A").isEmpty());
        assertTrue(new StorageFacility().contents("a").isEmpty());
    }
    @Test void removesOnlyTheFirstMatchingOccurrence() {
        StorageFacility f = new StorageFacility(); f.add("a", "mouse"); f.add("a", "cheese");
        f.add("a", "middle"); f.add("a", "cheese");
        f.remove("a", "cheese"); assertEquals(List.of("mouse", "middle", "cheese"), f.contents("a"));
        f.remove("a", "not present"); assertEquals(List.of("mouse", "middle", "cheese"), f.contents("a"));
    }
    @Test void removesEmptyUnitsAndListsOnlyCurrentNonemptyUnits() {
        StorageFacility f = new StorageFacility(); f.add("a14", "ice skates"); f.add("g63", "pi");
        f.add("f156", "rollerblades"); f.add("f156", "rollerblades");
        f.remove("f156", "rollerblades"); assertEquals(List.of("rollerblades"), f.contents("f156"));
        assertEquals(Set.of("a14", "g63", "f156"), new HashSet<>(f.storageUnits()));
        f.remove("f156", "rollerblades"); assertEquals(List.of(), f.contents("f156"));
        assertEquals(Set.of("a14", "g63"), new HashSet<>(f.storageUnits())); assertEquals(2, f.storageUnits().size());
        f.add("f156", "new"); assertEquals(List.of("new"), f.contents("f156"));
        assertEquals(3, f.storageUnits().size());
    }
    @Test void supportsRepeatedAddRemoveAndReadCycles() {
        StorageFacility f = new StorageFacility(); f.add("a111", "mouse"); f.add("a111", "cheese");
        f.add("a111", "cheese"); f.add("b123", "projector"); f.add("g63", "ice skates");
        f.remove("a111", "cheese"); f.add("a111", "cheese");
        assertEquals(List.of("mouse", "cheese", "cheese"), f.contents("a111"));
        f.remove("b123", "projector"); assertEquals(List.of(), f.contents("b123"));
        assertEquals(Set.of("a111", "g63"), new HashSet<>(f.storageUnits()));
    }
    @Test void usesAPrivateInstanceMap() throws Exception { requireMap(StorageFacility.class); }


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
