import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EnterpriseGithubCheck {
    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void EnterprisesPageCheckTest() {
        open("https://github.com/");
        $(".HeaderMenu").$(byText("Solutions")).hover();
        $(".HeaderMenu").$(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
