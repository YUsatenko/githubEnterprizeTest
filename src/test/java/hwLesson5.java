import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class hwLesson5 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void githubMain() {
        //Открываем GutHub и переходим на страницу Enterprise
        open ("https://github.com/");
        $(byTagAndText("button", "Solutions")).hover();
        $("[href='https://github.com/enterprise']").click();
        //Проверяем, что перешли на нужную страницу
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

}
