package org.epam.tests;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Collection;
import org.epam.training.pageobject.CatalogPage;
import org.epam.training.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

  private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
  private final CatalogPage catalogPage = new CatalogPage();

  @Test
  @Tag("test1")
  public void testCatalogItemTitle() {
    Collection<String> catalogItems = onlinerHomePage
        .clickOnCatalogLink()
        .getCatalogItemTitle();
    assertThat(catalogItems.equals(catalogPage.getCatalogItemTitlesCollection()))
        .as("Catalog item`s title is not displayed")
        .isTrue();
  }
}