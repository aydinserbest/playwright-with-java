package org.example.playwright.tutorial;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class HomePageTest extends PlaywrightBaseTest {

    @Test
    public void shouldPlayTheHomePageTitle() {
        var page = browser.newPage();
        page.navigate("https://www.saucedemo.com/v1/");
        System.out.println(page.title());

        // Explicitly asserting that the page title is equal to "Swag Labs" using AssertJ assertions library
        Assertions.assertThat(page.title()).isEqualTo("Swag Labs");
    }

    @Test
    void shouldDisplayTheLoginFormOnTheHomePage() {
        var page = browser.newPage();
        page.navigate("https://www.saucedemo.com/v1/");

        // Implicitly asserting the visibility of elements using Playwright's isVisible() method
        assertThat(page.locator("input#user-name")).isVisible();
        assertThat(page.locator("input#password")).isVisible();
        assertThat(page.locator("input#login-button")).isVisible();
    }
}

