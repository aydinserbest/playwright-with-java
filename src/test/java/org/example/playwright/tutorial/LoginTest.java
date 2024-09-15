package org.example.playwright.tutorial;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LoginTest extends PlaywrightBaseTest {
    @Test
    void shouldDisplayErrorForInvalidCredentials() {
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com/v1/");
        page.fill("input#user-name", "standard_user");
        page.fill("input#password", "invalid_password");
        page.click("input#login-button");
        assertThat(page.locator("h3")).containsText("Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    void passwwordIsmandatory() {
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com/v1/");
        page.fill("input#user-name", "standard_user");
        page.click("input#login-button");
        assertThat(page.locator("h3")).containsText("Epic sadface: Password is required");
    }

}
