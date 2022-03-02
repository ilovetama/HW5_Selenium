package org.epam.training.pageobject;

import java.util.List;
import org.epam.training.framework.BasePage;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage {

  private static final String CATALOG_ITEM_TITLE =
      "//*[@class = 'catalog-navigation-classifier__item-title-wrapper']";
  private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
      "//*[contains(@class, 'catalog-navigation-classifier__item')]//*[contains(text(), '%s')]";
  private static final String CATALOG_MENU_ITEM_TITLE =
      "//*[@class = 'catalog-navigation-list__category' and @data-id='2']"
          + "//*[@class = 'catalog-navigation-list__aside-item']";
  private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
      "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";
  private static final String PRODUCT_TITLE =
      "//*[@class='catalog-navigation-list__aside-title' and contains(text(),"
          + "'омплектующие')]//following-sibling::"
          + "div[@class='catalog-navigation-list__dropdown']"
          + "//a//*[contains(@class, 'title')]";
  private static final String PRODUCT_DESCRIPTION =
      "//*[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]"
          + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
          + "//a//span[contains(@class, 'list__dropdown-description')"
          + " and contains(text(), 'товар')]";

  public List<String> getCatalogItemTitle() {
    return getTextsFromWebElements(waitForElementsVisible(By.xpath
        (CATALOG_ITEM_TITLE)));
  }

  public CatalogPage clickOnCatalogClassifierLink(String link) {
    waitForElementVisible(By.xpath(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)))
        .click();
    return this;
  }

  public List<String> getMenuItemTitle() {
    return getTextsFromWebElements(waitForElementsVisible(By.xpath
        (CATALOG_MENU_ITEM_TITLE)));
  }

  public List<String> getTitleOfProduct() {
    return getTextsFromWebElements(waitForElementsVisible(By.xpath
        (PRODUCT_TITLE)));
  }

  public List<String> getDescriptionOfProduct() {
    return getTextsFromWebElements(waitForElementsVisible(By.xpath
        (PRODUCT_DESCRIPTION)));
  }

  public CatalogPage selectCategory(String category) {
    waitForElementVisible(
        By.xpath(String.format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, category)))
        .click();
    return this;
  }
}
