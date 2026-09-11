package com.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FixturesandHooks {
static Playwright playwright;
static Browser browser;
Page page;

@BeforeAll
static void beforeAll() {
playwright = Playwright.create();
browser = playwright.chromium().launch(
new BrowserType.LaunchOptions().setHeadless(false));

System.out.println("Browser Started");
}

@BeforeEach
void setup() {
page = browser.newPage();
System.out.println("New Page Created");
}

@Test
@Order(1)
void loginTest() {
page.navigate("https://practicetestautomation.com/practice-test-login/");
System.out.println("1st Test Started");
page.fill("#username", "student");
page.fill("#password", "Password123");
page.click("#submit");

System.out.println(page.locator(".post-title").textContent());
}
@Test
@Order(2)
void loginTest1() {
page.navigate("https://practicetestautomation.com/practice-test-login/");
System.out.println("2nd Test Started");
page.fill("#username", "student");
page.fill("#password", "Password123");
page.click("#submit");

System.out.println(page.locator(".post-title").textContent());
}
@AfterEach
void tearDown() {
page.close();
System.out.println("Page Closed");
}
@AfterAll
static void afterAll() {
browser.close();
playwright.close();
System.out.println("Browser Closed");
}
}