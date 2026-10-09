package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RentPage {//окно аренды

    private WebDriver driver;

    public RentPage(WebDriver driver){
        this.driver=driver;
    }

    private final By fieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //лок выбора даты, когда привезут самокат

    private final By fieldArendTime = By.xpath(".//div[@class='Dropdown-control']"); //лок выбора срока хранения

    private final By ScooterColorBlack = By.xpath(".//label[@for='black']"); //лок на выбор черного цвета самоката

    private final By ScooterColorGrey = By.xpath(".//label[@for='grey']"); //лок на выбор серого цвета самоката

    private final By OrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]//button[contains(@class, 'Button_Middle') and text()='Заказать']"); //лок на кнопку "Заказать"

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void enterDate (String date){
        WebElement dateField = getWait().until(ExpectedConditions.visibilityOfElementLocated(fieldDate));
        dateField.sendKeys(date);//ввод даты если видно элемент
        dateField.sendKeys(Keys.ENTER);//закрыть форму ввода даты
    }

    public void fieldArendTimeClick(){
        getWait().until(ExpectedConditions.elementToBeClickable(fieldArendTime)).click();
    } //нажать на выпадающий список дней хранения


    public void enterQuantityOfDays(int quantityOfDays) {
        String[] daysText = {"", "сутки", "двое суток", "трое суток", "четверо суток", "пятеро суток", "шестеро суток", "семеро суток"};
        getWait().until(ExpectedConditions.elementToBeClickable(//подождать до кликабельности
                By.xpath(".//div[text()='" + daysText[quantityOfDays] + "']"))).click();//выбрать дату в зависсимости от текста в devtools
    }

    public void ScooterColorBlackClick (){
        driver.findElement(ScooterColorBlack).click(); //нажать черный цвет самоката
    }

    public void ScooterColorGrayClick (){
        driver.findElement(ScooterColorGrey).click(); //нажать серый цвет самоката
    }

    public void OrderButtonClick (){
        driver.findElement(OrderButton).click(); //нажать на кнопку "Заказать"
    }
}
