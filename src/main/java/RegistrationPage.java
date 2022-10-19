import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;
public class RegistrationPage {

    //локатор кнопки "зарегистрироваться" при входе
    @FindBy(how=How.LINK_TEXT, using="Зарегистрироваться")
    private SelenideElement register;
    //локатор поля ввода имени при регистрации
    @FindBy(how=How.XPATH, using=".//fieldset[1]/div[@class='input__container']/div/input")
    private SelenideElement registerNameInput;
    //локатор поля ввода имейла при регистрации
    @FindBy(how=How.XPATH, using=".//fieldset[2]/div[@class='input__container']/div/input")
    private SelenideElement registerEmailInput;
    //локатор поля ввода пароля при регистрации
    @FindBy(how=How.XPATH, using=".//fieldset[3]/div[@class='input__container']/div/input")
    private SelenideElement registerPassInput;
    //локатор кнопки "зарегистрироваться" при регистрации
    @FindBy(how=How.XPATH, using=".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    //локатор сообщения о некорректном пароле при регистрации
    @FindBy(how = How.XPATH, using = ".//div/div/p")
    private SelenideElement incorrectPassMessage;
    //локатор кнопки "войти"
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement signIn;

    private String name;
    private String email;
    private String pass;


    public void setName(String name){
        registerNameInput.val(name);
    }
    public void setEmail(String email){
        registerEmailInput.val(email);
    }
    public void setPass(String pass){
        registerPassInput.val(pass);
    }
    public void clickSignIn(){
        signIn.click();
    }
    public void clickRegisterButton(){
        registerButton.click();
    }
    public void incorrectPassMessageVisible(){
        incorrectPassMessage.shouldBe(visible);
    }
    public void waitForLoadRegistrationPage(){
        registerButton.shouldBe(visible);
    }
    public void register(String name, String email, String pass){
        this.email = email;
        this.name = name;
        this.pass = pass;
        setName(name);
        setEmail(email);
        setPass(pass);
        clickRegisterButton();
    }
    public String getEmail() {
        return email;
    }
    public String getPass() {
        return pass;
    }
}