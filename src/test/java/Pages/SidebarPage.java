package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {

    public JavascriptExecutor js = ((JavascriptExecutor) driver);

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "header-text")
    public List<WebElement> mainSidebarElements;
    @FindBy(css = ".btn.btn-light")
    public List<WebElement> subSidebarElements;


    public void clickMainSideBarElement(String element){
        for (WebElement mainElement:mainSidebarElements){
            js.executeScript("arguments[0].scrollIntoView(true);", mainElement);
            if (mainElement.getText().equals(element)){
                mainElement.click();
                break;
            }
        }
    }

    public void clickSubSidebarElement(String element){
        for (WebElement elementt:subSidebarElements){
            js.executeScript("arguments[0].scrollIntoView(true);", elementt);
            if (elementt.getText().equals(element)){
                elementt.click();
                break;
            }
        }
    }


}
