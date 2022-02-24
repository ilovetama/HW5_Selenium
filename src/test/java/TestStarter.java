import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStarter {

  private static final String CHROME_DRIVER_PATH = "d:/Selenium_project/src/test/resources/chromedriver.exe";

  @Test
  public void onlinerTester(){
    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("https://onliner.by");
    System.out.println(driver.getTitle());
    driver.quit();
  }


}
