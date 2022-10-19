import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import extensions.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.*;
import static config.Config.URL;
import static org.junit.Assert.*;

public class HomePageTest {
    HomePage homePage;
    DriverFactory driverFactory;
    @Before
    public void startUp(){
        WebDriverRunner.setWebDriver(driverFactory.getBrowser());
        homePage = open(URL, HomePage.class);
    }
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
    @Test
    @DisplayName("Переход к разделу соусы")
    public void goToConstructorSauce(){
        homePage.clickSauceButton();
        String actual = homePage.getTextCategoryChoose();
        assertEquals("Соусы", actual);
    }
    @Test
    @DisplayName("Переход к разделу начинки")
    public void goToConstructorFillings(){
        homePage.clickFillingsButton();
        String actual = homePage.getTextCategoryChoose();
        assertEquals("Начинки", actual);
    }
    @Test
    @DisplayName("Переход к разделу булки")
    public void goToConstructorBun(){
        homePage.clickSauceButton();
        homePage.clickBunButton();
        String actual = homePage.getTextCategoryChoose();
        assertEquals("Булки", actual);
    }
}