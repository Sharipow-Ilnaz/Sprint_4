package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MainPage {//главная страница

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    private final By listOfImportantThings = By.id("accordion__heading-0"); //лок на выпадающий список;

    private  final By answerText = By.id("accordion__panel-0"); //лок на текст ответа

    private  final  By topButtonToOrder = By.xpath(".//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']"); //лок на верхнюю кнопку "Заказать"

    private  final  By bottomButtonToOrder = By.xpath(".//div[contains(@class, 'Home_FinishButton')]//button[contains(@class, 'Button_Middle') and text()='Заказать']"); // лок на нижнюю кнопку "Заказать"

    public void openSite(){
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открываем сайт
        driver.findElement(By.id("rcc-confirm-button")).click(); //закрыть попап
    }

    public void listClick (){
        driver.findElement(listOfImportantThings).click(); //нажать на выпадающий список
    }

    public boolean isAnswerDisplayed(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))//проверка что лист отображается через 5 сек
                .until(ExpectedConditions.visibilityOfElementLocated(answerText)).isDisplayed();
    }

    public void topButtonToOrderClick (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(topButtonToOrder)).click(); //нажать на верхнюю кнопку "Заказать" через 5 сек
    }

    public void bottomButtonToOrderClick(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bottomButtonToOrder));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);//пролистнуть до кнопки
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);//нажать на нижнюю кнопку через 5 секунд
    }
}
