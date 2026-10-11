package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
import lt.techin.testing.Source;
@Timeout(5)
class AssignmentTest {
    @Test void composedState(){Battery b=new Battery(3000);SmartDevice d=new SmartDevice("S1",b,"Maps");assertEquals(3000,b.getCapacity());assertEquals("S1",d.getSerialNumber());assertEquals(3000,d.getBatteryCapacity());assertEquals("Opening app: Maps",d.openApp());Device x=new Device("X",new Battery(800));assertEquals(800,x.getBatteryCapacity());assertEquals("X",x.getSerialNumber());}
    @Test void finalAndComposition() throws Exception {assertTrue(java.lang.reflect.Modifier.isFinal(Battery.class.getModifiers()),"Declare Battery final.");assertTrue(java.lang.reflect.Modifier.isFinal(field(Battery.class,"capacity").getModifiers()),"Declare capacity final.");assertTrue(java.lang.reflect.Modifier.isFinal(Device.class.getMethod("getSerialNumber").getModifiers()),"Declare getSerialNumber final.");assertEquals(Object.class,Device.class.getSuperclass());assertEquals(Device.class,SmartDevice.class.getSuperclass());fields(Battery.class,"capacity");fields(Device.class,"serialNumber","battery");fields(SmartDevice.class,"app");Source.calls("lt.techin.oop.Device","getBatteryCapacity",0,"battery","getCapacity");}

}
