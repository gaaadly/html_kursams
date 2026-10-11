package lt.techin;

import java.util.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    @Test void equalityUsesBothStringValuesAndObeysTheObjectContract() {
        LicensePlate first = new LicensePlate("FI", "ABC-123");
        LicensePlate second = new LicensePlate(new String("FI"), new String("ABC-123"));
        LicensePlate third = new LicensePlate("FI", "ABC-123");
        assertEquals(first, first); assertEquals(first, second); assertEquals(second, first); assertEquals(second, third);
        assertNotEquals(first, new LicensePlate("FI", "ABC-122"));
        assertNotEquals(first, new LicensePlate("F", "ABC-123"));
        assertNotEquals(first, new LicensePlate("fi", "ABC-123"));
        assertFalse(first.equals(null)); assertFalse(first.equals("FI ABC-123"));
        assertEquals("FI ABC-123", first.toString());
    }
    @Test void equalPlatesWorkInListsAndHashMaps() {
        LicensePlate first = new LicensePlate("FI", "ABC-123"); LicensePlate equal = new LicensePlate("FI", "ABC-123");
        assertEquals(first.hashCode(), equal.hashCode(), "Equal keys must have equal hash codes.");
        assertTrue(new ArrayList<>(List.of(first)).contains(equal));
        HashMap<LicensePlate, String> map = new HashMap<>(); map.put(first, "Arto");
        assertEquals("Arto", map.get(equal));
        assertEquals(new LicensePlate("D", "B IFK-333").hashCode(), new LicensePlate("D", "B IFK-333").hashCode());
        Set<Integer> codes = new HashSet<>();
        codes.add(new LicensePlate("FI", "AAA-111").hashCode());
        codes.add(new LicensePlate("B", "ZZ-22 A").hashCode());
        codes.add(new LicensePlate("QQ", "joopajoo").hashCode());
        assertTrue(codes.size() > 1, "Compute a hash from the fields instead of returning one constant.");
    }
    @Test void rejectsDuplicatePlatesWithoutReplacingTheirOwners() {
        VehicleRegistry registry = new VehicleRegistry();
        assertTrue(registry.add(new LicensePlate("FI", "AAA-111"), "Arto"));
        assertFalse(registry.add(new LicensePlate("FI", "AAA-111"), "Pekka"));
        assertEquals("Arto", registry.get(new LicensePlate("FI", "AAA-111")));
        assertTrue(registry.add(new LicensePlate("D", "AAA-111"), "Jürgen"));
        assertEquals("Jürgen", registry.get(new LicensePlate("D", "AAA-111")));
        assertNull(registry.get(new LicensePlate("FI", "missing")));
        assertNull(new VehicleRegistry().get(new LicensePlate("FI", "AAA-111")));
    }
    @Test void removesAnEqualPlateAndAllowsItToBeRegisteredAgain() {
        VehicleRegistry registry = new VehicleRegistry(); LicensePlate first = new LicensePlate("FI", "AAA-111");
        assertFalse(registry.remove(first)); registry.add(first, "Arto");
        registry.add(new LicensePlate("FI", "BBB-222"), "Pekka");
        assertTrue(registry.remove(new LicensePlate("FI", "AAA-111")));
        assertFalse(registry.remove(first)); assertNull(registry.get(first));
        assertEquals("Pekka", registry.get(new LicensePlate("FI", "BBB-222")));
        assertTrue(registry.add(first, "New owner")); assertEquals("New owner", registry.get(first));
    }
    @Test void printsEachCurrentPlateAndEachDistinctOwnerOnce() {
        VehicleRegistry registry = new VehicleRegistry();
        registry.add(new LicensePlate("FI", "AAA-111"), "Arto");
        registry.add(new LicensePlate("FI", "BBB-222"), "Pekka");
        registry.add(new LicensePlate("FI", "CCC-333"), new String("Arto"));
        outputLines(capture(registry::printLicensePlates), "FI AAA-111", "FI BBB-222", "FI CCC-333");
        outputLines(capture(registry::printOwners), "Arto", "Pekka");
        assertEquals("Pekka", registry.get(new LicensePlate("FI", "BBB-222")));
        registry.remove(new LicensePlate("FI", "BBB-222"));
        outputLines(capture(registry::printOwners), "Arto");
        outputLines(capture(new VehicleRegistry()::printOwners));
        outputLines(capture(new VehicleRegistry()::printLicensePlates));
    }
    @Test void retainsPrivateFinalPlateFieldsAndSingleRegistryHashMap() throws Exception {
        for (String name : List.of("country", "liNumber")) {
            Field field = LicensePlate.class.getDeclaredField(name);
            assertTrue(Modifier.isPrivate(field.getModifiers())); assertTrue(Modifier.isFinal(field.getModifiers()));
            assertFalse(Modifier.isStatic(field.getModifiers())); assertEquals(String.class, field.getType());
        }
        requireSingleHashMap(VehicleRegistry.class);
    }

    private static String capture(Runnable action) {
        java.io.PrintStream previous = System.out;
        java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        try (java.io.PrintStream stream = new java.io.PrintStream(bytes, true, java.nio.charset.StandardCharsets.UTF_8)) {
            System.setOut(stream);
            action.run();
        } finally { System.setOut(previous); }
        return bytes.toString(java.nio.charset.StandardCharsets.UTF_8).replace("\r\n", "\n");
    }
    private static void outputLines(String actual, String... expected) {
        ArrayList<String> lines = new ArrayList<>(actual.lines().toList());
        ArrayList<String> wanted = new ArrayList<>(Arrays.asList(expected));
        Collections.sort(lines); Collections.sort(wanted);
        assertEquals(wanted, lines, "Print each required line once, with no extra text; map order may vary.");
    }


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
