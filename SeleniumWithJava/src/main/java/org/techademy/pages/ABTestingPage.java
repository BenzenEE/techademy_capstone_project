package org.techademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ABTestingPage {
    private WebDriver driver;

    public ABTestingPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/h3")));
        return element.getText();
    }
    public void navigateBack(){
        driver.navigate().back();
    }
}
