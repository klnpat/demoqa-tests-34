package tests;
import utils.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randromUtils = new RandomUtils();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(randromUtils.firstName)
                .setLastName(randromUtils.lastName)
                .setEmail(randromUtils.userEmail)
                .setGender(randromUtils.gender)
                .setUserNumber(randromUtils.userNumber)
                .setDateOfBirth(randromUtils.dayOfBirth, randromUtils.monthOfBirth, randromUtils.yearOfBirth)
                .setSubject(randromUtils.subject)
                .setHobbie(randromUtils.hobbies)
                .uploadPicture(randromUtils.uploadImage)
                .setCurrentAddress(randromUtils.currentAddress)
                .setState(randromUtils.state)
                .setCity(randromUtils.city)
                .submit()
                .checkSubmitFormAppear(randromUtils.submitFormTitle)
                .checkResult("Student Name", randromUtils.firstName + " " + randromUtils.lastName)
                .checkResult("Student Email", randromUtils.userEmail)
                .checkResult("Gender", randromUtils.gender)
                .checkResult("Mobile", randromUtils.userNumber)
                .checkResult("Date of Birth", randromUtils.dayOfBirth + " "
                        + randromUtils.monthOfBirth + "," + randromUtils.yearOfBirth)
                .checkResult("Subjects", randromUtils.subject)
                .checkResult("Hobbies", randromUtils.hobbies)
                .checkResult("Picture", randromUtils.uploadImage)
                .checkResult("Address", randromUtils.currentAddress)
                .checkResult("State and City", randromUtils.state + " " + randromUtils.city);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(randromUtils.firstName)
                .setLastName(randromUtils.lastName)
                .setEmail(randromUtils.userEmailNegative)
                .setGender(randromUtils.gender)
                .setUserNumber(randromUtils.userNumberNegative)
                .setDateOfBirth(randromUtils.dayOfBirth, randromUtils.monthOfBirth, randromUtils.yearOfBirth)
                .setSubject(randromUtils.subject)
                .setHobbie(randromUtils.hobbies)
                .uploadPicture(randromUtils.uploadImage)
                .setCurrentAddress(randromUtils.currentAddress)
                .setState(randromUtils.state)
                .setCity(randromUtils.city)
                .submit()
                .checkSubmitFormNotAppear();
    }

    @Test
    void minimumDataForSubmitTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(randromUtils.firstName)
                .setLastName(randromUtils.lastName)
                .setGender(randromUtils.gender)
                .setUserNumber(randromUtils.userNumber)
                .checkSubmitFormAppear(randromUtils.submitFormTitle)
                .checkResult("Student Name", randromUtils.firstName + " " + randromUtils.lastName)
                .checkResult("Gender", randromUtils.gender)
                .checkResult("Mobile", randromUtils.userNumber);
    }
}
