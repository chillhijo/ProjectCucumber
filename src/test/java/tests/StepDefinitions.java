package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {
    private WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://courses.ultimateqa.com/users/sign_in");
    }

    @Given("I am in the login page of the Ultimate QA website")
    public void i_am_in_the_login_page_of_the_ultimate_qa_website() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement welcomeElement = driver.findElement(By.xpath("//h2[normalize-space()='Welcome Back!']"));
        wait.until(ExpectedConditions.visibilityOf(welcomeElement));
    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.id("user[email]")).sendKeys("duskokona93@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("Sifra11!");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
    }
    @Then("I should be taken to Products page")
    public void i_should_be_taken_to_products_page() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[normalize-space()='Products']"))));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
