public class Person {
    public String firstName;
    public String lastName;
    public String middleName;
    private int userId;

    public String getFullName() {
        return firstName + middleName + lastName;
    }

    public static String sayWelcome () {
        return "Welcome To Java";
    }
}