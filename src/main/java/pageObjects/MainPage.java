package pageObjects;
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

    private  final  By topButtonToOrder = By.xpath(".//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']"); //лок на верхнюю кнопку "Заказать"

    private  final  By bottomButtonToOrder = By.xpath(".//div[contains(@class, 'Home_FinishButton')]//button[contains(@class, 'Button_Middle') and text()='Заказать']"); // лок на нижнюю кнопку "Заказать"

    public void openSite(){
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открываем сайт
        driver.findElement(By.id("rcc-confirm-button")).click(); //закрыть попап
    }

    public void listClick(String listId) {
        driver.findElement(By.id(listId)).click();//найти и кликнуть на список
    }
        public boolean isAnswerDisplayed (String answerId){
            return driver.findElement(By.id(answerId)).isDisplayed();//проверка что отображается
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

    public boolean checkAnswerContent(String answerId, String expectedContent) {
        WebElement answerElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerId)));//находим и ждем 5 сек до видимости
        String actualContent = answerElement.getText();//получаем текст
        return actualContent.contains(expectedContent);//проверка ожидаемого и фактического текста
    }
}
