package org.epam.training.pageobject;

import org.epam.training.framework.AbstractPage;
import org.openqa.selenium.By;

public class OnlinerHomePage extends AbstractPage {
  private static final By CATALOG_LINK = By.xpath
      ("//a[contains(@href, 'https://catalog.onliner.by') and contains(text(), 'аталог')]");

  public CatalogPage clickOnCatalogLink() {
    waitForElementVisible(CATALOG_LINK).click();
    return new CatalogPage();
  }
}
