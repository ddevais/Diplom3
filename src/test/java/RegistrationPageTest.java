import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import extensions.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.*;
import static config.Config.REGISTRATION;
public class RegistrationPageTest {
    RegistrationPage registrationPage;
    ProfilePage profilePage;
    LoginPage loginPage;
    HomePage homePage;
    DriverFactory driverFactory;
    @Before
    public void startUp(){
        WebDriverRunner.setWebDriver(driverFactory.getBrowser());
        registrationPage = open(REGISTRATION, RegistrationPage.class);
    }
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void incorrectPassRegistration(){
        registrationPage.register("test","t1oot@ee.qoo","11111");
        registrationPage.incorrectPassMessageVisible();
    }
    @Test
    @DisplayName("Проверка успешной регистрации")
    public void correctRegistrationAndLogOut(){
        loginPage = page(LoginPage.class);
        homePage = page(HomePage.class);
        registrationPage.register("test","test@1te.q1oo","111111");
        loginPage.waitForLoadLoginPage();
        loginPage.logIn(registrationPage.getEmail(), registrationPage.getPass());
        homePage.clickPersonalAccount();
        profilePage = page(ProfilePage.class);
        profilePage.waitForLoadProfilePage();
        profilePage.clickLogOutButton();
    }
}