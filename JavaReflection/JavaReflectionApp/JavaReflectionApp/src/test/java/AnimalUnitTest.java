import org.example.animal.Goat;
import org.junit.jupiter.api.Test;

public class AnimalUnitTest {
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();
    }
}
