package tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static pages.RegistrationPage.getRandomNegativeEmail;

public class PracticeFormTest extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userEmailNegative = getRandomNegativeEmail();
    String gender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String userNumberNegative = faker.phoneNumber().subscriberNumber(9);
    String dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28));
    String monthOfBirth = faker.options().option(
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2100));
    String subject = faker.options().option("Maths", "Physics", "Chemistry", "Biology");
    String hobbies = faker.options().option("Sports", "Reading", "Music");
    String uploadImage = "test-picture.jpg";
    String currentAddress = faker.address().fullAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> "Unknown";
    };
    String submitFormTitle = "Thanks for submitting the form";


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbie(hobbies)
                .uploadPicture(uploadImage)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .checkSubmitFormAppear(submitFormTitle)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", uploadImage)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmailNegative)
                .setGender(gender)
                .setUserNumber(userNumberNegative)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbie(hobbies)
                .uploadPicture(uploadImage)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .checkSubmitFormNotAppear();
    }

    @Test
    void minimumDataForSubmitTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .checkSubmitFormAppear(submitFormTitle)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }
}
