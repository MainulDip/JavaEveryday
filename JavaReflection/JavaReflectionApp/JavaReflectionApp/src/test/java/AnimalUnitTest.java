import org.example.animal.Goat;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalUnitTest {
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("org.example.animal.Goat", clazz.getName());
        assertEquals("org.example.animal.Goat", clazz.getCanonicalName());
    }

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

    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Goat goat = new Goat("goat");
        Class<?> goatClass = goat.getClass();
        Package pkg = goatClass.getPackage(); // Package implements Reflection Interface

        assertEquals("org.example.animal", pkg.getName());
    }
}
