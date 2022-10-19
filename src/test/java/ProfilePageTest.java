import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.User;
import config.UserClient;
import extensions.DriverFactory;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static config.Config.*;
public class ProfilePageTest {
    HomePage homePage;
    User user;
    String email;
    String pass;
    LoginPage loginPage;
    UserClient userClient;
    String accessToken;
    ProfilePage profilePage;
    DriverFactory driverFactory;


    @Before
    public void startUp() {
        driverFactory = new DriverFactory();
        WebDriverRunner.setWebDriver(driverFactory.getBrowser());
        user = User.getRandomRegister();
        userClient = new UserClient();
        accessToken = userClient.create(user).extract().path("accessToken");
        email = user.getEmail();
        pass = user.getPassword();
        loginPage = open(LOGIN, LoginPage.class);
        loginPage.logIn(email, pass);
        profilePage = page(ProfilePage.class);
        homePage = page(HomePage.class);

    }

    @After
    public void tearDown() {
        userClient.delete(user, accessToken);
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccountFromHomePage() {
        homePage.clickPersonalAccount();
        webdriver().shouldHave(url(PROFILE));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через лого Stellar Burgers")
    public void goToHomePageByClickLogo() {
        homePage.clickPersonalAccount();
        profilePage.clickLogo();
        webdriver().shouldHave(url(URL));
    }
    @Test
    @DisplayName("Выйти из профиля в личном кабинете")
    public void logOutFromProfile() {
        homePage.clickPersonalAccount();
        profilePage.clickLogOutButton();
        webdriver().shouldHave(url(LOGIN));
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор через лого конструктора")
    public void goToHomePageByClickConstructor() {
        homePage.clickPersonalAccount();
        profilePage.clickConstructorLogo();
        webdriver().shouldHave(url(URL));
    }
}