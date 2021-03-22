import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQATests {

    @Test
    void practiceFormTest() {
        Configuration.timeout = 4000;
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Gleb");
        $("#lastName").setValue("Hleb");
        $("#userEmail").setValue("Hleb@null.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("9052741001");
        $("#dateOfBirthInput").click();
        $(byXpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]")).selectOption("December");
        $(byXpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]")).selectOption("1991");
        $(byXpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src\\test\\java\\1.jpg"));
        $("#currentAddress").setValue("Urupinsk");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo().click();
        //осетр
        $(byXpath("//tbody/tr[1]/td[2]")).shouldHave(text("Gleb Hleb"));
        $(byXpath("//tbody/tr[2]/td[2]")).shouldHave(text("Hleb@null.ru"));
        $(byXpath("//tbody/tr[3]/td[2]")).shouldHave(text("Male"));
        $(byXpath("//tbody/tr[4]/td[2]")).shouldHave(text("9052741001"));
        $(byXpath("//tbody/tr[5]/td[2]")).shouldHave(text("02 December,1991"));
        $(byXpath("//tbody/tr[6]/td[2]")).shouldHave(text("Arts"));
        $(byXpath("//tbody/tr[7]/td[2]")).shouldHave(text("Music"));
        $(byXpath("//tbody/tr[8]/td[2]")).shouldHave(text("1.jpg"));
        $(byXpath("//tbody/tr[9]/td[2]")).shouldHave(text("Urupinsk"));
        $(byXpath("//tbody/tr[10]/td[2]")).shouldHave(text("NCR Delhi"));

    }
}
