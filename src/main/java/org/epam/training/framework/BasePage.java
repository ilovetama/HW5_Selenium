package org.epam.training.framework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

  protected static final Logger LOG = LoggerFactory.getLogger(BasePage.class);
  private static final String SCRIPT_FOR_SCROLL_INTO_VIEW = "arguments[0].scrollIntoView(false)";
  private static final int DRIVER_WAIT_TIME = 60;

  private final WebDriver driver;
  private final WebDriverDiscovery webDriverDiscovery;

  public BasePage() {
    webDriverDiscovery = new WebDriverDiscovery();
    driver = webDriverDiscovery.getWebDriver();
  }

  public void navigate(String url) {
    driver.get(url);
  }

  public List<WebElement> waitForElementsVisible(By by) {
    Wait<WebDriver> wait = new WebDriverWait(driver, DRIVER_WAIT_TIME);
    return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
  }

  public WebElement waitForElementVisible(By by) {
    Wait<WebDriver> wait = new WebDriverWait(driver, DRIVER_WAIT_TIME);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public List<String> getTextsFromWebElements(List<WebElement> webElements, String splitByRegex) {
    return webElements.stream()
        .map(a -> StringUtils.split(a.getText(), splitByRegex))
        .flatMap(Arrays::stream)
        .filter(StringUtils::isNotEmpty)
        .collect(Collectors.toList());
  }

  public List<String> getTextsFromWebElements(List<WebElement> webElements) {
    return getTextsFromWebElements(webElements, StringUtils.EMPTY);
  }

  public void scrollIntoView(WebElement element) {
    try {
      ((JavascriptExecutor) driver).executeScript(SCRIPT_FOR_SCROLL_INTO_VIEW, element);
    } catch (WebDriverException driverDoesNotSupportJavascriptTooBad) {
      LOG.error("Error scroll into view for element. Error message: {}",
          driverDoesNotSupportJavascriptTooBad.getMessage());
    }
  }

  public void closeBrowser() {
    try {
      driver.quit();
    } catch (Exception e) {
      LOG.error("CLOSE BROWSER ERROR: {}", e.getMessage(), e);
    }
  }
}
