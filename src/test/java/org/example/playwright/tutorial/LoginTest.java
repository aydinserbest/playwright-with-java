package org.example.playwright.tutorial;

import com.microsoft.playwright.Locator;
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
        page.navigate("https://www.saucedemo.com");
        //page.fill("input#user-name", "standard_user");
       // page.click("input#login-button");
        //page.click("text=Login");
        //page.getByText("Login").click();
        Locator userName = page.locator("input#user-name");
        userName.fill("standard_user");
        Locator password = page.locator("input#password");
       // password.fill("secret_sauce");
        Locator loginButton = page.locator("input#login-button");
        loginButton.click();

        assertThat(page.locator("h3")).containsText("Epic sadface: Password is required");
    }
    @Test
    void locateFromParentToChild() {
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");

        Locator parent = page.locator(".form_input");
        Locator child = parent.nth(0);
        child.fill("standard_user");
        Locator password = parent.nth(1);
        password.fill("secret_sauce");
        Locator loginButton = page.locator("input#login-button");
        loginButton.click();

    }
    @Test
    void locateNested() {
        // Creating a new page and navigating to the website
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");

        // Locating the container (login-box) that contains both the username and password input fields
        Locator loginBox = page.locator(".login-box");

        // Locating the input field for the username within the login-box and filling in the credentials
        Locator userName = loginBox.locator("input#user-name");
        userName.fill("standard_user");

        // Locating the input field for the password within the login-box and filling in the credentials
        Locator password = loginBox.locator("input#password");
        password.fill("secret_sauce");

        // Locating the login button and clicking to submit the form
        Locator loginButton = page.locator("input#login-button");
        loginButton.click();

    }

}
