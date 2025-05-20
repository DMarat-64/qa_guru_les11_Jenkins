package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final SelenideElement modal = $(".table-responsive");

    public ResultTableComponent checkResult(String key, String value) {
        modal.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public ResultTableComponent successfullyCompletedCase(){
        modal.shouldBe(visible);
        return this;
    }

    public ResultTableComponent notsuccessfullyCompletedCase() {
        modal.shouldNotBe(visible);
        return this;
    }
}
