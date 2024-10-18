package Test;

import Base.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    //testovi za ubacivanje obaveznih polja
    @Test
    public void UserCanSubmitFormWithMandatoryFields() throws InterruptedException {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        formsPage.addMandatoryFields();
        formsPage.submitButton.click();
        Assert.assertTrue(formMenuPage.assertFormsWindowIsDisplayed());
        Assert.assertTrue(formMenuPage.MandatoryFieldsFilledWithCorrectData());
    }

    @Test(priority = 5)
    public void userCanSubmitFormWithAllFieldsSelected() throws InterruptedException {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        formsPage.addMandatoryFields();
        formsPage.selectState("NCR");
        formsPage.selectCity("Delhi");
        formsPage.choseBirthDate(4, "January", "1998");
        formsPage.addEmailAddress("test@example.com");
        formsPage.addSubjects(new String[]{"A", "biology", "Sc"});
        formsPage.selectHobbies(new String[]{"Music", "Reading"});
        formsPage.uploadPicture();
        formsPage.addAddress("Kralja Petra I, 1/2,35");
        formsPage.submitButton.click();
        //Assert.assertTrue(formMenuPage.AllFieldsFilledWithCorrectData());
        Assert.assertEquals(formMenuPage.listOfTD.get(3).getText(), "test@example.com");
        Assert.assertEquals(formMenuPage.listOfTD.get(9).getText(), "04 January,1998");
        Assert.assertEquals(formMenuPage.listOfTD.get(11).getText(), "Maths, Biology, Computer Science");
        Assert.assertEquals(formMenuPage.listOfTD.get(13).getText(), "Reading, Music");
        Assert.assertEquals(formMenuPage.listOfTD.get(15).getText(), "domaciSlika.jpg");
        Assert.assertEquals(formMenuPage.listOfTD.get(17).getText(), "Kralja Petra I, 1/2,35");
        Assert.assertEquals(formMenuPage.listOfTD.get(19).getText(), "NCR Delhi");


    }

    @Test(priority = 10)
    public void UserCannotSubmitFormWithIncorrectNumber() throws InterruptedException {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        formsPage.addMandatoryFieldsInCorrectPhoneNumber();
        Assert.assertFalse(formMenuPage.formWindowIsDisplayed());
    }

    @Test(priority = 20)
    public void UserCannotSubmitFormWithNoFirstName() {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        formsPage.addMandatoryFieldsNoFirstName();
        Assert.assertFalse(formMenuPage.formWindowIsDisplayed());

    }

    @Test(priority = 30)
    public void UserCannotSubmitFormWithNoLastName() {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        formsPage.addMandatoryFieldsNoLastName();
        Assert.assertFalse(formMenuPage.formWindowIsDisplayed());
    }

    //testovi za klikabilnost elemenata na formi
    @Test(priority = 40)
    public void UserCanSelectAllThreeGenders() {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        Assert.assertTrue(formsPage.assertRadioButtonsClickable());
    }

    @Test(priority = 50)
    public void UserCanClickAllThreeHobbies() throws InterruptedException {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        Assert.assertTrue(formsPage.assertChecboxesClickable());
    }

    @Test(priority = 60)
    public void UserCanDeleteSubjectsOnceSelected()   {
        homepagePage.homepageCardClick("Forms");
        sidebarPage.clickSubSidebarElement("Practice Form");
        formsPage.addSubjects(new String[]{"A", "biology", "Sc"});
        formsPage.deleteAllSubjects();
        Assert.assertEquals(formsPage.deleteItemsFromSubjectsButton.size(),1);

    }


}
