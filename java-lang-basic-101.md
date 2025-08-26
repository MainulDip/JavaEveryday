## Java Language Tour
It's a quick language tour to re-connect with most of the Java language syntaxes and features. When you work with multiple language everyday, it can be a good idea to have a personalized language tour. So lets start

### Intro signature:
The starting point of a Java Application is the `main` function of the Application marked class.
But most frameworks hide this and use `inversion of control` pattern....

```java
public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome Again");
  }
}
```

### Single inheritance (`extends`) and Multiple Interface Implementation (`implements`):
Java class can inherit/extend only one another class/abstract and multiple interfaces, while an interface can inherit other interfaces.
Note Java allows multiple inheritance using interfaces.

### Variables & Types | Primitive and Non-Primitive/reference data types:
Watch closely and mark the different use of `lowercase` and `Uppercase` type declaration.
- System-defined/primitive types: byte, short, int, long, float, double, boolean, char
- User-defined/non-primitive types: Class, Object, String, Array, Interface 
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

### Java type system:
Java has a two-fold type system consisting of primitives such as int, boolean and reference types such as Integer, Boolean. Every primitive type has it's built-in reference type.

Under the hood, Java performs a conversion between the primitive and reference types if an actual type is different from the declared one. 

* The process of converting a primitive type to a reference one is called autoboxing, the opposite process is called unboxing

```java
Integer j = 1;          // autoboxing
int i = new Integer(1); // unboxing
```


* Primitive types cannot be `null`, as `null` is a reference. And primitive types are not reference types. Only objects are reference types.

A primitive type is just data, Primitive types cannot be null. Objects (Reference types), are just pointers to where the data is stored. Objects can be null, where data is not yet assigned.


`boolean – 1 bit` vs `Boolean – 128 bits`
`byte – 8 bits` vs `Byte – 128 bits`
`short, char – 16 bits` vs `Short, Character – 128 bits`
`int, float – 32 bits` vs `Integer, Float – 128 bits`
`long, double – 64 bits` vs `Long, Double – 192 bits`

* Primitive types are faster than the reverence types, https://www.baeldung.com/java-primitives-vs-objects

### Primitive vs Reference | Stack vs Heap:
Primitives defined locally (defined inside of a function, including method arguments)  would be on the stack. 

All reference types (Objects) and primitives of an object (Class Members/Variables) would be on the heap.

```java
public class Test {
    private static class HeapClass {
        public int y; // When an instance of HeapClass is allocated, this will be on the heap.
    }
    public static void main(String[] args) {
        int x=1; // This is on the stack.
    }
}
```

### Array `{}` | Fixed/Immutable | vs `ArrayList`:
Arrays are defined using `{}`. Arrays (not ArrayList) are fixed in size, but mutable.

```java
String[] arr;
int[] myNum = {10, 20, 30, 40};
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
cars[0] = "Opel"; // arrays are mutable
System.out.println(cars[0]); // Prints: Opel instead of Volvo
```

Arrays are fixed in size and fast performance wise, where `ArrayList` is dynamic in size and provides more flexibility and built-in methods.

- Arrays can store both primitives and reference types
- Collections can not store primitives (although they can store the primitive wrapper classes (ref type), such as Integer etc)
- Arrays are not part of the java collection framework, but ArrayList is.


### Type casting/conversion | `Widening`/Auto vs `Narrowing`/Manual:

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

### Operators:
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

### assignment operators
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


### Comparison Operators

- \==
- \!=
- \>
- \<
- \>=
- \<=

### Logical Operators

- \&& 
- \|| 
- \!

</details>

<br/>

### Conditionals, Loop, Iterator
```java
// loops
for (int i = 0; i <= array_str.size() - 1; i++){
    System.out.println("array_str On " + i + " is => " + array_str.get(i));
}

// inside loop parenthesis `:` is like in
for (String i: student.keySet()){
    System.out.println("Student On Indice " + i + " and his/her age is " + student.get(i));
}

// type sout and press enter to get the System.out.println()

// iterators => Works with ArrayList

Iterator<String> iterate = array_str.iterator();

while(iterate.hasNext()){
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
List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "cat", "dog")); 
alphabets.forEach(s -> System.out.println(s));

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

### Java stream's Filter(), Map();

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

### Method Reference:
Use `::fn` to reference a function. `System.out::println` with package name specified.

### List | ArrayList | Array | HashMap
- Array's length is fixed once created
- ArrayList, more convenient than Array. Its mutable and re-sizeable
- HashMaps are like dictionary (key/value pairs), where keys needs to be unique and value can be null
- Hashtable does not allow keys or values to be set to null 
```java
//  array vs array lists
//  array => its length is fixed when created, cannot increase/decrease length but values are changeable
String[] namesArray = {"one", "two", "three", "four"};
namesArray[3] = "Updating Four";
System.out.println(3);
//namesArray[4] = "non-existent five"; // will throw error, Array index is out of bound

// setting array length when creation
int[] numbersArray = new int[20];

// ArrayList, more convenient than only array thing in java.
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
}

// calling from main method
System.out.println("Suits Enum Hearts value => " + Suits.HEARTS.color);
```

<br/>

### Lambda and Functional Interface
Lambda is like implementing SAM (Single Abstract Method) in Java
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
//      System.out.println(exclaim("good", "boy"));
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


### Java Important Concept
 - Java Memory Management (How memory works), garbage collectors.

 android.permission.WRITE_SECURE_SETTINGS

 adb -d shell pm grant packageName  android.permission.WRITE_SECURE_SETTINGS