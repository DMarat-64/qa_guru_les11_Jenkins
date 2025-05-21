package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ActionsHelperAds {
    public void removeBanner(){
        executeJavaScript("$('#fixedban').remove()"); //убираем всплывающие баннеры, чтобы не возникла
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('[id=\"Ad.Plus-970x250-1\"]').remove()");
        executeJavaScript("$('[id=\"adplus-anchor\"]').remove()");//ошибка element click intercepted
    }
}
