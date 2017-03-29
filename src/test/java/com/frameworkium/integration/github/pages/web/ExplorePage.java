package com.frameworkium.integration.github.pages.web;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.integration.github.pages.web.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ExplorePage extends BasePage<ExplorePage> {

    @Visible
    @Name("Header")
    private HeaderComponent header;

    @Visible
    @Name("Explore Content")
    @FindBy(css = "div.explore-marketing-header")
    private WebElement marketingBanner;

    @Step("Navigate directly to the Github explore page")
    public static ExplorePage open() {
        return PageFactory.newInstance(ExplorePage.class, "https://github.com/explore");
    }

    public void waitForSomething() {
        wait.until(visibilityOfElementLocated(By.cssSelector("body")));
    }

    public HeaderComponent theHeader() {
        return header;
    }
}
