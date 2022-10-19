import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;

public class HomePage {
    //локатор кнопки "личный кабинет"
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement personalAccount;
    //локатор кнопки оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement placeAnOrder;
    //локатор кнопки "войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement logInAccountButton;
    //локатор кнопки "соусы"
    @FindBy(how = How.XPATH, using = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[2]")
    private SelenideElement sauceButton;
    //локатор кнопки "начинки"
    @FindBy(how = How.XPATH, using = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[3]")
    private SelenideElement fillingsButton;
    //локатор кнопки "булки"
    @FindBy(how = How.XPATH, using = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[1]")
    private SelenideElement bunButton;
    //локатор выбора категории в конструкторе
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private SelenideElement categoryChoose;


    public String getTextCategoryChoose(){
        return categoryChoose.text();
    }
    public void clickSauceButton(){
        sauceButton.click();
    }
    public void clickFillingsButton(){
        fillingsButton.click();
    }
    public void clickBunButton(){
        bunButton.click();
    }
    public void clickPersonalAccount(){
        personalAccount.click();
    }
    public void clickLogInAccountButton(){
        logInAccountButton.click();
    }
    public void placeAnOrderButtonVisible(){
        placeAnOrder.shouldBe(visible);
    }
}