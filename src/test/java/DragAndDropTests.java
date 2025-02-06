import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void dragAndDropFirstMethod(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().build().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

    @Test
    void dragAndDropSecondMethod() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropThirdMethod() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }


}
