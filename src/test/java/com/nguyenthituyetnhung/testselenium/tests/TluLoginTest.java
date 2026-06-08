package com.nguyenthituyetnhung.testselenium.tests;

import com.nguyenthituyetnhung.testselenium.pages.TluLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TluLoginTest {

    private WebDriver driver;
    private TluLoginPage loginPage;

    // ← Điền thông tin của bạn vào đây, KHÔNG share code này
    private static final String USERNAME = "2351067090";
    private static final String PASSWORD = "huakhanhduy2005@+(";

    @BeforeAll
    void setUp() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    
    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    
    driver = new ChromeDriver(options);
    loginPage = new TluLoginPage(driver);
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Đăng nhập thành công với tài khoản hợp lệ")
    void testDangNhapThanhCong() throws InterruptedException {
        loginPage.navigateTo();
        Thread.sleep(3000); // chờ Angular load

        loginPage.enterUsername(USERNAME);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();

        Thread.sleep(2000); // chờ redirect
        boolean success = loginPage.isLoginSuccess();
        Assertions.assertTrue(success, "Đăng nhập phải thành công!");
    }

    @Test
    @DisplayName("Đăng nhập thất bại với sai mật khẩu")
    void testDangNhapThatBai() throws InterruptedException {
        loginPage.navigateTo();
        Thread.sleep(2000);

        loginPage.enterUsername(USERNAME);
        loginPage.enterPassword("satmatkhau123");
        loginPage.clickLogin();

        Thread.sleep(2000);
        boolean stillOnLogin = driver.getCurrentUrl().contains("/login");
        Assertions.assertTrue(stillOnLogin, "Sai mật khẩu phải ở lại trang login!");
    }
}
