package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CompletionFormsPage;
import pages.components.ResultTableComponent;

public class Les11JenkinsTests extends TestBase {
    CompletionFormsPage completionForms = new CompletionFormsPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Test
    @Tag("web")
    @DisplayName("Заполнение регистрационной формы")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        completionForms.openPage()
                .setFirstName("Max")
                .setLastName("Jons")
                .setEmail("max@jons.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("14", "August","1980")
                .setSubjects("Biology")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("2025-04-24_13-53-15.png")
                .setCurrentAddress("Baker Street 1")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();
        //Проверки
        resultTableComponent.successfullyCompletedCase()
                .checkResult("Student Name", "Max Jons")
                .checkResult("Student Email", "max@jons.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "14 August,1980")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "2025-04-24_13-53-15.png")
                .checkResult("Address", "Baker Street 1")
                .checkResult("State and City", "Haryana Karnal");
    }

}
