package ag.framework.applications.herokuapp.tests.dataprovider;

import ag.framework.applications.herokuapp.tests.DropdownTest;
import ag.framework.applications.herokuapp.tests.data.DropdownPageData;
import org.testng.annotations.DataProvider;

public class DropdownTestProvider {
    @DataProvider(name = "defaultDropdownText")
        public Object [][] defaultText() {
            return new Object[][]{
                    {DropdownPageData.DEFAULT_OPTION,DropdownPageData.OPTION_1}
        };
    }
}
