package org.example.ru.yandex.prakticum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterOrderPageForWhom {

    private final WebDriver driver;

    // Форма заказа
    private final By orderForm = By.className("Order_Content__bmtHS");

    // Поле "Имя"
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // Поле "Фамилия"
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле "Адрес"
    private final By AddressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле с выпадающим списком "Метро"
    private final By metroStationField = By.className("select-search__input");

    // Поле "Телефон"
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private final By nextButton = By.className("Button_Middle__1CSJM");

    public ScooterOrderPageForWhom(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки формы заказа
    public void waitForLoadOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderForm)));
    }

    // Метод заполнения поля "Имя"
    public void sendToNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Метод заполнения поля "Фамилия"
    public void sendToSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    // Метод заполнения поля "Адрес"
    public void sendToAddressField(String address) {
        driver.findElement(AddressField).sendKeys(address);
    }

    // Метод выбора станции метро в выпадающем списке
    public void clickToMetroStationField(String metro) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//div[text()='" + metro + "']")).click();
    }

    // Метод заполнения поля "Телефон"
    public void sendToPhoneNumberField(String phone) {
        driver.findElement(phoneNumberField).sendKeys(phone);
    }

    // Метод для нажатия кнопки "Далее
    public void clickToNextButton() {
        driver.findElement(nextButton).click();
    }
}
