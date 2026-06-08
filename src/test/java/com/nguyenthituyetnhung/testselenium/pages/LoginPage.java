// package com.nguyenthituyetnhung.testselenium.pages;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.springframework.stereotype.Component;

// @Component
// public class LoginPage {

//     private final WebDriver driver;

//     // Locators
//     private final By usernameField = By.id("username");
//     private final By passwordField = By.id("password");
//     private final By loginButton   = By.cssSelector("button[type='submit']");
//     private final By errorMessage  = By.className("error-message");

//     public LoginPage(WebDriver driver) {
//         this.driver = driver;
//     }

//     public void navigateTo(String url) {
//         driver.get(url);
//     }

//     public void enterUsername(String username) {
//         driver.findElement(usernameField).clear();
//         driver.findElement(usernameField).sendKeys(username);
//     }

//     public void enterPassword(String password) {
//         driver.findElement(passwordField).clear();
//         driver.findElement(passwordField).sendKeys(password);
//     }

//     public void clickLogin() {
//         driver.findElement(loginButton).click();
//     }

//     public String getErrorMessage() {
//         WebElement el = driver.findElement(errorMessage);
//         return el.getText();
//     }

//     public String getCurrentUrl() {
//         return driver.getCurrentUrl();
//     }
// }