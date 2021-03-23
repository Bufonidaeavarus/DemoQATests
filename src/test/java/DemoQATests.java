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
        //Configuration.timeout = 4000;
        String firstName = "Gleb";
        String lastName = "Hleb";
        String email = lastName+"@null.ru";
        String userNumber = "9052741001";
        String gender = "Male";
        String currentAddress = "Urupinsk";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1991");
        $(byXpath("(//div[contains(text(),'2')])[1]")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src\\test\\java\\resources\\1.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo().click();
        //осетр
        $(byXpath("//tbody/tr[1]/td[2]")).shouldHave(text(firstName+" "+lastName));
        $(byXpath("//tbody/tr[2]/td[2]")).shouldHave(text(email));
        $(byXpath("//tbody/tr[3]/td[2]")).shouldHave(text(gender));
        $(byXpath("//tbody/tr[4]/td[2]")).shouldHave(text(userNumber));
        $(byXpath("//tbody/tr[5]/td[2]")).shouldHave(text("02 December,1991"));
        $(byXpath("//tbody/tr[6]/td[2]")).shouldHave(text("Arts"));
        $(byXpath("//tbody/tr[7]/td[2]")).shouldHave(text("Music"));
        $(byXpath("//tbody/tr[8]/td[2]")).shouldHave(text("1.jpg"));
        $(byXpath("//tbody/tr[9]/td[2]")).shouldHave(text(currentAddress));
        $(byXpath("//tbody/tr[10]/td[2]")).shouldHave(text("NCR Delhi"));

    }
}
