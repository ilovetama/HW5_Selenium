import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestStarter {

  private static final String CHROME_DRIVER_PATH =
      "d:/Selenium_project/src/test/resources/chromedriver.exe";
  WebDriver driver;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("https://onliner.by");
  }

  @AfterEach
  public void quit() {
    driver.close();
    driver.quit();
  }

  @Test
  @DisplayName("catalogContentMenuCheck")
  public void testCatalogContentMenu() {
    (new WebDriverWait(driver, 2)).until(ExpectedConditions.
        presenceOfElementLocated(By.xpath("//a[@href='https://catalog.onliner.by/']"))).click();
    WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Электроника')]"));
    assertThat(element.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Компьютеры и')]"));
    assertThat(element1.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element2 = driver.findElement(
        By.xpath("//span[contains(text(),'Бытовая техника')]"));
    assertThat(element2.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element3 = driver.findElement(By.xpath("//span[contains(text(),'Стройка и')]"));
    assertThat(element3.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element4 = driver.findElement(By.xpath("//span[contains(text(),'Дом и')]"));
    assertThat(element4.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element5 = driver.findElement(By.xpath("//span[contains(text(),'Авто и')]"));
    assertThat(element5.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element6 = driver.findElement(By.xpath("//span[contains(text(),'Красота и')]"));
    assertThat(element6.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element7 = driver.findElement(By.xpath("//span[contains(text(),'Детям и')]"));
    assertThat(element7.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element8 = driver.findElement(By.xpath("//span[contains(text(),'Работа и')]"));
    assertThat(element8.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element9 = driver.findElement(By.xpath("//span[contains(text(),'Еда')]"));
    assertThat(element9.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
  }

  @Test
  @DisplayName("computersAndNetworkMenuCheck")
  public void testComputersAndNetworkMenu() {
    (new WebDriverWait(driver, 2)).until(ExpectedConditions.
        presenceOfElementLocated(By.xpath("//a[@href='https://catalog.onliner.by/']"))).click();
    (new WebDriverWait(driver, 2)).until(ExpectedConditions.
        presenceOfElementLocated(By.xpath
            ("//span[contains(text(),'Компьютеры и')]"))).click();
    WebElement element = driver.findElement(By.xpath
        ("//div[contains(text(),'Ноутбуки, компьютеры, мониторы')]"));
    assertThat(element.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element1 = driver.findElement(By.xpath
        ("//div[contains(text(),'Комплектующие')]"));
    assertThat(element1.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element2 = driver.findElement(By.xpath
        ("//div[contains(text(),'Хранение данных')]"));
    assertThat(element2.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
    WebElement element3 = driver.findElement(By.xpath
        ("//div[contains(text(),'Сетевое оборудование')]"));
    assertThat(element3.isDisplayed()).overridingErrorMessage(()
        -> "Element not found.").isTrue();
  }

  @Test
  @DisplayName("componentsMenuCheck")
  public void testComponentsMenu() {
    (new WebDriverWait(driver, 2)).until(ExpectedConditions.
        presenceOfElementLocated(By.xpath("//a[@href='https://catalog.onliner.by/']"))).click();
    (new WebDriverWait(driver, 2)).until(ExpectedConditions.
        presenceOfElementLocated(By.xpath
            ("//span[contains(text(),'Компьютеры и')]"))).click();
    WebElement link = (new WebDriverWait(driver, 4)).until(ExpectedConditions.
        presenceOfElementLocated(By.xpath
            ("//*[@class='catalog-navigation-list__aside-title'"
                + " and contains(text(), 'Комплектующие')]")));
    Actions actions = new Actions(driver);
    actions.moveToElement(link).perform();
    WebElement element = (new WebDriverWait(driver, 4)).until(ExpectedConditions.
        presenceOfElementLocated(By.xpath
            ("//*[@class='catalog-navigation-list__dropdown-title']")));
    assertThat(element.isDisplayed()).overridingErrorMessage(()
        -> "Element 1 not found.").isTrue();
    WebElement element1 = driver.findElement(By.xpath
        ("//*[@class='catalog-navigation-list__dropdown-description']"));
    assertThat(element1.isDisplayed()).overridingErrorMessage(()
        -> "Element 2 not found.").isTrue();
  }
}
