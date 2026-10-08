import org.junit.Rule;
import org.junit.Test;
import page_objects.MainPage;

import static org.junit.Assert.assertTrue;

public class ListTests {//тест на выпадающий список

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void ListOpensTest() {
        MainPage mainPage = new MainPage(driverFactory.getDriver());
        mainPage.openSite();//открыть сайт
        mainPage.listClick();//нажать на выпадающий список
        assertTrue( mainPage.isAnswerDisplayed());//проверка что открылся список
    }
}
