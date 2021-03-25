import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestSoftAssertions {

    @Test
    void testSoftAssertions() {
        //Откройте страниц Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("[data-content='Wiki']").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions
        $x("//a[contains(text(),'SoftAssertions')]").click();
        //проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("JUnit5"));
    }



}
