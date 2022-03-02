package org.epam.tests;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.epam.training.navigation.OnlinerNavigation;
import org.epam.training.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CatalogPageTest extends BaseTest{

  private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

  @BeforeEach
  public void navigateToOnliner() {
    OnlinerNavigation.navigateToOnlinerHomePage();
  }

  @Disabled
  @Test
  public void testCatalogItemTitle() {
    List<String> catalogItems = onlinerHomePage
        .clickOnCatalogLink()
        .getCatalogItemTitle();
    assertThat(catalogItems)
        .as("Catalog item`s title is not displayed")
        .isNotEmpty();
    System.out.println(catalogItems);
  }

  @Disabled
  @Test
  public void testComputersAndNetworkMenuContent() {
    List<String> menuOptionsItems = onlinerHomePage
        .clickOnCatalogLink()
        .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
        .getMenuItemTitle();
    assertThat(menuOptionsItems)
        .as("Menu item`s title is not displayed")
        .isNotEmpty();
    System.out.println(menuOptionsItems);
  }

  @Test
  public void testComponentsSectionContent() {
    List<String> productTitle = onlinerHomePage
        .clickOnCatalogLink()
        .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
        .selectCategory("Комплектующие")
        .getDescriptionOfProduct();
    assertThat(productTitle)
        .as("Product title is not displayed")
        .isNotEmpty();
    System.out.println(productTitle);
  }

  @AfterEach
  public void closeBrowser() {
    onlinerHomePage.closeBrowser();
  }
}