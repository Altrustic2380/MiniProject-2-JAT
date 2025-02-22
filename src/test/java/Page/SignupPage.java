package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    WebDriver driver;

    // XPath-based locators
    @FindBy(xpath = "//*[@id='signup']")
    private WebElement signupButton;

    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='submit']")
    private WebElement submitButton;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignup() {
        signupButton.click();
    }

    public void enterDetails(String fName, String lName, String mail, String pwd) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        password.sendKeys(pwd);
    }

    public void submitSignup() {
        submitButton.click();
    }

    public void completeSignup(String fName, String lName, String mail, String pwd) {
        clickSignup();
        enterDetails(fName, lName, mail, pwd);
        submitSignup();
    }
}