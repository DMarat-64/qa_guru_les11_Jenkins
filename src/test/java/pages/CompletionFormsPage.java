package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.ActionsHelperAds;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CompletionFormsPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            StateInput = $("#react-select-3-input"),
            CityInput = $("#react-select-4-input"),
            submitClosed = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ActionsHelperAds actionsHelperAds = new ActionsHelperAds();


    public CompletionFormsPage openPage () {
        open("/automation-practice-form");
        actionsHelperAds.removeBanner();

        return this;
    }
    public CompletionFormsPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public CompletionFormsPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public CompletionFormsPage setEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public CompletionFormsPage setGender (String value) {
        genterWrapperInput.$(byText(value)).click();

        return this;
    }
    public CompletionFormsPage setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public CompletionFormsPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public CompletionFormsPage setSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public CompletionFormsPage setHobbiesWrapper (String value) {
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }
    public CompletionFormsPage setUploadPicture (String fileName) {
        uploadPictureInput.uploadFromClasspath("2025-04-24_13-53-15.png");

        return this;
    }
    public CompletionFormsPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    public CompletionFormsPage setState (String value) {
        StateInput.setValue(value).pressEnter();

        return this;
    }
    public CompletionFormsPage setCity (String value) {
        CityInput.setValue(value).pressEnter();

        return this;
    }
    public CompletionFormsPage clickSubmit () {
        submitClosed.click();

        return this;
    }

}
