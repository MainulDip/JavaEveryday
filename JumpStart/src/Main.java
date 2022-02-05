import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

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


//      array vs array lists

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

    //  enums
        System.out.println("Suits Enum Hearts value => " + Suits.HEARTS.color);

//    loops

        for (int i = 0; i <= array_str.size() - 1; i++){
            System.out.println("array_str On " + i + " is => " + array_str.get(i));
        }

//        inside loop parenthesis : is like in
        for (String i: student.keySet()){
            System.out.println("Student On Indice " + i + " and his/her age is " + student.get(i));
        }

//        type sout and press enter to get the System.out.println()

//    iterators => Works with ArrayList

        Iterator<String> it = array_str.iterator();
        while(it.hasNext()){
            System.out.println("Iterator iteration over array_str and the vale is => " + it.next());
        }


//    conditionals, only double equals as we are strictly applying type system

//    console in/out

        System.out.println("sout entering");

//    System in

//        Scanner input = new Scanner(System.in);
//        System.out.println("Please enter your name ... ");
//        String userNmae = input.nextLine();
//        System.out.println("With Age ... ");
//        int userAge = input.nextInt();
//        System.out.println("userName " + userNmae + " and user's Age is " + userAge );


        String val1 = optionalDefaultParams("Good");
        String val2 = optionalDefaultParams("Good", "better");
        System.out.println(val1 +" "+ val2);
        System.out.println(optionalDefaultParams("Good"));

    }

//     Optional and Default parameter value

    public static String optionalDefaultParams(String a, String... val) {
        a = a == null ? "Default Param Value" : a;
        String b = (val.length >= 1) ? val[0] : "";
        return ("Param a is => " + a + " and param b is => " + b + " => if b is not served, it will be empty ");
    }







//    loops

//    iterators

//    conditionals

//    console in/out



//    comparisons ( == vs .equals )
}
