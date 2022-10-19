import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPassPage {
    //локатор кнопки "войти"
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement signIn;

    public void clickSignIn(){
        signIn.click();
    }
}
