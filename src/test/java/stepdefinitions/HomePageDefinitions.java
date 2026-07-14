package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.LoginPage;

public class HomePageDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;

    public HomePageDefinitions() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);

        this.driver = WebDriverManager.chromedriver().create();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I fill the username field with {string}")
    public void iFillTheUsernameFieldWith(String username) {
        loginPage.enterUsername(username);
    }

    @When("I fill the password field with {string}")
    public void iFillThePasswordFieldWith(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginLink();
    }

    // VALIDASI POSITIF
    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("inventory.html"), "Gagal dialihkan ke dashboard!");
        driver.quit();
    }

    // VALIDASI NEGATIF & BATAS
    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessageText();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, "Pesan error tidak sesuai!");
        driver.quit();
    }
}
