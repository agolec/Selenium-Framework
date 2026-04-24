package ag.framework.applications.saucedemo.data;

import ag.applications.saucedemo.data.SortingTestData;
import org.testng.annotations.DataProvider;

public class SortingTestDataProvider {
    @DataProvider(name = "sortOptions")
    public Object[][] getSortOptions() {
        return SortingTestData.sortOptions();
    }
}