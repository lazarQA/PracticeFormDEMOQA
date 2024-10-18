package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormsMenuPage extends BaseTest {
    public FormsMenuPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table[class='table table-dark table-striped table-bordered table-hover']")
    public WebElement formWindow;
    @FindBy(tagName = "td")
    public List<WebElement> listOfTD;
    public WebElement formWindow2 = formWindow;


    public Boolean assertFormsWindowIsDisplayed() {
        boolean isDisplayed = true;
        if (!formWindow.isDisplayed()) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    /////////////////////////////////////////METODE ZA ASERTACIJE///////////////////////////////////////////////////////
    public boolean MandatoryFieldsFilledWithCorrectData() {
        boolean isTrue = true;
        if (!listOfTD.get(1).getText().equals("Lazar Arsic")) {
            isTrue = false;
        }
        if (!listOfTD.get(5).getText().equals("Male")) {
            isTrue = false;
        }
        if (!listOfTD.get(7).getText().equals("1234567899")) {
            isTrue = false;
        }
        if (!listOfTD.get(9).getText().equals("13 October,2024")) {
            isTrue = false;
        }
        return isTrue;
    }

    public boolean formWindowIsDisplayed() {
        boolean isDisplayed = false;
        try {
            isDisplayed = driver.findElement(By.cssSelector("table[class='table table-dark table-striped table-bordered table-hover']")).isDisplayed();
        } catch (Exception e) {

        }
        return isDisplayed;
    }

    public boolean AllFieldsFilledWithCorrectData() {
        boolean isTrue = true;
        if (!listOfTD.get(1).getText().equals("Lazar Arsic")) {
            isTrue = false;
        }
        if (!listOfTD.get(5).getText().equals("Male")) {
            isTrue = false;
        }
        if (!listOfTD.get(7).getText().equals("1234567899")) {
            isTrue = false;
        }
        return isTrue;
    }
}