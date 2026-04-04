package ag.framework.tests.utils;

import ag.framework.utils.SortingTestData;
import org.testng.annotations.DataProvider;

public class SortingTestDataProvider {
    @DataProvider(name = "sortOptions")
    public Object[][] getSortOptions() {
        return SortingTestData.sortOptions();
    }
}