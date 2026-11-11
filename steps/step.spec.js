import { createBdd } from "playwright-bdd";
import { LoginPage } from "../pages/LoginPage";


const { Given, When, Then, Before } = createBdd();

/** @type {LoginPage} */
let loginPage;

Before(async ({ page }) => {
  loginPage = new LoginPage(page);
});


Given("User is on login page", async ({ page }) => {
  await loginPage.navigateToLoginPage();
});

When("User enters valid user name and password", async ({ page }) => {
  await loginPage.enterUsername("student");
  await loginPage.enterPassword("Password123");
});

Then("User click on login button", async ({ page }) => {
  await loginPage.clickLoginButton();
});