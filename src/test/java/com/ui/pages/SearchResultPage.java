package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_ITEM_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_SEARCHED_ITEMLIST_NAMES = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);

	}

	public String getsearchresultTitle() {
		return getVisibleText(PRODUCT_ITEM_LOCATOR);
	}

	public boolean isProductPresentinSearchList(String searchitem) {
		List<String> keywords = Arrays.asList(searchitem.toLowerCase().split(" "));
		List<String> productNameList = getALLVisibleText(ALL_SEARCHED_ITEMLIST_NAMES);

		boolean result = productNameList.stream()
				.anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));// searching with keywords
																								// i.e product or search
																								// or Dress
		return result;
	}

	public ProductDetailPage clickOntheProductAt(int index) {
		clickon(getAllElements(ALL_SEARCHED_ITEMLIST_NAMES).get(index));
        ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
        return productDetailPage;
	}

}
