package JavaLanguageTour.lambda_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionInterface {
    public static void main(String[] args) {
        Stream<Number> numberStream = Stream.of(1,2L);
        Function<Number, Integer> fun = n -> Integer.valueOf(n.intValue());
        Stream<Integer> numberStream1 = numberStream.map(fun);
        // map accept `fun` signature as Integer is a subtype of Number, aka Integer extends Number
        // as map will accept `Function<? super T, ? extends R>` where T is the stream type and R is the accepted return type
        numberStream1.forEach(System.out::println);
        // will print 1 and 2
    }

}