package Base;

import Pages.FormsMenuPage;
import Pages.FormsPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public HomepagePage homepagePage;
    public JavascriptExecutor js;
    public SidebarPage sidebarPage;
    public WebDriverWait wait;
    public FormsPage formsPage;
    public FormsMenuPage formMenuPage;




    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        js=((JavascriptExecutor) driver);

        homepagePage=new HomepagePage();
        sidebarPage=new SidebarPage();
        formsPage=new FormsPage();
        formMenuPage=new FormsMenuPage();
    }

}
