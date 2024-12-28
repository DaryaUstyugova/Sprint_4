package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScooterHomePage {

    private WebDriver driver;

    // URL домашней страницы "Яндекс Самокат"
    public static final String HOME_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    // Кнопка "Заказать" в шапке страницы
    private By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // Кнопка "Заказать" в теле страницы
    private By middleOrderButton = By.className("Button_Middle__1CSJM");

    // Раскрывающийся список "Вопросы о важном"
    private By importantQuestionsBlock = By.className("accordion__heading");

    // Ответы на вопросы в раскрывающемся списке "Вопросы о важном"
    private By answer = By.xpath(".//div[@class='accordion__panel']/p");

    // Кнопка принятия Cookie
    private By agreeCookie = By.className("App_CookieButton__3cvqF");

    public ScooterHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для нажатия на кнопку принятия Cookie
    public void clickCookieButton() {
        driver.findElement(agreeCookie).click();
    }

    //Метод для нажатия на кнопку "Заказать" в шапке страницы
    public void clickOrderButtonHeader() {
        driver.findElement(headerOrderButton).click();
    }

    //Метод для нажатия на кнопку "Заказать" в теле страницы, включая прокрутку до элемента
    public void clickOrderButtonMiddle() {
        WebElement middleButton = driver.findElement(middleOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", middleButton);
        driver.findElement(middleOrderButton).click();
    }

    // Метод для прокрутки страницы к блоку "Вопросы о важном"
    public void scrollToQuestionBlock() {
        WebElement questionBlock = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionBlock);
    }

    // Метод для раскрытия элементов списка
    public void clickQuestionsBlock(int index) {
        driver.findElements(importantQuestionsBlock).get(index).click();
    }

    // Метод для получения текста ответа
    public String getAnswerText(int index) {
        return driver.findElements(answer).get(index).getText();
    }

}


