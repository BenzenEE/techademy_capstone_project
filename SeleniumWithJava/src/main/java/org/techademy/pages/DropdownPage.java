package org.techademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOption(String option){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }
    public String getOptionSelected(String option){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        WebElement selectedOption = select.getFirstSelectedOption();
        return selectedOption.getText();
    }
}
