package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Page.LoginPage;
import Util.ConfigReader;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private String email;
    private String password;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);

        // Fetching test data from config.properties
        email = ConfigReader.getProperty("username");
        password = ConfigReader.getProperty("password");
    }

    @Test
    public void testValidLogin() {
        loginPage.login(email, password);

        // Verify successful login by checking redirection
        String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/contact-list";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }
}

