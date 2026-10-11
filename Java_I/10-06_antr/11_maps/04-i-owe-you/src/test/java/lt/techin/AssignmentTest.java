package lt.techin;

import java.util.*;
import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    @Test void storesIndependentAmountsIncludingNegativeDebt() {
        IOU iou = new IOU(); iou.setSum("Arthur", 919.83); iou.setSum("Matt", 32.1); iou.setSum("Joel", -5);
        assertEquals(919.83, iou.howMuchDoIOweTo(new String("Arthur")), 1e-9);
        assertEquals(32.1, iou.howMuchDoIOweTo("Matt"), 1e-9); assertEquals(-5, iou.howMuchDoIOweTo("Joel"));
    }
    @Test void returnsZeroForAnUnknownPersonWithoutUnboxingNull() {
        IOU iou = new IOU(); assertEquals(0, iou.howMuchDoIOweTo("Michael"));
        iou.setSum("Arthur", 51.5); assertEquals(0, iou.howMuchDoIOweTo("arthur"));
        assertEquals(0, new IOU().howMuchDoIOweTo("Arthur"));
    }
    @Test void replacesDebtInsteadOfAddingAndCanStoreZero() {
        IOU iou = new IOU(); iou.setSum("Arthur", 51.5); iou.setSum("Michael", 30);
        iou.setSum("Arthur", 10.5); assertEquals(10.5, iou.howMuchDoIOweTo("Arthur"));
        assertEquals(30, iou.howMuchDoIOweTo("Michael"));
        iou.setSum("Arthur", 0); assertEquals(0, iou.howMuchDoIOweTo("Arthur"));
    }
    @Test void usesTheRequiredSinglePrivateHashMapField() throws Exception { requireSingleHashMap(IOU.class); }


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
