import {expect} from '@playwright/test'
import {BasePage} from './BasePage'

export class LoginPage extends BasePage {
    /** @param {import('@playwright/test').Page} page */
    constructor(page) {
        super(page)
        this.usernameInput = page.locator("//input[@id='username']")
        this.passwordInput = page.locator("//input[@id='password']")
        this.loginButton = page.locator("//button[@id='submit']")
    }

    async navigateToLoginPage() {
        await this.navigate('https://practicetestautomation.com/practice-test-login/')
    }

    async enterUsername(username) {
        await this.fillInputField(this.usernameInput, username)
        await expect(this.usernameInput).toHaveValue(username)
    }

    async enterPassword(password) {
        await this.fillInputField(this.passwordInput, password)
        await expect(this.passwordInput).toHaveValue(password)
    }

    async clickLoginButton() {
        await this.clickElement(this.loginButton)
    }
}