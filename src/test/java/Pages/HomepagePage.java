package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {
    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    public JavascriptExecutor js = ((JavascriptExecutor) driver);

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> homepageCards;

    //....................
    public void homepageCardClick(String cardName){
        for (WebElement homepageCard : homepageCards) {
            js.executeScript("arguments[0].scrollIntoView(true);", homepageCard);
            if (homepageCard.getText().equals(cardName)) {
                homepageCard.click();
                break;
            }
        }
    }

}
