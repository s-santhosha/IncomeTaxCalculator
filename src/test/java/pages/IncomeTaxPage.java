package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class IncomeTaxPage extends BasePage {

    private static final String URL_PAGE = "https://www.ato.gov.au/Calculators-and-tools/";

    private static final By simpleTaxCalculatorLink = By.linkText("Simple tax calculator");

    private static final By simpleTaxCalculatorButton = By.cssSelector("[title='Simple tax calculator']");

    private static final By simpleTaxCalculatorHeader = By.xpath("//h1[text()='Simple tax calculator']");

    private static final By incomeYear = By.cssSelector("#ddl-financialYear");

    private static final By taxableIncomeField = By.xpath("//input[@id='texttaxIncomeAmt']");

    private static final By residencyFullYearStatusRadioButton = By.xpath("//span[contains(text(),'Resident for full year')]");

    private static final By nonResidentfullYearResidencyStatusRadioButton = By.xpath("//span[contains(text(),'Non-resident for full year')]");

    private static final By partYearResidencyStatusRadioButton = By.xpath("//span[contains(text(),'Part-year resident')]");

    private static final By submitButton = By.xpath("//button[contains(text(),'Submit')]");

    private static final By taxableAmount = By.cssSelector("[data-bind='text\\: formattedTaxPayable']");

    private static final By numberOfMonths = By.cssSelector("#ddl-residentPartYearMonths");

    public void navigateToIncomeTaxApplication() {
        driver.navigate().to(URL_PAGE);
    }

    public void selectSimpleTaxCalculatorLink() {
        wait.waitForElementDisplayed(simpleTaxCalculatorLink);
        driver.findElement(simpleTaxCalculatorLink).click();
        driver.findElement(simpleTaxCalculatorButton).click();
    }

    public void verifySimpleTaxCalculatorApplication(String arg0) {
        wait.waitForElementDisplayed(simpleTaxCalculatorHeader);
        String headerText = driver.findElement(simpleTaxCalculatorHeader).getText();
        assertEquals(arg0, headerText);
    }

    public void validateSimpleTaxCalculator() {
        String headerText = driver.findElement(simpleTaxCalculatorHeader).getText();
        assertEquals("Simple tax calculator", headerText);
    }

    public void selectYear(String arg0) {
        wait.waitForElementDisplayed(incomeYear);
        Select year = new Select(driver.findElement(incomeYear));
        year.selectByVisibleText(arg0);
    }

    public void inputTaxableIncome(String arg0) {
        driver.findElement(taxableIncomeField).sendKeys(arg0);
    }

    public void selectResidencyStatus(String arg0) {
        if (arg0.contains("Resident for full year")) {
            driver.findElement(residencyFullYearStatusRadioButton).click();
        } else if (arg0.contains("Non-resident for full year")) {
            driver.findElement(nonResidentfullYearResidencyStatusRadioButton).click();
        } else if (arg0.contains("Part-year resident")) {
            driver.findElement(partYearResidencyStatusRadioButton).click();
        }
    }

    public void clickOnSubmit() {
        wait.waitForElementDisplayed(submitButton);
        WebElement element = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void verifyEstimatedTaxAmount(String arg0)  {
        wait.waitForElementDisplayed(taxableAmount);
        String taxableIncomeAmount = driver.findElement(taxableAmount).getText();
        assertEquals(arg0, taxableIncomeAmount);
    }

    public void inputNumberOfMonths(String arg0)  {
        wait.waitForElementDisplayed(numberOfMonths);
        Select year = new Select(driver.findElement(numberOfMonths));
        year.selectByVisibleText(arg0);
    }
}



