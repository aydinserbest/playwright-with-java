package org.example.playwright.tutorial;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddToCartTest extends PlaywrightBaseTest{
    Page page;

    @BeforeEach
    void login() {
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        page.fill("input#user-name", "standard_user");
        page.fill("input#password", "secret_sauce");
        page.click("input#login-button");
    }
    @AfterEach
    void closePage() {
        page.close();
    }

    @Test
    void shouldAddItemToCart() {
        // Launching the browser in non-headless mode for visibility
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        login();
        Locator productItem = page.locator(".inventory_item:has-text('Sauce Labs Bolt T-Shirt')");
        Locator addToCartButton = productItem.locator("button");
        addToCartButton.click();
        System.out.println(addToCartButton.textContent());
        page.locator(".shopping_cart_badge").click();
        Locator cart_item = page.locator(".inventory_item_name");
        assertThat(cart_item).hasText("Sauce Labs Bolt T-Shirt");
    }
}


