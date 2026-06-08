// package com.nguyenthituyetnhung.testselenium.tests;

// import com.nguyenthituyetnhung.testselenium.pages.LoginPage;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import org.junit.jupiter.api.*;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// class LoginTest {

//     private WebDriver driver;
//     private LoginPage loginPage;

//     @BeforeAll
//     void setUp() {
//         WebDriverManager.chromedriver().setup();
//         ChromeOptions options = new ChromeOptions();
//         options.addArguments("--start-maximized");
//         driver = new ChromeDriver(options);
//         loginPage = new LoginPage(driver);
//     }

//     @AfterAll
//     void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }

//     @Test
//     @DisplayName("Test login thành công")
//     void testLoginSuccess() {
//         loginPage.navigateTo("https://the-internet.herokuapp.com/login");
//         loginPage.enterUsername("tomsmith");
//         loginPage.enterPassword("SuperSecretPassword!");
//         loginPage.clickLogin();

//         String currentUrl = loginPage.getCurrentUrl();
//         Assertions.assertTrue(currentUrl.contains("/secure"),
//             "Sau khi login thành công phải redirect tới /secure");
//     }

//     @Test
//     @DisplayName("Test login thất bại — sai password")
//     void testLoginFailure() {
//         loginPage.navigateTo("https://the-internet.herokuapp.com/login");
//         loginPage.enterUsername("tomsmith");
//         loginPage.enterPassword("wrongpassword");
//         loginPage.clickLogin();

//         String error = loginPage.getErrorMessage();
//         Assertions.assertTrue(error.contains("Your password is invalid"),
//             "Phải hiển thị thông báo lỗi sai password");
//     }
// }