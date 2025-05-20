package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ActionsHelperAds {
    public void removeBanner(){
        executeJavaScript("$('#fixedban').remove()"); //убираем всплывающие баннеры, чтобы не возникла
        executeJavaScript("$('footer').remove()"); //ошибка element click intercepted
    }
}
