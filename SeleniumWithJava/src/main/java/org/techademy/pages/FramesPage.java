package org.techademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLinkPresent(String linkText){
        return !driver.findElements(By.linkText(linkText)).isEmpty();
    }
}
