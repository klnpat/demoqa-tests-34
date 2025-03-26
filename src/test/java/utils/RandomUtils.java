package utils;
import com.github.javafaker.Faker;
import java.util.Random;
import static pages.RegistrationPage.getRandomNegativeEmail;

public class RandomUtils {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userEmailNegative = getRandomNegativeEmail();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String userNumberNegative = faker.phoneNumber().subscriberNumber(9);
    public String dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
    public String monthOfBirth = faker.options().option(
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2100));
    public String subject = faker.options().option("Maths", "Physics", "Chemistry", "Biology");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String uploadImage = "test-picture.jpg";
    public String currentAddress = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> "Unknown";
    };
    public String submitFormTitle = "Thanks for submitting the form";


    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }
}