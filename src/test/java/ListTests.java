import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjects.MainPage;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ListTests {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private final String listId;
    private final String answerId;
    private final String expectedContent;

    public ListTests(String listId, String answerId, String expectedContent) {
        this.listId = listId;
        this.answerId = answerId;
        this.expectedContent = expectedContent;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"accordion__heading-0", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"accordion__heading-1", "accordion__panel-1", "Пока что у нас так: один заказ — один самокат."},
                {"accordion__heading-2", "accordion__panel-2", "Допустим, вы оформляете заказ на 8 мая."},
                {"accordion__heading-3", "accordion__panel-3", "Только начиная с завтрашнего дня."},
                {"accordion__heading-4", "accordion__panel-4", "Пока что нет!"},
                {"accordion__heading-5", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой."},
                {"accordion__heading-6", "accordion__panel-6", "Да, пока самокат не привезли."},
                {"accordion__heading-7", "accordion__panel-7", "Да, обязательно."}
        });
    }

    @Test
    public void testListContent() {
        MainPage mainPage = new MainPage(driverFactory.getDriver());
        mainPage.openSite();//опен сайт
        mainPage.listClick(listId); // нажимаем по ID
        assertTrue(mainPage.isAnswerDisplayed(answerId));//проверка что отображается на странице
        assertTrue( mainPage.checkAnswerContent(answerId, expectedContent));//проверка текста
    }
}