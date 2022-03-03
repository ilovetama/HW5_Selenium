package org.epam.training.pageobject;

import java.util.ArrayList;
import java.util.Collection;
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
      "//span[@class='catalog-navigation-list__dropdown-title']";
  private static final String PRODUCT_DESCRIPTION =
      "//*[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]"
          + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
          + "//a//span[contains(@class, 'list__dropdown-description')"
          + " and contains(text(), 'товар')]";

  private static Collection<String> catalogItemTitles() {
    Collection<String> collection = new ArrayList<>();
    collection.add("Электроника");
    collection.add("Компьютеры и сети");
    collection.add("Бытовая техника");
    collection.add("Стройка и ремонт");
    collection.add("Дом и сад");
    collection.add("Авто и мото");
    collection.add("Красота и спорт");
    collection.add("Детям и мамам");
    collection.add("Работа и офис");
    collection.add("Еда");
    return collection;
  }

  private static Collection<String> computersAndNetworksMenuItems() {
    Collection<String> collection = new ArrayList<>();
    collection.add("Ноутбуки, компьютеры, мониторы");
    collection.add("Комплектующие");
    collection.add("Хранение данных");
    collection.add("Сетевое оборудование");
    return collection;
  }

  public Collection<String> getCatalogItemTitlesCollection() {
    return catalogItemTitles();
  }

  public Collection<String> getComputersAndNetworkMenuItemsCollection() {
    return computersAndNetworksMenuItems();
  }

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

  public List<String> getProductTitles() {
    return getTextsFromWebElements(waitForElementsVisible(By.xpath
        (PRODUCT_TITLE)));
  }

  public List<String> getProductDescriptions() {
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
