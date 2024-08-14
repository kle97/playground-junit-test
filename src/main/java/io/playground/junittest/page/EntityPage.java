package io.playground.junittest.page;

import io.playground.junittest.page.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EntityPage extends BasePage {
    
    @FindBys({
            @FindBy(id = "PokemonPage-HeaderGrouper"),
            @FindBy(tagName = "div"),
            @FindBy(tagName = "h1")
    })
    private WebElement name;

    @FindBys({
            @FindBy(className = "TypeList"),
            @FindBy(tagName = "li"),
            @FindBy(tagName = "a")
    })
    private List<WebElement> types;
    
    public EntityPage(WebDriver driver) {
        super(driver);
    }
    
    public String getName() {
        return name.getText();
    }
    
    public Set<String> getTypes() {
        return types.stream().map(WebElement::getText).filter(type -> !type.isEmpty()).collect(Collectors.toSet());
    }
}
