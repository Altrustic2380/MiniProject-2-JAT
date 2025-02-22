package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {
    WebDriver driver;

    // Login Elements
    @FindBy(xpath = "//*[@id='email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//*[@id='submit']")
    private WebElement loginButton;

    // Contact Elements
    @FindBy(xpath = "//*[@id='add-contact']")
    private WebElement addContactButton;

    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='birthdate']")
    private WebElement birthdate;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='phone']")
    private WebElement phone;

    @FindBy(xpath = "//*[@id='street1']")
    private WebElement street1;

    @FindBy(xpath = "//*[@id='street2']")
    private WebElement street2;

    @FindBy(xpath = "//*[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//*[@id='stateProvince']")
    private WebElement stateProvince;

    @FindBy(xpath = "//*[@id='postalCode']")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//*[@id='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logoutButton;

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login function
    public void login(String userEmail, String userPassword) {
        loginEmail.sendKeys(userEmail);
        loginPassword.sendKeys(userPassword);
        loginButton.click();
    }

    // Add a single contact
    public void addContact(String fName, String lName, String bDate, String mail, String phoneNumber, 
                           String streetOne, String streetTwo, String cityName, String state, String zip, String countryName) {
        addContactButton.click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        birthdate.sendKeys(bDate);
        email.sendKeys(mail);
        phone.sendKeys(phoneNumber);
        street1.sendKeys(streetOne);
        street2.sendKeys(streetTwo);
        city.sendKeys(cityName);
        stateProvince.sendKeys(state);
        postalCode.sendKeys(zip);
        country.sendKeys(countryName);
        saveButton.click();
    }

    // Method to add two contacts
    public void addTwoContacts() {
        addContact("Shali", "Soan", "2000-10-30", "shaliso@gmail.com", "9888994523", 
                   "West Street", "Lane 1", "Kadavu", "Kochi", "20001", "India");
    }

    // Logout function
    public void logout() {
        logoutButton.click();
    }
}