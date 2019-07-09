package homework6.steps;

import cucumber.api.java.en.Then;
import homework6.entities.User;
import homework6.enums.Checkboxes;
import homework6.enums.Radiobuttons;
import homework6.hooks.TestContext;
import homework6.pageobjects.BasePage;
import homework6.pageobjects.DifferentElementsPage;
import homework6.pageobjects.HomePage;
import homework6.pageobjects.UserTablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class AssertionsStep extends BaseStep {

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String expectedUsername) {
        BasePage basePage = new BasePage(TestContext.getDriver());
        assertEquals(basePage.getNameLabel().getText(), expectedUsername);
    }

    @Then("Dropdown list should be displayed")
    public void dropdownListShouldBeDisplayed() {
        BasePage basePage = new BasePage(TestContext.getDriver());
        assertTrue(basePage.getServiceTopMenu().get(0).isDisplayed());
    }

    @Then("Dropdown list should have")
    public void dropdownListShouldHave(List<String> items) {
        BasePage basePage = new BasePage(TestContext.getDriver());
        List<String> subItemsText = basePage.getServiceTopMenu().
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(subItemsText, items);
    }

    @Then("Left side dropdown menu should have")
    public void leftSideDropdownMenuShouldHave(List<String> items) {
        BasePage basePage = new BasePage(TestContext.getDriver());
        List<String> subItemsText = basePage.getServiceLeftMenu().
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(subItemsText, items);
    }

    @Then("Different Elements page should open")
    public void differentElementsPageShouldOpen() {
        assertTrue(TestContext.getDriver().getCurrentUrl().contains("different-elements.html"));
    }

    @Then("Different Elements page should contain 4 checkboxes")
    public void shouldContainCheckboxes() {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        int i = 0;
        for (Checkboxes btn : Checkboxes.values()) {
            if (!basePage.checkListLength(differentElementsPage.getCheckboxes(), Checkboxes.WATER)) {
                assertTrue(false);
                return;
            }
            assertEquals(differentElementsPage.getCheckboxes().get(i).getText(), btn.name());
            assertTrue(differentElementsPage.getCheckboxes().get(i).isDisplayed());
            assertTrue(differentElementsPage.getCheckboxes().get(i).findElement(By.tagName("input")).isDisplayed());
            i++;
        }
    }

    @Then("Different Elements page should contain 4 radiobuttons")
    public void shouldContainRadios() {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        int i = 0;
        for (Radiobuttons btn : Radiobuttons.values()) {
            if (!basePage.checkListLength(differentElementsPage.getRadios(), Radiobuttons.BRONZE)) {
                assertTrue(false);
                return;
            }
            assertEquals(differentElementsPage.getRadios().get(i).getText(), btn.name());
            assertTrue(differentElementsPage.getRadios().get(i).isDisplayed());
            assertTrue(differentElementsPage.getRadios().get(i).findElement(By.tagName("input")).isDisplayed());
            i++;
        }
    }

    @Then("Different Elements page should contain 2 buttons")
    public void shouldContainButtons() {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        assertTrue(differentElementsPage.getButton().isDisplayed());
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Then("Different Elements page should contain 1 select")
    public void shouldContainSelect() {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        assertTrue(differentElementsPage.getColorsDropdown().isDisplayed());
    }

    @Then("Different Elements page should contain left section")
    public void shouldContainLeftSection() {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("Different Elements page should contain right section")
    public void shouldContainRightSection() {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("4 pictures should be displayed")
    public void shouldContainPictures() {
        HomePage homePage = new HomePage(TestContext.getDriver());
        assertEquals(homePage.getImages().size(), 4);
        for (WebElement img : homePage.getImages()) {
            assertTrue(img.isDisplayed());
        }
    }

    @Then("4 texts under pictures should be displayed")
    public void shouldContainTexts() {
        HomePage homePage = new HomePage(TestContext.getDriver());
        assertEquals(homePage.getTextboxes().size(), 4);
        for (WebElement text : homePage.getTextboxes()) {
            assertTrue(text.isDisplayed());
        }
    }

    @Then("Two headers above pictures are displayed")
    public void shouldContainHeaders() {
        HomePage homePage = new HomePage(TestContext.getDriver());
        assertTrue(homePage.getMainTitle().isDisplayed());
        assertTrue(homePage.getSubHeader().isDisplayed());
    }

    @Then("Checboxes are selected")
    public void checkboxesShouldBeSelected(List<String> checkboxes) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        for (String name : checkboxes) {
            assertTrue(differentElementsPage.findCheckboxByName(name).isSelected());
        }
    }

    @Then("Log lines for each selected checkbox are present")
    public void logLinesShouldBePresentForSelectedChecks(List<String> checkboxes) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        for (String name : checkboxes) {
            differentElementsPage.findLogLine(name + " : condition changed to true");
        }
    }

    @Then("Radiobutton is selected")
    public void radioShouldBeSelected(String radioName) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        assertTrue(differentElementsPage.findRadioByName(radioName).isSelected());
    }

    @Then("Log line for radiobutton is present")
    public void logLineShouldBePresentForRadio(String radioName) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        differentElementsPage.findLogLine("metal: value changed to "+radioName);
    }

    @Then("Value is selected")
    public void valueShouldBeSelected(String value) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        assertTrue(differentElementsPage.getColorsSelect().getFirstSelectedOption().getText().contains(value));
    }

    @Then("Log line for select is present")
    public void logLineShouldBePresentForSelect(String value) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        differentElementsPage.findLogLine("Colors: value changed to "+value);
    }

    @Then("Checboxes are unselected")
    public void checkboxesShouldBeUnselected(List<String> checkboxes) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        for (String name : checkboxes) {
            assertFalse(differentElementsPage.findCheckboxByName(name).isSelected());
        }
    }

    @Then("Log lines for each unselected checkbox are present")
    public void logLinesShouldBePresentForUnselectedChecks(List<String> checkboxes) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        for (String name : checkboxes) {
            differentElementsPage.findLogLine(name + " : condition changed to false");
        }
    }

    @Then("\"User Table\" page is opened")
    public void userTablePageIsOpened(){
        assertTrue(TestContext.getDriver().getCurrentUrl().contains("user-table.html"));
    }

    @Then("6 NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void numberTypeDropdownsAreDisplayed(){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        for(WebElement elem:userTablePage.getUserNumbers()){
            assertTrue(elem.isDisplayed());
        }
    }

    @Then("6 User names are displayed on Users Table on User Table Page")
    public void userNamesAreDisplayed(){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        for(WebElement elem:userTablePage.getUserNames()){
            assertTrue(elem.isDisplayed());
        }
    }
    @Then("6 Description images are displayed on Users Table on User Table Page")
    public void descriptionImagesAreDisplayed(){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        for(WebElement elem:userTablePage.getUserPics()){
            assertTrue(elem.isDisplayed());
        }
    }
    @Then("6 Description texts under images are displayed on Users Table on User Table Page")
    public void descriptionTextsAreDisplayed(){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        for(WebElement elem:userTablePage.getUserDescrs()){
            assertTrue(elem.isDisplayed());
        }
    }
    @Then("6 checkboxes are displayed on Users Table on User Table Page")
    public void checkboxesAreDisplayed(){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        for(WebElement elem:userTablePage.getUserChecks()){
            assertTrue(elem.isDisplayed());
        }
    }
    @Then("User table contains following values:")
    public void userTableValuesShouldBe(List<User> users){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        int i = 0;
        for(User user:users){
            assertTrue(userTablePage.getUserNames().get(i).getText().contains(user.getName()));
            assertTrue(userTablePage.getUserDescrs().get(i).getText().contains(user.getDescription()));
            assertTrue(userTablePage.getUserNumbers().get(i).getText().contains(user.getNumber()));
            i++;
        }
    }
    @Then("1 log row has \".*\" text in log section")
    public void logRowHasValue(String logText){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        assertTrue(userTablePage.findLogLine(logText).isDisplayed());
    }
    @Then("droplist contains values")
    public void droplistValuesAre(List<String> values){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        for(WebElement elem:userTablePage.getUserTypeSelects().get(0).getOptions()){
            assertTrue(values.contains(elem.getText()));
        }
    }
}
