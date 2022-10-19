import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.User;
import config.UserClient;
import extensions.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.*;
import static config.Config.*;

public class LogInTest {
    User user;
    UserClient userClient;
    String email;
    String pass;
    HomePage homePage;
    LoginPage loginPage;
    String accessToken;
    DriverFactory driverFactory;

    @Before
    public void startUp(){
        WebDriverRunner.setWebDriver(driverFactory.getBrowser());
        user= User.getRandomRegister();
        userClient = new UserClient();
        accessToken = userClient.create(user).extract().path("accessToken");
        email = user.getEmail();
        pass = user.getPassword();
        loginPage = page(LoginPage.class);
    }
    @After
    public void tearDown(){
        userClient.delete(user, accessToken);
        Selenide.closeWebDriver();
    }


    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void signInPersonalAccountButton(){
        homePage = open(URL, HomePage.class);
        homePage.clickPersonalAccount();
        loginPage.logIn(email, pass);
        homePage.placeAnOrderButtonVisible();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void signInLogInAccountButton(){
        homePage = open(URL, HomePage.class);
        homePage.clickLogInAccountButton();
        loginPage.logIn(email, pass);
        homePage.placeAnOrderButtonVisible();
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInFromRegisterPage(){
        RegistrationPage registrationPage = open(REGISTRATION, RegistrationPage.class);
        registrationPage.clickSignIn();
        loginPage.logIn(email, pass);
        homePage = page(HomePage.class);
        homePage.placeAnOrderButtonVisible();
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInFromForgotPassPage(){
        ForgotPassPage forgotPassPage = open(FORGOT_PASS, ForgotPassPage.class);
        forgotPassPage.clickSignIn();
        loginPage.logIn(email, pass);
        homePage = page(HomePage.class);
        homePage.placeAnOrderButtonVisible();
    }
}