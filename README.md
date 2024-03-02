## Overview:
This Repo is a personalized walkthrough and hints for reading, inspecting and using daytoday java code in Android and Spring boot projects.

<br/>

### :cat: [Java Quick Language Tour](java-language-tour.md) < Click to view

### :cat: [Java Part 2 Language Tour](java-tour-part-2.md) < Click to view
=======
### :cat: [Android Java Tour](./android-java.md) < Click to view

<br/>

### Compilation and execution:
> Shell commands
```sh
javac Main.java
# with library :> add "-cp", stands for compile classPath
javac -cp lib1.jar;lib2.jar;lib3.jar Main.java
# javac with the filename will generate filename.class file, which we can run by java commmand by
java Main
```

### Gradle:

> 'gradle init' to populate initialize build.dradle , settings.gradle and gradlew files

> Note for gradlew and gradlew.bat: gradlew is for linux and mac. gradlew.bat is for windows. when "grdlew build" command is used, it always fetches the latest gradle version and build upon that.

> Local gradle installatin is for runnig the "gradle init" command to populate those files.

```sh
# initialize gradle script
gradle init
# call tasks from the most recent version of the gradle, not local version
./gradlew tasks
```
### Gradle Tasks:
> build project utilizing tasks, plugins through build script

> plugins atomatically add tasks. There are core and third party plugins

### Groovy DSL:
> Dynamically Typed and can be written outside of the class.

```groovy
def myVar = 'Executing as a script'
println myVar
// semicolon are optional, therefor line sensitive

def multiply(f,s) {
    println f*s
}
// when calling functions, parantheses are optional if the function has at least one parameter
multiply 3,4

// closures are defiened by braces | closures are get passed and executeed in different points
def myClosure = {
    println 'Executing closure'
}
myClosure()
```
### Gradle Java:
> By default dradle expects java code inside src/main/java directory

### Building and Execution Jar file
> ./gradlew build && java -jar build\libs\JumpStart.jar

### Manifest inside jar closure:
```groovy
jar {
    manifest {
        attributes 'Main-Class': 'com.MainulDip.Main'
    }
}
```
### Testing
> src/test/java/com/MainulDip/ClassNameTest.java

```sh
# main directory + file
mkdir test && cd main && mkdir java && cd java && mkdir com && cd com && mkdir MainulDip && cd MainulDip && touch Main.java
# Test Directory + File
mkdir test && cd test && mkdir java && cd java && mkdir com && cd com && mkdir MainulDip && cd MainulDip && touch JumpStartTest.java
```


### Self Contained Application:


### Dealing with `Null`:
Java allows `null` return in any `reference` type. Like, String, Int, Object etc. But returning null end up buggy for lots of different cases. Better approach use `Optional<T>` and return `Optional.empty()`

Jetbrain's @NotNull annotation can also be used. https://www.jetbrains.com/help/idea/annotating-source-code.html#external-annotations

```java
public Optional<Item> getItem(int itemId){
        
    boolean isAvailable = inventoryChecker.checkAvailability(itemId);

    if (isAvailable) {
        Optional<Item> item = Optional.of(inventoryManager.markAsSold(itemId));
        return item;
    } else {
       // return null; // not good
       // throw new IllegalArgumentException("Message") // better than returning null
       return Optional.empty(); // best approach
    }
 }
```
https://medium.com/javarevisited/just-dont-return-null-dcdf5d77128f

### Nullability annotations (`@NotNull`, `@Nullable` by Intellij IDEA):
By explicitly declaring the nullability of elements, the code becomes easier to maintain and less prone to nullability-related errors. `'org.jetbrains:annotations:24.0.0'` (groupid:artifact:version) is the dependency.

https://www.jetbrains.com/help/idea/annotating-source-code.html#external-annotations
```java
protected @NotNull String getSound() {
    // return null; // will mark by IDE if null is returned
    return "food";
}
```
### Java Static Method/Prop and `this`:
- static member cannot access non-static members, but non-static member can reference static members
- static member can access non-static members through instance of the class. Like how singleton pattern is implemented (private contractor to block instantiation directly and static member to create and hold the instance).
- static member can access other static members directly. 
- when referencing class members, implicit `this` is always there. can be made explicit also (redundant)

### <?> short of <? extends Object>, UpperBound and Lower bound <? super T>:
There are 3 wildcard in Java
1. upper bound (`<? extends T`)
2. lower bound (`<? super T?>`)
3. unbound (`<? extends Object>` or short `<?>`), Object is the lower most reference type in java

- upper bound ex: `<? extends Number>` reads `all classes that extends Number class or Number itself`. 

- Lower bound ex: `<? super Integer>` reads `all the super class of Integer or Integer itself`. IE, Number is allowed here as Integer's super class is Number. But Double is not allowed here as Integer doesn't extend Double. (Note, they both come from the common Number abstract class)

* The abstract class `Number` is the superclass of platform classes representing numeric values that are convertible to the primitive types byte, double, float, int, long, and short.

* Note, wildcards are used with both generics class and function. Not for directly declaring class popery type

* Note, Java support single inheritance and multiple interface implementation

```java
public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
    printOnlyIntegerClassorSuperClass(list1);
    
    List<Number> list2 = Arrays.asList(4, 5, 6, 7);
    printOnlyIntegerClassorSuperClass(list2);

    List<Double> list3 = Arrays.asList(4.0, 5.0, 6.0, 7.0);
    // printOnlyIntegerClassorSuperClass(list3); // not ok, will throw error
}

public static void printOnlyIntegerClassorSuperClass(
        List<? super Integer> list) {
    System.out.println(list);
}
```

### Intellij IDEA note:
- `pressing shift twice` will open quick file navigation