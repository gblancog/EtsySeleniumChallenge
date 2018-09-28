import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyObjects {
	
	// Part 1
	
	public WebElement getWelcomeToEtsyPopup(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.visibilityOf(browser.findElement(By.xpath("//img[@src='/images/gdpr/balloons-gdpr.png']"))));
		return browser.findElement(By.xpath("//img[@src='/images/gdpr/balloons-gdpr.png']"));
	}
	
	public WebElement getAcceptConditionsButton(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.visibilityOf(browser.findElement(By.xpath("//button[@data-gdpr-single-choice-accept]"))));
		return browser.findElement(By.xpath("//button[@data-gdpr-single-choice-accept]"));
	}

	public WebElement getMainPageRegisterNowButton(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("register")));
		return browser.findElement(By.id("register"));
	}
	
	public WebElement getRegistrationOverlay(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.visibilityOf(browser.findElement(By.xpath("//div[@class='overlay-body' and ./div[@class='col-group col-flush']]"))));
		return browser.findElement(By.xpath("//div[@class='overlay-body' and ./div[@class='col-group col-flush']]"));
	}	
	
	public WebElement getEmailTextbox(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("join_neu_email_field")));
		return browser.findElement(By.id("join_neu_email_field"));
	}

	public WebElement getNameTextbox(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("join_neu_first_name_field")));
		return browser.findElement(By.id("join_neu_first_name_field"));
	}

	public WebElement getPasswordTextbox(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("join_neu_password_field")));
		return browser.findElement(By.id("join_neu_password_field"));
	}
	
	public WebElement getRegisterMeButton(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("submit_attempt")));
		return browser.findElement(By.name("submit_attempt"));
	}
	
	public WebElement getProfileButton(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-owns='sub-nav-user-navigation']")));
		return browser.findElement(By.xpath("//a[@aria-owns='sub-nav-user-navigation']"));
	}
	
	public WebElement getUserName(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.visibilityOf(browser.findElement(By.className("name"))));
		return browser.findElement(By.className("name"));
	}
	
	// Part 2
	
	public WebElement getMainPageSearchTextbox(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("search-query")));
		return browser.findElement(By.id("search-query"));
	}
	
	public WebElement getSortingCriteriaDropdown(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-button-dropdown-group]/div[@class='text-smaller']")));
		return browser.findElement(By.xpath("//button[@data-button-dropdown-group]/div[@class='text-smaller']"));
	}
	
	public WebElement getSortByPriceAscending(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='list-nav']/li[4]")));
		return browser.findElement(By.xpath("//ul[@class='list-nav']/li[4]"));
	}
	
	public List<WebElement> getPriceFromNonSaleAds(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'block-grid-item') and .//span[contains(@class, 'ad-indicator')]]//p[contains(@class, 'text-body-larger')]/span[@class='currency-value']")));
		return browser.findElements(By.xpath("//li[contains(@class, 'block-grid-item') and .//span[contains(@class, 'ad-indicator')]]//p[contains(@class, 'text-body-larger')]/span[@class='currency-value']"));
	}
	
	public List<WebElement> getPriceFromSaleAds(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'block-grid-item') and .//span[contains(@class, 'ad-indicator')]]//span[contains(@aria-label, '€')]/span[@class='currency-value']")));
		return browser.findElements(By.xpath("//li[contains(@class, 'block-grid-item') and .//span[contains(@class, 'ad-indicator')]]//span[contains(@aria-label, '€')]/span[@class='currency-value']"));
	}
	
	public List<WebElement> getStrikedPriceFromSaleAds(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'block-grid-item') and .//span[contains(@class, 'ad-indicator')]]//span[contains(@class, 'strike-through')]/span[@class='currency-value']")));
		return browser.findElements(By.xpath("//li[contains(@class, 'block-grid-item') and .//span[contains(@class, 'ad-indicator')]]//span[contains(@class, 'strike-through')]/span[@class='currency-value']"));
	}
	
	public List<WebElement> getAllThePrices(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'block-grid-item')]//span[@class='currency-value']")));
		return browser.findElements(By.xpath("//li[contains(@class, 'block-grid-item')]//span[@class='currency-value']"));
	}
	
	public List<WebElement> getSizeDropdown(WebDriver browser) {
		return browser.findElements(By.id("inventory-variation-select-0"));
	}
	
	public WebElement getAddToTheCartButton(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-buy-box")));
		return browser.findElement(By.className("btn-buy-box"));
	}
	
	public WebElement getSubmitOrder(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.visibilityOf(browser.findElement(By.className("submit-button-text"))));
		return browser.findElement(By.className("submit-button-text"));
	}
	
	public WebElement getCartPreviewButton(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='account-nav apply-nav-height']//li[@class='cart']")));
		return browser.findElement(By.xpath("//ul[@class='account-nav apply-nav-height']//li[@class='cart']"));
	}
	
	public List<WebElement> getNumberOfItems(WebDriver browser) {
		WebDriverWait wait = new WebDriverWait(browser, Constants.WAIT);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@multi-shop-eligible]")));
		return browser.findElements(By.xpath("//li[@multi-shop-eligible]"));
	}
}
