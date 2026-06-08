package com.nguyenthituyetnhung.testselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TluLoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // ✅ Locator chính xác từ HTML thật
    private final By usernameField = By.id("username");
    private final By passwordField = By.cssSelector("input[type='password']");
    private final By loginButton   = By.cssSelector("button[data-ng-click='vm.login()']");

    public TluLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateTo() {
        driver.get("https://sinhvien1.tlu.edu.vn/#/login");
    }

    public void enterUsername(String username) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        el.clear();
        el.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        el.clear();
        el.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccess() {
        try {
            wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("/login")
            ));
            return !driver.getCurrentUrl().contains("/login");
        } catch (Exception e) {
            return false;
        }
    }
}