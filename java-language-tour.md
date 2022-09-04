## Java Language Tour
It's a quick language tour to re-connect with most of the Java language syntaxes and features. When you work with multiple language everyday, it can be a good idea to have a personalized language tour. So lets start

> ### Intro signature:

```java
public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome Again");
  }
}
```
> ### Variables & Types:
```java
int myNum = 5;      // Integer (whole number), by default public if not mentioned private

public float myFloatNum = 5.99f;    // Floating point number
private myLetter = 'D';             // Character
public static myBool = true;        // Boolean
String myText = "Hello";            // String

// final (const) // unchangeable
private final String dateOfBirth = "1, 1, 1990";
public final String firstSchoolName = "School Name";
```

<details>

<summary>More on Data Types!</summary>

<br/>

> ### Primitive and Non-Premitive/reference data types:

- System-defined/primitive types: byte, short, int, long, float, double, boolean, char
- User-defined/non-primitive types: Class, Object, String, Array, Interface 


> ### Type casting/convertion: 2 types

1. Widening Casting (automatically) - converting a smaller type to a larger type size
    - byte -> short -> char -> int -> long -> float -> double

```java
int myInt = 9;
double myDouble = myInt; // Automatic casting: int to double

System.out.println(myInt);      // Outputs 9
System.out.println(myDouble);   // Outputs 9.0
```

2. Narrowing Casting (manually) - converting a larger type to a smaller size type
    - double -> float -> long -> int -> char -> short -> byte 

```java
double myDouble = 9.78d;
int myInt = (int) myDouble; // Manual casting: double to int

System.out.println(myDouble);   // Outputs 9.78
System.out.println(myInt);      // Outputs 9

Double changingType = (double) aWholeNum;
String changingTypeString = String.valueOf( aDecimalPoinNum ); // also Double.toString(value)
```

</details>

<br/>

> ### Operators:
```txt
+	(Addition)
-	(Subtraction)
*	(Multiplication)
/	(Division)
%	(Modulus)
++	(Increment)
--	(Decrement)
```

<details>
    <summary> More on operators </summary>

<br/>

> ### assignment operators
- \=
- \+=
- \-=
- \*=
- \/=
- \%=
- \&= (bitwise AND)
- \|= (bitwise inclusive OR )
- \^= (bitwise exclusive OR )
- \>>= (bitwise signed right shift operator )
- \<<= (bitwise signed left shift operator )
- \<<< (bitwise unsigned right shift )


> ### Comparison Operators

- \==
- \!=
- \>
- \<
- \>=
- \<=

> ### Comparison Operators

- \==
- \!=
- \>
- \<
- \>=
- \<=

> ### Logical Operators

- \&& 
- \|| 
- \!

</details>

<br/>

> ### Conditionals, Loop, Iterator
```java
// loops
for (int i = 0; i <= array_str.size() - 1; i++){
    System.out.println("array_str On " + i + " is => " + array_str.get(i));
}

// inside loop parenthesis : is like in
for (String i: student.keySet()){
    System.out.println("Student On Indice " + i + " and his/her age is " + student.get(i));
}

// type sout and press enter to get the System.out.println()

// iterators => Works with ArrayList

Iterator<String> it = array_str.iterator();

while(it.hasNext()){
    System.out.println("Iterator iteration over array_str and the vale is => " + it.next());
}

//    conditionals, only double equals as we are strictly applying type system
```

<details>
<summary>More on: foreach, switch, continue, break</summary>


<br/>

```java
switch(expression) {
  case x:
    // code block
    break;
  case y:
    // code block
    break;
  default:
    // code block
}

//  foreach, lambda and method reference expression
List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "cat", "dog")); alphabets.forEach(s -> System.out.println(s));
// Using method reference
alphabets.forEach(System.out::println);


// Break and Continue
for (int i = 0; i < 10; i++) {
  if( i == 2){
     continue; // skip to the next iteration/loop
    } else if (i == 4) {
    break; // will end the iteration when match
  }
  System.out.println(i);
}
```



</details>

<details>
<summary>More on: Filter(), Map(), stream()</summary>

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * loop over a list, set or any collection with filtering and transformation and also in parallel.
 */
public class HigherOrderMethods {

