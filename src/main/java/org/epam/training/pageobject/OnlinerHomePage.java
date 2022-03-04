package org.epam.training.pageobject;

import org.epam.training.framework.BasePage;
import org.openqa.selenium.By;

public class OnlinerHomePage extends BasePage {

  private static final By CATALOG_LINK = By.xpath
      ("//a[contains(@href, 'https://catalog.onliner.by') and contains(text(), 'Каталог')]");

  public CatalogPage clickOnCatalogLink() {
    waitForElementVisible(CATALOG_LINK).click();
    return new CatalogPage();
  }
}
