package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseWindow {//окно "Хотите оформить заказ?"

    private WebDriver driver;

    public ChooseWindow(WebDriver driver) {
        this.driver=driver;
    }

    private final By YesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Да']");//локатор кнопки "Да"

    public void OrderButtonClick (){
        driver.findElement(YesButton).click(); //нажать на кнопку "Да"
    }
}
