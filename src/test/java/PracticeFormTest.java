import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTest {

    @Test
    void fillPracticeFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Nikolai");
        $("#lastName").setValue("Patrakov");
        $("#userEmail").setValue("testguru@auto.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOptionByValue("2");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1991");
        $("[class=react-datepicker__day react-datepicker__day--020]").click();
        $("#subjectsContainer").setValue("e").selectOptionByValue("English");
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").sendKeys("src/test/java/resources/test-picture.jpg");
        $("#currentAddress").setValue("some address");
        $("#state").selectOptionByValue("NCR");
        $("#city").selectOptionByValue("Noida");
        $("#submit").click();



        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }


}
