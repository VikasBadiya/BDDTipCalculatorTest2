package stepsdefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TipCalculatorFunctionalitySteps {

    WebDriver driver ;

    WebDriverWait wait;

    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    //Test the display of error message for no inputs.

    @Given("I am on Tip Calculator Website Launch Browser")
    public void i_am_on_tip_calculator_website_launch_browser() {
        driver.get("https://qatipcalc.ccbp.tech/");

    }
    @When("I am Clear the TIP PERCENTAGE input element")
    public void i_am_clear_the_tip_percentage_input_element() {
        //Clear the "TIP PERCENTAGE" input element.
        WebElement tipPercentageEle = driver.findElement(By.id("percentageTip"));
        tipPercentageEle.clear();

    }
    @And("I am Click on the CALCULATE button")
    public void i_am_click_on_the_calculate_button() {
        //Click on the "CALCULATE" button.
        WebElement calculateButtonEle = driver.findElement(By.id("calculateButton"));
        calculateButtonEle.click();

    }
    @Then("The Tip Calculator page should be show the Error Message")
    public void the_tip_calculator_page_should_be_show_the_error_message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));
        WebElement errorMessageText = driver.findElement(By.id("errorMessage"));
        String actualErrorMessage = errorMessageText.getText();
        //Verify the error message,
        //Expected error message: Please Enter a Valid Input.
        String expectedErrorMessage = "Please Enter a Valid Input.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error Message Mismatch");

    }

    //Test the display of error message for invalid inputs.

    @When("I am Enter the TIP PERCENTAGE input element as 10f")
    public void i_am_enter_the_tip_percentage_input_element_as_10f() {
        //Clear the "TIP PERCENTAGE" input element.
        WebElement tipPercentageEle = driver.findElement(By.id("percentageTip"));
        tipPercentageEle.sendKeys("10f");

    }
    @And ("I am Click on the CALCULATE button invalid inputs")
    public void i_am_click_on_the_calculate_button_invalid_inputs() {
        //Click on the "CALCULATE" button.
        WebElement calculateButtonEle = driver.findElement(By.id("calculateButton"));
        calculateButtonEle.click();

    }
    @Then("The Tip Calculator page should be show the Error Message invalid inputs")
    public void the_tip_calculator_page_should_be_show_the_error_message_invalid_inputs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));
        WebElement errorMessageText = driver.findElement(By.id("errorMessage"));
        String actualErrorMessage = errorMessageText.getText();
        //Verify the error message,
        //Expected error message: Please Enter a Valid Input.
        String expectedErrorMessage = "Please Enter a Valid Input.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error Message Mismatch");


    }


    //Test the tip calculation.


    @When("I am Enter the  bill amount input element as 1000")
    public void i_am_enter_the_bill_amount_input_element_as() {
        WebElement billAmountEle = driver.findElement(By.id("billAmount"));
        billAmountEle.sendKeys("1000");

    }
    @When("I am Enter the tip percentage input element as 15")
    public void i_am_enter_the_tip_percentage_input_element_as() {
        WebElement tipPercentageEle = driver.findElement(By.id("percentageTip"));
        tipPercentageEle.sendKeys("15");

    }
    @When("I am Click on the CALCULATE button tip calculation")
    public void i_am_click_on_the_calculate_button_tip_calculation() {
        //Click on the "CALCULATE" button.
        WebElement calculateButtonEle = driver.findElement(By.id("calculateButton"));
        calculateButtonEle.click();


    }
    @Then("The Tip Calculator page should be show the tip amount input text and total amount input text")
    public void the_tip_calculator_page_should_be_show_the_tip_amount_input_text_and_total_amount_input_text() {
        WebElement tipAmountELe = driver.findElement(By.id("tipAmount"));
        String actualTipAmount = tipAmountELe.getText();
        String expectedTipAmount ="150.00";
        WebElement totalAmountEle = driver.findElement(By.id("totalAmount"));
        String actualTotalAmount = totalAmountEle.getText();
        String expectedTotalAmount = "1150.00";

        Assert.assertEquals(actualTipAmount,expectedTipAmount);
        Assert.assertEquals(actualTotalAmount,expectedTotalAmount);

    }


}
