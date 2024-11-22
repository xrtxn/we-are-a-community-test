package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;

    @Given("I navigate to the 'We are Community' website")
    public void i_navigate_to_the_we_are_community_website() {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.get("https://wearecommunity.io/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @When("I open the about us page")
    public void i_open_the_about_us_page() {
        WebElement aboutUs = driver.findElement(By.cssSelector("li.nav-item:nth-child(7) > a:nth-child(1)"));
        Assertions.assertTrue(aboutUs.isDisplayed());
        aboutUs.click();
    }

    @Then("I should see the contact email")
    public void i_enter_valid_credentials() {
        WebElement contact = driver.findElement(By.cssSelector(".CommunityPanel-module__emailContact__2l_9I > a:nth-child(1)"));
        Assertions.assertTrue(contact.isDisplayed());
    }

    @Then("I should exit the browser")
    public void i_should_close_the_browser() {
        driver.quit();
    }

    // Scenario 2

    @When("I view the 'Communities' section")
    public void i_view_the_communities_section() {
        WebElement communities = driver.findElement(By.cssSelector(".communities-icon > a:nth-child(1)"));
        Assertions.assertTrue(communities.isDisplayed());
        communities.click();
    }

    @And("I input {string} to the community search bar")
    public void i_input_to_the_community_search_bar(String string) {
        WebElement searchBar = driver.findElement(By.cssSelector(".evnt-search-filter > input:nth-child(1)"));
        searchBar.click();
        searchBar.sendKeys(string);
    }

    @Then("The first community name should be {string}")
    public void the_first_item_should_be(String string) {
        WebElement community = driver.findElement(By.xpath("/html/body/div[2]/div/main/section[3]/div/div/div/div[2]/div[1]/div/a/div/div[2]/div/div/div[2]/h2/span"));
        Assertions.assertTrue(community.isDisplayed());
        Assertions.assertEquals(string, community.getText());
    }

    @And("I filter by Hungary,Szeged")
    public void i_filter_by_hungary_szeged() {
        WebElement filter = driver.findElement(By.id("filter_location"));
        filter.click();
        WebElement hungaryDropdown = driver.findElement(By.cssSelector("div.show:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(13) > div:nth-child(1) > div:nth-child(1)"));
        hungaryDropdown.click();
        WebElement szegedCheckbox = driver.findElement(By.cssSelector("#collapse_filter_location_12 > div:nth-child(3) > label:nth-child(2)"));
        szegedCheckbox.click();
    }

    @And("I should see the first community is {string}")
    public void i_should_see_the_first_community_is(String string) {
        WebElement community = driver.findElement(By.cssSelector("div.evnt-communities-column:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1) > span:nth-child(1)"));
        Assertions.assertTrue(community.isDisplayed());
        Assertions.assertEquals(string, community.getText());
    }
}
