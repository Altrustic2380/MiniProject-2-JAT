package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Page.SignupPage;
import Util.ConfigReader;

public class SignupTest extends BaseTest {
    private SignupPage signupPage;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @BeforeMethod
    public void setUpTest() {
        signupPage = new SignupPage(driver);

        // Fetching test data from config.properties
        firstName = "Ace";
        lastName = "Max";
        email = ConfigReader.getProperty("username");
        password = ConfigReader.getProperty("password");
    }

    @Test
    public void testValidSignup() {
        signupPage.completeSignup(firstName, lastName, email, password);

        // Verify successful signup by checking redirection
        String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/contact-list";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Signup failed!");
    }
}

