import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EtsyMethods {
	EtsyObjects o;

	public EtsyMethods() {
		o = new EtsyObjects();
	}

	public boolean registerInEtsy(WebDriver browser) {
		try {
			if (o.getWelcomeToEtsyPopup(browser).isDisplayed()) {
				o.getAcceptConditionsButton(browser).click();
			}
			o.getMainPageRegisterNowButton(browser).click();

			o.getEmailTextbox(browser).sendKeys(Constants.email);
			o.getNameTextbox(browser).sendKeys(Constants.userName);
			o.getPasswordTextbox(browser).sendKeys(Constants.password);
			o.getRegisterMeButton(browser).click();
			
			o.getProfileButton(browser).click();
			String name = o.getUserName(browser).getText();
			
			if (!name.equalsIgnoreCase("SeleniumTesting")) {
				return false;
			}

			Thread.sleep(15000);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean searchForStuffInEtsy(WebDriver browser) {
		try {
			if (o.getWelcomeToEtsyPopup(browser).isDisplayed()) {
				o.getAcceptConditionsButton(browser).click();
			}

			// Search for the sketchbook
			o.getMainPageSearchTextbox(browser).clear();
			o.getMainPageSearchTextbox(browser).sendKeys("Sketchbook");
			o.getMainPageSearchTextbox(browser).sendKeys(Keys.ENTER);
			o.getSortingCriteriaDropdown(browser).click();
			o.getSortByPriceAscending(browser).click();

			// Get all the valid sketchbooks
			List<WebElement> allTheItems = o.getAllThePrices(browser);
			List<WebElement> allTheNonSaleAds = o.getPriceFromNonSaleAds(browser);
			List<WebElement> allTheSaleAds = o.getPriceFromSaleAds(browser);
			List<WebElement> allTheStrikedPriceAds = o.getStrikedPriceFromSaleAds(browser);

			List<WebElement> allTheAds = new ArrayList<WebElement>(allTheNonSaleAds);
			allTheAds.addAll(allTheSaleAds);
			allTheAds.addAll(allTheStrikedPriceAds);

			for (WebElement ad : allTheAds) {
				allTheItems.remove(ad);
			}

			// Check whether the prices are correctly sorted
			float biggest = Float.NEGATIVE_INFINITY;
			WebElement buyingThis = null;
			for (WebElement price : allTheItems) {
				String etsyValue = price.getText();
				if (!etsyValue.equals("")) {
					etsyValue = etsyValue.replaceAll(",", ".");
					float value = Float.parseFloat(etsyValue);
					if (value >= biggest) {
						biggest = value;
						buyingThis = price;
					} else {
						// The list is not correctly sorted
						// Actually, seems Etsy doesn't sort correctly all the values, so let's just
						// continue...
						// return false;
					}
				}
			}

			// Select the highest price one
			buyingThis.click();

			// Buy the sketchbook
			ArrayList<String> handles = new ArrayList<>(browser.getWindowHandles());
			browser.switchTo().window(handles.get(1));
			o.getAddToTheCartButton(browser).click();
			if(!o.getSubmitOrder(browser).isDisplayed()) {
				return false;
			}
			browser.close();
			browser.switchTo().window(handles.get(0));

			// Search for the turntable mat
			o.getMainPageSearchTextbox(browser).clear();
			o.getMainPageSearchTextbox(browser).sendKeys("turntable mat");
			o.getMainPageSearchTextbox(browser).sendKeys(Keys.ENTER);
			
			// Get all the valid turntable mats
			allTheItems = o.getAllThePrices(browser);
			allTheStrikedPriceAds = o.getStrikedPriceFromSaleAds(browser);

			allTheAds = new ArrayList<WebElement>(allTheNonSaleAds);

			for (WebElement ad : allTheAds) {
				allTheItems.remove(ad);
			}
			
			// Get one random turntable mat
			int random = (int) (Math.random() * allTheItems.size() + 1);
			WebElement randomMat = allTheItems.get(random);

			// Select the random one
			randomMat.click();

			// Buy the turntable mat
			handles = new ArrayList<>(browser.getWindowHandles());
			browser.switchTo().window(handles.get(1));
			if(!o.getAddToTheCartButton(browser).isDisplayed()) {
				return false;
			}
			
			// Select a size (just in case you need to)
			List <WebElement> dropdowns = o.getSizeDropdown(browser);
			if (dropdowns.size() > 0) {
				Select option = new Select(dropdowns.get(0));
				option.selectByIndex(0);
			}
			
			// Submit the order
			o.getAddToTheCartButton(browser).click();
			if(!o.getSubmitOrder(browser).isDisplayed()) {
				return false;
			}
			browser.close();
			browser.switchTo().window(handles.get(0));

			// Go to the cart and check the number of items
			o.getCartPreviewButton(browser).click();
			List<WebElement> elementsInTheCart = o.getNumberOfItems(browser);

			if (elementsInTheCart.size() != 2) {
				return false;
			}

			Thread.sleep(15000);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}