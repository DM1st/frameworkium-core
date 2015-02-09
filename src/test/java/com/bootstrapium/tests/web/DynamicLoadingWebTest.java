package com.bootstrapium.tests.web;

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.Test;
import com.bootstrapium.annotations.Jira;

import com.bootstrapium.pages.web.DynamicLoadingExamplePage;
import com.bootstrapium.pages.web.WelcomePage;
import com.bootstrapium.tests.internal.BaseTest;

public class DynamicLoadingWebTest extends BaseTest {

    @Jira("KT-1")
    @Test(description = "Test element visibility")
    public final void testElementVisibility() {
        //Navigate to the dynamic loading hidden element page
        DynamicLoadingExamplePage dynamicLoadingExamplePage = WelcomePage.open().then().clickDynamicLoading()
                .then().clickExample1();
        
        //Assert that the element is hidden
        assertThat(dynamicLoadingExamplePage.isElementDisplayed()).named("element visibility").isFalse();
        
        //Click start and wait for element to be displayed
        dynamicLoadingExamplePage.clickStart().then().waitForElementToBeDisplayed();
        
        //Assert that the element is indeed displayed
        assertThat(dynamicLoadingExamplePage.isElementDisplayed()).named("element visibility").isTrue();
    }

    @Jira("KT-1")
    @Test(description = "Test element presence")
    public final void testElementPresence() {
      //Navigate to the dynamic loading element not yet rendered page
        DynamicLoadingExamplePage dynamicLoadingExamplePage = WelcomePage.open().then().clickDynamicLoading()
                .then().clickExample2();
        
        //Assert that the element is not present
        assertThat(dynamicLoadingExamplePage.isElementPresent()).named("element presence").isFalse();
        
        //Click start and wait for element to be displayed
        dynamicLoadingExamplePage.clickStart().then().waitForElementToBeDisplayed();
        
        //Assert that the element is indeed present
        assertThat(dynamicLoadingExamplePage.isElementPresent()).named("element presence").isTrue();
    }
}
