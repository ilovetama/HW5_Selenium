package org.epam.tests;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Collection;
import java.util.List;
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
    System.out.println(menuItemTitles);
    System.out.println(catalogPage.getComputersAndNetworkMenuItemsCollection());
    assertThat(menuItemTitles.containsAll(catalogPage.getComputersAndNetworkMenuItemsCollection()))
        .as("Menu item`s title is not displayed")
        .isTrue();
  }

  @Test
  @Tag("test3")
  public void testComponentsSectionContentIsVisible() {
    List<String> productTitles = onlinerHomePage
        .clickOnCatalogLink()
        .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
        .selectCategory("Комплектующие")
        .getProductTitles();
    assertThat(productTitles)
        .as("Product title is not displayed")
        .isNotEmpty();
    List<String> productDescriptions = catalogPage.getProductDescriptions();
    assertThat(productDescriptions)
        .as("Product description is not displayed")
        .isNotEmpty();
    System.out.println(productTitles);
    System.out.println(productDescriptions);
  }
}