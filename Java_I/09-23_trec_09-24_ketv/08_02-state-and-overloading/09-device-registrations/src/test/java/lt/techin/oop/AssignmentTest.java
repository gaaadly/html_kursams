package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void sharedCountAndSeparateNames(){int before=Device.getCount();Device a=new Device(7),b=new Device(8,"Printer");assertEquals(before+2,Device.getCount());assertEquals("Unnamed",a.getName());a.setName("Scanner");assertEquals("Printer",b.getName());assertEquals(7,a.getId());assertEquals(8,b.getId());assertEquals(before+2,Device.getCount());}
    @Test void modifiersAndConstant() throws Exception {fields(Device.class,"id","name");var id=field(Device.class,"id");assertTrue(java.lang.reflect.Modifier.isFinal(id.getModifiers()),"ID must be final.");var count=field(Device.class,"count");assertTrue(java.lang.reflect.Modifier.isPrivate(count.getModifiers()));assertTrue(java.lang.reflect.Modifier.isStatic(count.getModifiers()));var c=field(Device.class,"DEFAULT_NAME");assertTrue(java.lang.reflect.Modifier.isPublic(c.getModifiers()));assertTrue(java.lang.reflect.Modifier.isStatic(c.getModifiers()));assertTrue(java.lang.reflect.Modifier.isFinal(c.getModifiers()));assertEquals("Unnamed",c.get(null));assertTrue(java.lang.reflect.Modifier.isStatic(Device.class.getMethod("getCount").getModifiers()));}
    @Test void delegationAndConstantUse() throws Exception {Source.delegates("lt.techin.oop.Device",1,2);assertTrue(Source.usesIdentifier("lt.techin.oop.Device","<init>",1,"DEFAULT_NAME"),"Pass DEFAULT_NAME to the canonical constructor.");}

}
