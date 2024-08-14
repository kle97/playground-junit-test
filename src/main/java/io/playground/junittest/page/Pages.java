package io.playground.junittest.page;

import org.openqa.selenium.WebDriver;

public class Pages {
    
    private Pages() {}
    
    public static EntityPage getEntityPage(WebDriver driver) {
        return new EntityPage(driver);
    }
}