    public static void main(String args[]) {

       List<String> alphabets = new ArrayList<>(
                                 Arrays.asList("aa", "bbb", "cac", "dog"));
       
       // looping over all elements using Iterable.forEach() method
       alphabets.forEach(s -> System.out.println(s));
       
       // replace lambda expression with method reference
       alphabets.forEach(System.out::println);
       
       // forEach() method on Stream class, which operates
       // on stream and allows to use stream methods e.g. filter(), map() etc
       
       alphabets.stream().forEach(System.out::println);
       
       // only print elmements which startswith "a"
       alphabets.stream()
               .filter(s -> s.startsWith("a"))
               .forEach(System.out::println);
       
       // filter out only which has length greater than 2
       alphabets.stream()
               .filter(s -> s.length() > 2)
               .forEach(System.out::println);

       
       // print length of each string using map()
       alphabets.stream()
               .mapToInt(s -> s.length())
               .forEach(System.out::println);
       
       // calculating sum of length of all string
       alphabets.stream()
               .mapToInt(s -> s.length())
               .sum();
    }
}
```
</details>

<br/>


> ### List | ArrayList | Array | HashMap
```java
//  array vs array lists
//  array => its length is fixed when created, cannot increase/decrease length but values are changeable
String[] namesArray = {"one", "two", "three", "four"};
namesArray[3] = "Updating Four";
System.out.println(3);
//namesArray[4] = "non-existent five"; // will throw error, Array index is out of bound

// setting array length when creation
int[] numbersArray = new int[20];

// ArrayList, more conveinent than only array thing in java.
// Also index are called indices here
ArrayList<String> array_str = new ArrayList<>();
array_str.add("firstt student");
array_str.add("second student");
array_str.add("third student");

String getV = array_str.get(1);
System.out.println(getV);

//      .length vs .size
System.out.println("aPerson to string length => " + aPerson.toString().length());

System.out.println("array_str size() => " + array_str.size());

//    hashmaps - accessing and altering
//    object equivalent of javascript => let student = { name: "FirstName", age: 14 }

HashMap<String, Integer> student = new HashMap<String, Integer>();
student.put("Yokk", 12);
student.put("john", 13);
student.put("Neo", 14);

System.out.println("student Hashmap first value's age => " + student.get("Yokk"));

HashMap<Integer, Person> studentAttendents = new HashMap<Integer, Person>();
studentAttendents.put(1234, aPerson);

System.out.println("studentAttendents Hashmap with class/objec first value => " + studentAttendents.get(1234).getFullName());
```

<br/>

### Enum:
```java 
package com.mainuldip;

public enum Suits {
//  instantiate multiple objects from this class within this class
HEARTS("Hearts", "red"), DIAMONDS("Diamonds", "White"),  SPADES("Spades", "Blue"), CLUBS("Clubs", "Green");

    public final String displayName;
    public final String color;

    //  Construction
    Suits(String displayName, String color) {
    this.displayName = displayName;
    this.color = color;
    }
//  Works like source of truth along the application

// calling from main method
//  enums
System.out.println("Suits Enum Hearts value => " + Suits.HEARTS.color);
}
```

<br/>

### Lambda and Functional Interface
```java
package com.mainuldip;

@FunctionalInterface // optional annotation, but increase readability
interface StringFunction {
//  this is a functional interface or "Single Abstract Method Interface"
//  lambda function can only provide the implementation for 1 method
    String run(String str, String anotherStr);
//    String again(String str, String anotherStr); // if used, lambda cannot handle more than one abstract method

    default void defaultMethod(){
        System.out.println("You can access this class with extended class without overriding");
    }
}

public class ExploreLambda {
    public static void main(String[] args) {
        StringFunction exclaim = (s, t) -> {
            return s + "!" + t + " 77";
        };
        StringFunction ask = (s, t) -> s + t + " ?";
//        System.out.println(exclaim("good", "boy"));
        printFormatted("Hello", "World", exclaim);
        exclaim.defaultMethod();
        printFormatted("Hello", "Dolly", ask);
    }
    public static void printFormatted(String str, String str2, StringFunction format) {
        String result = format.run(str, str2);
        format.defaultMethod();
        System.out.println(result);
    }
}
```

### String Compare:
```java
// comparing string from different source
string.equals(anotherString) // return boolean
```

<br/>

```java

```
### :cat: [Java Part 2 Language Tour](java-tour-part-2.md) < Click to view

=======


### Java Important Concept Next :
 - Java Mamory Management (How mamory works), grabage collectors
 - Programme interface (for testing, mocking, design-patterns etc), not implementation
 _Data Structures (arrays, list, sets, maps, etc) and Algorighm
 _Testing More .......