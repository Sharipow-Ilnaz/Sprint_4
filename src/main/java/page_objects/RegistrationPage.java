package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {//окно "Для кого самокат"

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By fieldName = By.xpath(".//input[@placeholder='* Имя']"); //лок на поле имя

    private final By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']"); //лок на поле фамилия

    private final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //лок на поле адреса

    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']"); //лок на выпадающий список метро

    private final By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //лок на поле номера телефона

    private final By buttonNext = By.xpath(".//button[text()='Далее']"); //лок на кнопку "Далее"


    public void enterName(String name) {
        driver.findElement(fieldName).sendKeys(name); //ввести имя
    }

    public void enterLastName(String Lastname) {
        driver.findElement(fieldLastName).sendKeys(Lastname); //ввести фамилию
    }

    public void enterAdress(String adress) {
        driver.findElement(fieldAddress).sendKeys(adress); //ввести адресс
    }

    public void enterPhone(String phone) {
        driver.findElement(fieldPhone).sendKeys(phone); //ввести номер телефона
    }

    public void metroStationFieldClick() {
        driver.findElement(metroStationField).click(); //нажать на выпадающий список метро
    }

    public void buttonNextClick() {
        driver.findElement(buttonNext).click(); //нажать на кнопку "Далее"
    }

    public By enterMetroStation(int value) {
        return By.xpath(".//li[@data-value='" + value + "']");//выбор станции метро в зависсимссти от значения value  в devtools
    }
}