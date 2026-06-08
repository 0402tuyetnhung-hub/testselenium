package com.nguyenthituyetnhung.testselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverConfig {

    @Bean
    @Scope("prototype") // mỗi test class lấy một instance riêng
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup(); // tự tải chromedriver

        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // bỏ comment nếu muốn chạy ẩn
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }
}