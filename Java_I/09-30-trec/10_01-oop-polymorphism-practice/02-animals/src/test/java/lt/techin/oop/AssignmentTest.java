package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void abstractionAndInheritedMethods() {
        assertTrue(java.lang.reflect.Modifier.isAbstract(Animal.class.getModifiers()),"Animal must be abstract.");
        for(Class<?> c:new Class<?>[]{Dog.class,Cat.class}) {
            assertEquals(Animal.class,c.getSuperclass());
            for(String m:new String[]{"getName","eat","sleep"}) assertEquals(Animal.class,assertDoesNotThrow(()->c.getMethod(m)).getDeclaringClass());
        }
        assertTrue(NoiseCapable.class.isInterface());
        var method=assertDoesNotThrow(()->NoiseCapable.class.getMethod("makeNoise"),"Declare makeNoise in NoiseCapable.");
        assertEquals(void.class,method.getReturnType());
        assertTrue(java.lang.reflect.Modifier.isAbstract(method.getModifiers()));
    }
    @Test void namesAndSharedBehavior() {
        assertEquals("Dog",new Dog().getName());assertEquals("Cat",new Cat().getName());
        for(Animal a:new Animal[]{new Dog("Fido"),new Cat("Murka")}) {
            assertEquals(a instanceof Dog?"Fido":"Murka",a.getName());
            assertEquals(a.getName()+" eats\n",output(a::eat));assertEquals(a.getName()+" sleeps\n",output(a::sleep));
        }
    }
    @Test void noisesAndClient() {
        assertEquals("Rex barks\n",output(()->new Dog("Rex").bark()));
        assertEquals("Mimi purrs\n",output(()->new Cat("Mimi").purr()));
        assertEquals("Dog barks\nMurka purrs\n",output(()->AnimalSounds.play(new NoiseCapable[]{new Dog(),new Cat("Murka")})));
        assertEquals("",output(()->AnimalSounds.play(new NoiseCapable[0])));
        class Bell implements NoiseCapable { public void makeNoise(){System.out.println("ding");} }
        assertEquals("ding\n",output(()->AnimalSounds.play(new NoiseCapable[]{new Bell()})));
    }
    @Test void makeNoiseDelegates() {
        class ProbeDog extends Dog { int calls; public void bark(){calls++;} }
        class ProbeCat extends Cat { int calls; public void purr(){calls++;} }
        ProbeDog d=new ProbeDog();ProbeCat c=new ProbeCat();d.makeNoise();c.makeNoise();assertEquals(1,d.calls);assertEquals(1,c.calls);
    }
    @Test void animalStateIsPrivate() {
        for(var f:Animal.class.getDeclaredFields())if(!f.isSynthetic()) {
            assertTrue(java.lang.reflect.Modifier.isPrivate(f.getModifiers()));
            assertFalse(java.lang.reflect.Modifier.isStatic(f.getModifiers()),"The name belongs to the animal.");
        }
    }

}
