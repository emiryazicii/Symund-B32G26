package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "ul#appmenu li")
    private List<WebElement> menuItems;

    // Method to navigate to a specific page from the menu by module name.
    public void navigateToPage(String moduleName) {
        // Iterate through each menu item
        for (WebElement menuItem : menuItems) {
            // Check if the menu item's data-id attribute's value matches the desired link data-id
            if (menuItem.getAttribute("data-id").equals(moduleName.toLowerCase())) {
                // Click on the menu item to navigate
                menuItem.click();
                // Exit the loop once the link is clicked
                break;
            }
        }
    }
}
