import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page_objects.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterTests {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private final String buttonType;
    private final String name;
    private final String lastName;
    private final String address;
    private final int metroStationIndex;
    private final String phone;
    private final String date;
    private final int rentalDays;
    private final String color;

    public ScooterTests(String buttonType, String name, String lastName,//тест формы поолностью
                        String address, int metroStationIndex, String phone,
                        String date, int rentalDays, String color) {
        this.buttonType = buttonType;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStationIndex = metroStationIndex;
        this.phone = phone;
        this.date = date;
        this.rentalDays = rentalDays;
        this.color = color;
    }

    @Parameterized.Parameters()
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"top", "Ильназ", "Шарипов", "Москва", 1, "89000000000", "01.10.2026", 1, "black"},
                {"bottom", "Шарипов", "Ильназ", "Питер", 3, "79997654321", "02.10.2026", 2, "grey"},
        };
    }
    @Test
    public void orderScooterTest() {
        WebDriver driver = driverFactory.getDriver();

        MainPage mainPage = new MainPage(driver);//главная страница
        mainPage.openSite();
        if ("top".equals(buttonType)) {//если указан top то нажатие по верхней кнопке
            mainPage.topButtonToOrderClick();
        } else {
            mainPage.bottomButtonToOrderClick();//иначе по нижней
        }

        RegistrationPage regPage = new RegistrationPage(driver);//окно "Для кого самокат"
        regPage.enterName(name);
        regPage.enterLastName(lastName);
        regPage.enterAdress(address);
        regPage.metroStationFieldClick();
        driver.findElement(regPage.enterMetroStation(metroStationIndex)).click();
        regPage.enterPhone(phone);
        regPage.buttonNextClick();

        RentPage rentPage = new RentPage(driver);//окно аренды
        rentPage.enterDate(date);
        rentPage.fieldArendTimeClick();
        rentPage.enterQuantityOfDays(rentalDays);
        if ("black".equals(color)) {
            rentPage.ScooterColorBlackClick();
        } else {
            rentPage.ScooterColorGrayClick();
        }
        rentPage.OrderButtonClick();

        ChooseWindow chooseWindow = new ChooseWindow(driver);//окно "Хотите оформить заказ?"
        chooseWindow.OrderButtonClick();

        TheOrderHasBeenPlacedWindow resultWindow = new TheOrderHasBeenPlacedWindow(driver);//итоговая проверка что окно появилось
        assertTrue(resultWindow.isOrderWindowDisplayed());
    }
}
