import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;
public class LoginPage {
    //локатор поля ввода имейла при входе
    @FindBy(how= How.XPATH, using=".//fieldset[1]/div[@class='input__container']/div/input")
    private SelenideElement loginEmailInput;
    //локатор поля ввода пароля при входе
    @FindBy(how=How.XPATH, using=".//fieldset[2]/div[@class='input__container']/div/input")
    private SelenideElement loginPassInput;
    //локатор кнопки "войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;


    public void waitForLoadLoginPage() {
        loginEmailInput.shouldBe(visible);
    }
    public void setLoginEmailInput(String email){
        loginEmailInput.val(email);
    }
    public void setLoginPassInput(String pass){
        loginPassInput.val(pass);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void logIn(String  email, String pass) {
        setLoginEmailInput(email);
        setLoginPassInput(pass);
        clickLoginButton();
    }
}
