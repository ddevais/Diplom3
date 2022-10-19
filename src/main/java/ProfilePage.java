import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;
public class ProfilePage {
    //локатор кнопки "выход"
    @FindBy(how = How.XPATH, using = ".//li[3]/button")
    private SelenideElement logOutButton;
    //локатор лого
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;
    @FindBy(how = How.XPATH, using = ".//li[1]/a[@class='AppHeader_header__link__3D_hX']")
    private SelenideElement constructorLogo;

    public void clickConstructorLogo(){
        constructorLogo.click();;
    }
    public void clickLogo(){
        logo.click();
    }
    public void clickLogOutButton(){
        logOutButton.click();
    }
    public void waitForLoadProfilePage(){
        logOutButton.shouldBe(visible);
    }
}
