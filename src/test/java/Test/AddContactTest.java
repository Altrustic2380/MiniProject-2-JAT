package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Page.AddContactPage;
import Util.ConfigReader;
import Util.ScreenshotUtil;

public class AddContactTest extends BaseTest {
    private AddContactPage addContactPage;
    private String email;
    private String password;

    @BeforeMethod
    public void setUpTest() {
        addContactPage = new AddContactPage(driver);

        // Fetch login credentials from config.properties
        email = ConfigReader.getProperty("username");
        password = ConfigReader.getProperty("password");

        // Login before adding a contact
        addContactPage.login(email, password);
    }

    @Test
    public void testAddContact() {
        ScreenshotUtil.captureScreenshot(driver, "Before_Adding_Contact"); // Capture before adding contact
        
        addContactPage.addTwoContacts();

        ScreenshotUtil.captureScreenshot(driver, "After_Adding_Contact"); // Capture after adding contact

        // Verify successful contact addition by checking the URL
        String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/contact-list";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Contact addition failed!");
    }

    @Test
    public void testLogout() {
        addContactPage.logout();

        // Verify successful logout by checking the URL
        String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Logout failed!");
    }
}

