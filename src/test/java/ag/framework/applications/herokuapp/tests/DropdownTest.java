package ag.framework.applications.herokuapp.tests;

import ag.applications.herokuapp.pages.DropdownPage;
import ag.applications.herokuapp.pages.FrontPage;
import ag.framework.applications.herokuapp.tests.data.DropdownPageData;
import ag.framework.applications.herokuapp.tests.dataprovider.DropdownTestProvider;
import ag.framework.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test(dataProvider = "defaultDropdownText", dataProviderClass = DropdownTestProvider.class, groups = {"herokuapp"})
    public void verifyDropdownSelection(String expectedDefault, String optionToSelect){
        //navigate to baseurl, then dropdown page.

        FrontPage frontPage = new FrontPage(driver);
        frontPage.clickDropdownLink();

        DropdownPage dropdown = new DropdownPage(driver);

        //verify default
        String defaultOption = dropdown.getDefaultSelectedText();
        System.out.println("Default option is: " + defaultOption);
        Assert.assertEquals(defaultOption,expectedDefault);

        dropdown.getSelectedOptionByVisibleText(optionToSelect);

        //verify selection
        String selectedOption = dropdown.getDefaultSelectedText();
        System.out.println("Selected option: " + selectedOption);
        Assert.assertEquals(selectedOption,optionToSelect);
    }
}
