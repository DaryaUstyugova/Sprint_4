import org.example.pageObject.ScooterHomePage;
import org.example.pageObject.ScooterOrderPageAboutRent;
import org.example.pageObject.ScooterOrderPageForWhom;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class ScooterOrderPageTest {

    private WebDriver driver;

    private final String orderConfirmMessage = "Заказ оформлен";

    private final String name, surname, address, metro, phone, date, rent, colour, comment;

    public ScooterOrderPageTest(String name, String surname, String address, String metro, String phone, String date, String rent, String colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rent = rent;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Процесс оформления заказа")
    public static Object[][] orderData() {
        return new Object[][]{
                {"Фродо", "Бэггинс", "Шир, Бэг Энд", "Чистые пруды", "87776665544", "10.01.2027", "семеро суток", "чёрный жемчуг", "Можно добавить корзинку для второго завтрака?"},
                {"Гэндальф", "Серый", "Оставьте где хотите", "Сокольники", "99999999999", "01.01.2027", "сутки", "серая безысходность", "Покрепче, буду ездить с хоббитом"},
        };
    }

    @Before
    public void firstStep() {
        this.driver = new ChromeDriver();
//        this.driver = new FirefoxDriver();
        this.driver.get(ScooterHomePage.HOME_PAGE_URL);
    }

    @Test
    public void createOrderWithHeaderOrderButtonTest() {

        ScooterHomePage objScooterHomePage = new ScooterHomePage(driver);
        ScooterOrderPageForWhom objScooterOrderPageForWhom = new ScooterOrderPageForWhom(driver);
        ScooterOrderPageAboutRent objScooterOrderPageAboutRent = new ScooterOrderPageAboutRent(driver);

        objScooterHomePage.clickCookieButton();
        objScooterHomePage.clickOrderButtonHeader();
        objScooterOrderPageForWhom.waitForLoadOrderPage();
        orderPage(objScooterOrderPageForWhom, objScooterOrderPageAboutRent);

        MatcherAssert.assertThat("Заказ не оформлен", objScooterOrderPageAboutRent.getOrderConfirm(), containsString(this.orderConfirmMessage));

    }

    @Test
    public void createOrderWithMiddleOrderButtonTest() {


       ScooterHomePage objScooterHomePage = new ScooterHomePage(driver);
       ScooterOrderPageForWhom objScooterOrderPageForWhom = new ScooterOrderPageForWhom(driver);
       ScooterOrderPageAboutRent objScooterOrderPageAboutRent = new ScooterOrderPageAboutRent(driver);

       objScooterHomePage.clickCookieButton();
       objScooterHomePage.clickOrderButtonMiddle();
       objScooterOrderPageForWhom.waitForLoadOrderPage();
       orderPage(objScooterOrderPageForWhom, objScooterOrderPageAboutRent);

       MatcherAssert.assertThat("Заказ не оформлен", objScooterOrderPageAboutRent.getOrderConfirm(), containsString(this.orderConfirmMessage));

    }

    @After
    public void finishStep() {
        this.driver.quit();
    }


    private void orderPage(ScooterOrderPageForWhom objScooterOrderPageForWhom, ScooterOrderPageAboutRent objScooterOrderPageAboutRent) {
       objScooterOrderPageForWhom.sendToNameField(this.name);
       objScooterOrderPageForWhom.sendToSurnameField(this.surname);
       objScooterOrderPageForWhom.sendToAddressField(this.address);
       objScooterOrderPageForWhom.clickToMetroStationField(this.metro);
       objScooterOrderPageForWhom.sendToPhoneNumberField(this.phone);
       objScooterOrderPageForWhom.clickToNextButton();
       objScooterOrderPageAboutRent.waitForLoadOrderRentPage();
       objScooterOrderPageAboutRent.inputDate(this.date);
       objScooterOrderPageAboutRent.chooseRentalPeriod(this.rent);
       objScooterOrderPageAboutRent.chooseColour(this.colour);
       objScooterOrderPageAboutRent.inputComment(this.comment);
       objScooterOrderPageAboutRent.clickToOrderConfirmationButton();
       objScooterOrderPageAboutRent.clickYesButton();
    }

}