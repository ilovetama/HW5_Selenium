package org.epam.tests;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Collection;
import org.epam.training.pageobject.CatalogPage;
import org.epam.training.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CatalogPageTest extends BaseTest {

  private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
  private final CatalogPage catalogPage = new CatalogPage();

  @Test
  @Tag("test2")
  public void testComputersAndNetworksMenuIsVisible() {
    Collection<String> menuItemTitles = onlinerHomePage
        .clickOnCatalogLink()
        .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
        .getMenuItemTitle();
    assertThat(menuItemTitles.containsAll(catalogPage.getComputersAndNetworkMenuItemsCollection()))
        .as("Menu item`s title is not displayed")
        .isTrue();
  }

  @Test
  @Tag("test3")
  public void testComponentsSectionTitleAndDescriptionIsVisible() {
    Collection<String> productTitles = onlinerHomePage
        .clickOnCatalogLink()
        .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
        .selectCategory("Комплектующие")
        .getProductTitles();
    softAssertions.assertThat(productTitles)
        .as("Product title is not displayed")
        .isNotEmpty();
    Collection<String> productDescriptions = catalogPage.getProductDescriptions();
    assertThat(productDescriptions)
        .as("Product description is not displayed")
        .isNotEmpty();
  }
}