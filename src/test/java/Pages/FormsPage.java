package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.beans.Visibility;
import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FormsPage extends BaseTest {
    public JavascriptExecutor js = ((JavascriptExecutor) driver);
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public FormsPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement userNameField;
    @FindBy(id = "lastName")
    public WebElement lastNameField;
    @FindBy(id = "userEmail")
    public WebElement emailField;
    @FindBy(id = "userNumber")
    public WebElement phoneNumberField;
    @FindBy(id = "currentAddress")
    public WebElement addressField;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    public WebElement maleGender;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    public WebElement femaleGender;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    public WebElement otherGender;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement checkBoxSports;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement checkBoxReading;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement checkBoxMusic;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthField;
    @FindBy(css = "select[class='react-datepicker__month-select']")
    public WebElement month;
    @FindBy(css = "select[class='react-datepicker__year-select']")
    public WebElement year;
    @FindBy(css = ".react-datepicker__day")
    public List<WebElement> listOfDays;
    @FindBy(id = "subjectsInput")
    public WebElement listOfSubjects;
    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureButton;
    @FindBy(xpath = "//div[contains(text(),'')]")
    public List<WebElement> listOfStates;
    @FindBy(xpath = "//div[contains(text(),'')]")
    public List<WebElement> listOfCities;
    @FindBy(css = "div[class='css-xb97g8 subjects-auto-complete__multi-value__remove']")
    public List<WebElement> deleteItemsFromSubjectsButton;
    @FindBy(id = "subjectsContainer")
    public WebElement subjectsContainer;


    public List<WebElement> listOfGenders() {
        List<WebElement> listOfGenders = new ArrayList<>();
        listOfGenders.add(maleGender);
        listOfGenders.add(femaleGender);
        listOfGenders.add(otherGender);
        return listOfGenders;
    }

    public List<WebElement> listOfHobbies() {
        List<WebElement> listOfHobbies = new ArrayList<>();
        listOfHobbies.add(checkBoxSports);
        listOfHobbies.add(checkBoxReading);
        listOfHobbies.add(checkBoxMusic);
        return listOfHobbies;
    }

    public void choseGender(String Gender) {
        for (WebElement gender : listOfGenders()) {
            js.executeScript("arguments[0].scrollIntoView(true);", gender);
            if (gender.getText().equals(Gender)) {
                gender.click();
                break;
            }
        }
    }

    //////////////////////////////////////METODE ZA UBACIVANJE PODATAKA////////////////////////////////////////////////
    public void addMandatoryFields() {
        String firstName = "Lazar";
        String lastName = "Arsic";
        String gender = "Male";
        String phoneNumber = "1234567899";
        for (WebElement a : listOfGenders()) {
            js.executeScript("arguments[0].scrollIntoView(true);", a);
            if (a.getText().equals(gender)) {
                a.click();
                break;
            }
        }
        js.executeScript("arguments[0].scrollIntoView(true);", userNameField);
        userNameField.sendKeys(firstName);
        js.executeScript("arguments[0].scrollIntoView(true);", lastNameField);
        lastNameField.sendKeys(lastName);
        js.executeScript("arguments[0].scrollIntoView(true);", phoneNumberField);
        phoneNumberField.sendKeys(phoneNumber);
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
    }


    public void addMandatoryFieldsInCorrectPhoneNumber() {
        String firstName = "Lazar";
        String lastName = "Arsic";
        String gender = "Male";
        String phoneNumber = "12345678";
        for (WebElement a : listOfGenders()) {
            js.executeScript("arguments[0].scrollIntoView(true);", a);
            if (a.getText().equals(gender)) {
                a.click();
                break;
            }
        }
        js.executeScript("arguments[0].scrollIntoView(true);", userNameField);
        userNameField.sendKeys(firstName);
        js.executeScript("arguments[0].scrollIntoView(true);", lastNameField);
        lastNameField.sendKeys(lastName);
        js.executeScript("arguments[0].scrollIntoView(true);", phoneNumberField);
        phoneNumberField.sendKeys(phoneNumber);
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
    }

    public void addMandatoryFieldsNoFirstName() {
        String lastName = "Arsic";
        String gender = "Male";
        String phoneNumber = "12345678";
        for (WebElement a : listOfGenders()) {
            js.executeScript("arguments[0].scrollIntoView(true);", a);
            if (a.getText().equals(gender)) {
                a.click();
                break;
            }
        }

        js.executeScript("arguments[0].scrollIntoView(true);", lastNameField);
        lastNameField.sendKeys(lastName);
        js.executeScript("arguments[0].scrollIntoView(true);", phoneNumberField);
        phoneNumberField.sendKeys(phoneNumber);
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();

    }

    public void addMandatoryFieldsNoLastName() {
        String firstName = "Lazar";
        String gender = "Male";
        String phoneNumber = "1234567998";
        for (WebElement a : listOfGenders()) {
            js.executeScript("arguments[0].scrollIntoView(true);", a);
            if (a.getText().equals(gender)) {
                a.click();
                break;
            }
        }

        js.executeScript("arguments[0].scrollIntoView(true);", userNameField);
        lastNameField.sendKeys(firstName);
        js.executeScript("arguments[0].scrollIntoView(true);", phoneNumberField);
        phoneNumberField.sendKeys(phoneNumber);
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();

    }

    public void addEmailAddress(String email) {
        js.executeScript("arguments[0].scrollIntoView(true);", emailField);
        emailField.sendKeys(email);

    }

    public void addSubjects(String[] subjects) {
        for (String subject : subjects) {
            listOfSubjects.sendKeys(subject);
            listOfSubjects.sendKeys(Keys.ENTER);
        }
    }

    public void uploadPicture() throws InterruptedException {
        uploadPictureButton.sendKeys("C:\\Users\\Lazar\\Desktop\\domaciSlika.jpg");

    }

    public void addAddress(String address) {
        js.executeScript("arguments[0].scrollIntoView(true);", addressField);
        addressField.sendKeys(address);
    }

    public void selectState(String state) {
        WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
        stateDropdown.click();
        for (WebElement State : listOfStates) {
            if (State.getText().equals(state)) {
                State.click();
                break;
            }
        }
    }

    public void selectCity(String city) {
        WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
        cityDropdown.click();
        for (WebElement City : listOfCities) {
            if (City.getText().equals(city)) {
                City.click();
                break;
            }
        }
    }

    public void deleteAllSubjects()   {
        WebElement button = deleteItemsFromSubjectsButton.getFirst();
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        for (int i = 0; i <= deleteItemsFromSubjectsButton.size()-1; i++) {
            WebElement deleteButton = deleteItemsFromSubjectsButton.get(i);
            deleteButton.click();
        }
    }


    ////////////////////////////////////////////////METODE ZA ASERTACIJE////////////////////////////////////////////////
    public Boolean assertRadioButtonsClickable() {
        boolean isClickable = true;
        for (WebElement gender : listOfGenders()) {
            js.executeScript("arguments[0].scrollIntoView(true);", gender);
            gender.click();
            if (!gender.isDisplayed()) {
                isClickable = false;
                break;
            }
        }
        return isClickable;
    }

    public Boolean assertChecboxesClickable() throws InterruptedException {
        boolean isClickable = true;
        int counter = 0;
        for (WebElement hobby : listOfHobbies()) {
            js.executeScript("arguments[0].scrollIntoView(true);", hobby);
            Thread.sleep(300);
            hobby.click();
            if (hobby.isDisplayed()) {
                counter++;
            }
        }
        if (counter != 3) {
            isClickable = false;
        }
        System.out.println(counter);
        return isClickable;
    }

    /////////////////////////////////////METODE ZA BIRANJE OD PONUDJENIH////////////////////////////////////////////
    public void choseBirthDate(int day, String Month, String Year) {
        js.executeScript("arguments[0].scrollIntoView(true);", dateOfBirthField);
        dateOfBirthField.click();


        dateOfBirthField.click();
        Select selectMonth = new Select(month);
        Select selectYear = new Select(year);
        selectMonth.selectByVisibleText(Month);
        selectYear.selectByVisibleText(Year);
        if (day < 15) {
            for (WebElement Day : listOfDays) {
                String dayString = String.valueOf(day);
                if (Day.getText().equals(dayString)) {
                    Day.click();
                    break;
                }
            }
        } else {
            for (int i = listOfDays.size() - 1; i >= 0; i--) {
                String dayString = String.valueOf(day);
                WebElement Day = listOfDays.get(i);
                if (Day.getText().equals(dayString)) {
                    Day.click();
                    break;
                }
            }


        }
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
    }

    public void selectHobbies(String[] listOFHobbies) {
        for (WebElement Hobby : listOfHobbies()) {
            js.executeScript("arguments[0].scrollIntoView(true);", Hobby);

            String hobby = Hobby.getText();
            for (int i = 0; i < listOFHobbies.length; i++) {
                if (listOFHobbies[i].equals(hobby)) {
                    js.executeScript("arguments[0].scrollIntoView(true);", Hobby);
                    Hobby.click();
                }
            }
        }
    }

}