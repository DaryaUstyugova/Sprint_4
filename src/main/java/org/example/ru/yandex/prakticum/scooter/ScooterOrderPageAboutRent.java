package org.example.ru.yandex.prakticum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterOrderPageAboutRent {

    private final WebDriver driver;

    // Форма заказа "Про Аренду"
    private final By orderFormRent = By.className("Order_Content__bmtHS");

    // Поле "Дата"
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Селектор с выбором даты
    private final By dateSelected = By.className("react-datepicker__day--selected");

    // Поле "Срок Аренды"
    private final By rentalPeriod = By.className("Dropdown-control");

    // Поле "Комментарий"
    private final By commentToTheCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать" в теле страницы
    private final By orderConfirmationButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // Кнопка "Да" в окне подтверждения заказа
    private final By yesButton = By.xpath(".//button[text()='Да']");

    // Окно с информацией о созданном заказе
    private final By orderConfirmWindow = By.className("Order_ModalHeader__3FDaJ");

    public ScooterOrderPageAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки окна "Про аренду"
    public void waitForLoadOrderRentPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderFormRent)));
    }

    // Метод заполнения поля "Дата"
    public void inputDate(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateSelected).click();
    }

    // Метод заполнения поля "Срок аренды"
    public void chooseRentalPeriod(String rent) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[text()='" + rent + "']")).click();
    }

    // Метод выбора цвета самоката
    public void chooseColour(String colour) {
        driver.findElement(By.xpath(".//label[text()='" + colour + "']")).click();
    }

    // Метод заполнения поля "Комментарий"
    public void inputComment(String comment) {
        driver.findElement(commentToTheCourier).sendKeys(comment);
    }

    // Метод для нажатия на кнопку "Заказать" в теле страницы
    public void clickToOrderConfirmationButton() {
        driver.findElement(orderConfirmationButton).click();
    }

    // Метод для нажатия на кнопку "Да" в окне подтверждения заказа
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    // Метод получения текста "Заказ оформлен" в окне с информацией о заказе
    public String getOrderConfirm() {
        return driver.findElement(orderConfirmWindow).getText();
    }

}
