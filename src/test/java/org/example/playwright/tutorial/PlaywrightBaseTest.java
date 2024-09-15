package org.example.playwright.tutorial;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class PlaywrightBaseTest {
    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    static void setUpPlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void tearDownPlaywright() {
        playwright.close();
    }

}
