package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DemoqaLes11Test extends TestBase {

    @BeforeAll
    static void beforeall() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    @Tag("web")
    @DisplayName("Заполнение регистрационной формы")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем страницу", ()->{
            open("/automation-practice-form");
        });
        step("Заполняем форму", ()->{
            $("#firstName").setValue("Max");
            $("#lastName").setValue("Jons");
            $("#userEmail").setValue("max@jons.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1980");
            $(".react-datepicker__month-select").selectOption("August");
            $$(".react-datepicker__day").findBy(text("14")).click();
            $("#subjectsInput").setValue("Biology").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("2025-04-24_13-53-15.png");
            $("#currentAddress").setValue("Baker Street 1");
            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#react-select-4-input").setValue("Karnal").pressEnter();
            $("#submit").click();
        });
        step("Проверяем", () ->{
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Max Jons"));
            $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
            $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
            $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 August,1980"));
            $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
            $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
            $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("2025-04-24_13-53-15.png"));
            $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Baker Street 1"));
            $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
        });




    }

}
