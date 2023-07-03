package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.IncomeTaxPage;

public class IncomeTaxStepdefs {

    IncomeTaxPage incomeTaxPage = new IncomeTaxPage();

    @Given("I navigate to the income tax calculator application")
    public void iNavigateToTheIncomeTaxCalculatorApplication() {
        incomeTaxPage.navigateToIncomeTaxApplication();
    }

    @When("I select Simple tax calculator")
    public void iSelectSimpleTaxCalculator() {
        incomeTaxPage.selectSimpleTaxCalculatorLink();
    }

    @Then("I can view the {string}")
    public void iCanViewThe(String arg0) {
        incomeTaxPage.verifySimpleTaxCalculatorApplication(arg0);

    }

    @Given("I am on income tax calculator")
    public void iAmOnIncomeTaxCalculator() {
        incomeTaxPage.validateSimpleTaxCalculator();
    }

    @When("I select income year {string}")
    public void iSelectIncomeYear(String arg0) {
        incomeTaxPage.selectYear(arg0);
    }

    @And("I select taxable income {string} for the year")
    public void iSelectTaxableIncomeForTheYear(String arg0) {
        incomeTaxPage.inputTaxableIncome(arg0);
    }

    @And("I select residency status as {string}")
    public void iSelectResidencyStatusAs(String arg0) {
        incomeTaxPage.selectResidencyStatus(arg0);

    }

    @Then("I click on submit")
    public void iClickOnSubmit() {
        incomeTaxPage.clickOnSubmit();
    }

    @And("I verify the estimated tax as {string} on taxable income")
    public void iVerifyTheEstimatedTaxAsOnTaxableIncome(String arg0) {
        incomeTaxPage.verifyEstimatedTaxAmount(arg0);
    }

    @And("I select number of months {string} being resident")
    public void iSelectNumberOfMonthsBeingResident(String arg0) {
        incomeTaxPage.inputNumberOfMonths(arg0);
    }


}
