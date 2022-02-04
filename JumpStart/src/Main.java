import java.util.ArrayList;

public class Main<namesArray> {
//    variables
// js: let, var, const
// here:
    String firstName = "Your name";

//    types => Primitive
    char aLetter = 'g';
    boolean isLonggedIn = true;
    int aWholeNum = 42;
    double aDecimalPoinNum = 42.47;

//    Types => Non-primitive, class type
    String fullName = "Some Name";
    Boolean isLonggedInNonP = true;
    Integer aWholeNumNonP = 42;
    Double aDecimalPoinNumNonP = 42.47;

//    changing type
    Double changingType = (double) aWholeNumNonP;
    String changingTypeString = String.valueOf( aDecimalPoinNumNonP ); // also Double.toString(value)

//    privacy
    public String lastName = "Your Last Name";
    private String nickName = "Your nick name";


//    final (const) // unchanged able
    private final String dateOfBirth = "1, 1, 1990";
    public final String firstSchoolName = "School Name";

//    function declarations
    public String functionGetFullName() {
        return (firstName + lastName);
    }

//    void => for side effects like updating or data types that does not return anything

    public void functionSideEffects(String prefix,String suffix) {
//      Do some side Effect things without returning anything
        String newName = prefix + firstName + lastName + suffix;
        fullName = newName;
    }
//    main function, starting point of the app


    public static void main(String[] args) {
//      static
//      call static functions without instantiating the class
        Person.sayWelcome();

//      classes and instances
//      constructors
//      Non-Static function from other class require instantiation first
//      assign type and instantiate
        Person aPerson = new Person();
        aPerson.firstName = "Simon";
        aPerson.lastName = "Umok";
        aPerson.middleName = "Jack";
        String getN = aPerson.getFullName();

//      instantiate with constructor function
//      press ctrl + p for parameter suggestion while inside constructor parenthesis
        Person2 secondPerson = new Person2("Nile", "Digry", "Tryson");
        secondPerson.getFullName();

//      press ctrl + p for parameter suggestion while putting cursor inside constructor parenthesis
        Person2 thirdPerson = new Person2("Albert", "Nikolous", "Neptune");
        thirdPerson.getFullName();

//      toString => To inspect class properties outside from the class
        System.out.println(thirdPerson);

        //  array => its length is fixed when created, cannot increase/decrease length but values are changeable
        String[] namesArray = {"one", "two", "three", "four"};
        namesArray[3] = "Updating Four";
        System.out.println(3);
//        namesArray[4] = "non-existent five"; // will throw error, Array index is out of bound

//      setting array length when creation
        int[] numbersArray = new int[20];

//      array lists, more conveinent than only array thing in java. Also index are called indices here
        ArrayList<String> array_str = new ArrayList<>();
        array_str.add("firstt student");
        array_str.add("second student");
        array_str.add("third student");

        array_str.get(1);


    }





//    array vs array lists

////  array => its length is fixed when created, cannot increase/decrease length but values are changeable
//    String[] namesArray = {"one", "two", "three", "four"};
//    System.out.println()


//    hashmaps - accessing and altering

//    enums

//    loops

//    iterators

//    conditionals

//    console in/out

//    .length vs .size

//    comparisons ( == vs .equals )
}
