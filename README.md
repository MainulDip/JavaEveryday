## Overview:
This Repo is a personalized walkthrough and hints for reading, inspecting and using daytoday java code in Android and Spring boot projects.

### Compilation and execution:
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
> Dynamically Typed and can be written outside of the class

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



### Self Contained Application: