import {expect} from '@playwright/test'

export class BasePage {
    /** @param {import('@playwright/test').Page} page */   
    constructor(page) {
        this.page = page
    }

    async navigate(url) {
        await this.page.goto(url)
    }

    async clickElement(element) {
        await expect(element).toBeVisible({timeout: 10000})
        await element.click()
    }

    async fillInputField(element, text) {
        await expect(element).toBeVisible({timeout: 10000})
        await element.fill(text)
    }
}