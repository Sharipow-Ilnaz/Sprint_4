package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheOrderHasBeenPlacedWindow {//окно "Заказ оформлен"

    private WebDriver driver;

    public TheOrderHasBeenPlacedWindow(WebDriver driver) {
        this.driver=driver;
    }

    private final By TheOrderHasBeenPlaced = By.xpath(".//div[contains(@class, 'Order_Modal')]");//лок на окно "Заказ оформлен"

    public boolean isOrderWindowDisplayed(){
        return driver.findElement(TheOrderHasBeenPlaced).isDisplayed();
    }
}
