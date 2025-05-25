package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CompletionFormsPage;
import pages.components.ResultTableComponent;

public class NegativeLoginTest extends TestBase{
    CompletionFormsPage completionForms = new CompletionFormsPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @BeforeEach
    public void beforeEach(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @Tag("web")
    @DisplayName("Неправильное заполнение регистрационной формы")
    void negativeLoginTest () {
        completionForms.openPage()
                .setFirstName("Max")
                .setLastName("Jons")
                .setEmail("max@jons.com")
                .setGender("Male")
                .setDateOfBirth("14", "August","1980")
                .setHobbiesWrapper("Sports")
                .setCurrentAddress("Baker Street 1")
                .clickSubmit();
        //Проверки
        resultTableComponent.notsuccessfullyCompletedCase()
                .checkResult("Student Name", "Max Jons")
                .checkResult("Student Email", "max@jons.com")
                .checkResult("Gender", "Male")
                .checkResult("Date of Birth", "14 August,1980")
                .checkResult("Hobbies", "Sports")
                .checkResult("Address", "Baker Street 1");
    }
}
