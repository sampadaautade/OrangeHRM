package Setup;

import java.time.Duration;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.Utils;
public class OrangeHrmSetup {
    public static WebDriver driver;
    public static SoftAssert softAssert;
    public static JSONObject jsonObject = Utils.loadJsonFile("./src/test/resources/user.json");
    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}