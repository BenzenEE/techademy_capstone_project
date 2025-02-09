package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.techademy.base.BaseTest;
import org.techademy.pages.ABTestingPage;
import org.techademy.pages.DropdownPage;
import org.techademy.pages.FramesPage;
import org.techademy.pages.HomePage;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinition extends BaseTest {
    private WebDriver driver;
    private HomePage homePage;
    private ABTestingPage abTestingPage;
    private DropdownPage dropdownPage;
    private FramesPage framesPage;

    @Before
    public void setUp(){
        driver = getDriver();
        homePage = new HomePage(driver);
        abTestingPage = new ABTestingPage(driver);
        dropdownPage = new DropdownPage(driver);
        framesPage = new FramesPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User navigates to the mentioned page")
    public void user_navigates_to_the_mentioned_page() {
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("User verifies the title of the page")
    public void user_verifies_the_title_of_the_page() {
        System.out.println(homePage.getTitleOfThePage());
        Assert.assertEquals(homePage.getTitleOfThePage(), "The Internet");
    }

    @When("User clicks on {string} link")
    public void user_clicks_on_link(String linkText) throws InterruptedException {
        homePage.clickLink(linkText);
    }

    @Then("User verifies the text on the page as {string}")
    public void user_verifies_the_text_on_the_page_as(String expectedText) {
        String actualText = abTestingPage.getText();
        System.out.println(actualText+" "+expectedText);
        Assert.assertEquals(actualText, expectedText, "Text does not match!");
    }

    @Then("User navigates back to home page")
    public void user_navigates_back_to_home_page() {
        abTestingPage.navigateBack();
    }

    @When("User selects {string} from dropdown")
    public void user_selects_from_dropdown(String option) {
        dropdownPage.selectOption(option);
    }

    @Then("User verifies {string} is selected")
    public void user_verifies_is_selected(String string) {
        Assert.assertEquals(dropdownPage.getOptionSelected(string), string);
    }
    @Then("User Verifies {string} ans {string} links are present")
    public void user_verifies_ans_links_are_present(String nestedFrames, String iFrame) {
        Assert.assertTrue(framesPage.isLinkPresent(nestedFrames));
        Assert.assertTrue(framesPage.isLinkPresent(iFrame));
    }
}
