import org.example.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();

        List<String> actualFieldsNames = getFieldsName(fields);

        assertTrue(Arrays.asList("name", "age").containsAll(actualFieldsNames));
    }

    private static List<String> getFieldsName(Field[] fields){
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }
}