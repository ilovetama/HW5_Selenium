package org.epam.tests;

import org.epam.training.navigation.OnlinerNavigation;
import org.epam.training.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

  private final OnlinerHomePage onlinerHomePage = new OnlinerHomePage();

  @BeforeEach
  public void navigateToOnliner() {
    OnlinerNavigation.navigateToOnlinerHomePage();
  }

  @AfterEach
  public void closeBrowser() {
    onlinerHomePage.closeBrowser();
  }
}
