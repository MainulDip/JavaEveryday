import org.example.animal.Goat;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalUnitTest {

    // class names
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        // note Class type implements some interfaces form java.lang.reflect
        Class<?> clazz = goat.getClass();

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("org.example.animal.Goat", clazz.getName()); // getName returns a `fully qualified class name`
        assertEquals("org.example.animal.Goat", clazz.getCanonicalName()); // getCanonicalName returns a Canonical name
    }

    // class modifiers
    @Test
    void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("org.example.animal.Goat");
        Class<?> animalClass = Class.forName("org.example.animal.Animal");

        int goatMods = goatClass.getModifiers();
        int animalMods = animalClass.getModifiers();

        /*
        * Note : Modifier is coming form Reflection */
        System.out.println("goatMods = " + goatMods + " and animalMods = " + animalMods);
        // goatMods = 1 and animalMods = 1025
        System.out.println("goatMods' value = " + Modifier.toString(goatMods) + " and animalMods' value = " + Modifier.toString(animalMods));
        // goatMods' value = public and animalMods' value = public abstract

        assertTrue(Modifier.isPublic(goatMods));
        assertTrue(Modifier.isAbstract(animalMods));
        assertTrue(Modifier.isPublic(animalMods));
    }

    // Package information
    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Goat goat = new Goat("goat");
        Class<?> goatClass = goat.getClass();
        Package pkg = goatClass.getPackage(); // Package implements Reflection Interface

        assertEquals("org.example.animal", pkg.getName());
    }

    // Superclass
    @Test
    public void givenClass_whenGetsSuperClass_thenCorrect() {
        Goat goat = new Goat("goat");
        String str = "any string";

        Class<?> goatClass = goat.getClass();
        Class<?> goatSuperClass = goatClass.getSuperclass();

        assertEquals("Animal", goatSuperClass.getSimpleName());
        assertEquals("Object", str.getClass().getSuperclass().getSimpleName());
    }

    // Implemented Interfaces
    @Test
    public void givenClass_whenGetsImplementedInterfaces_thenCorrect() throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("org.example.animal.Goat");
        Class<?> animalClass = Class.forName("org.example.animal.Animal");

        Class<?>[] goatInterfaces = goatClass.getInterfaces();
        Class<?>[] animalInterfaces = animalClass.getInterfaces();

        assertEquals(1, goatInterfaces.length);
        assertEquals(1, animalInterfaces.length);
        assertEquals("Locomotion", goatInterfaces[0].getSimpleName());
        assertEquals("Eating", animalInterfaces[0].getSimpleName());
    }
}
