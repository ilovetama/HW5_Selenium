package org.epam.training.navigation;

import org.epam.training.pageobject.OnlinerHomePage;

public class OnlinerNavigation {

  public static void navigateToOnlinerHomePage() {
    new OnlinerHomePage().navigate("https://www.onliner.by/");
  }
}

