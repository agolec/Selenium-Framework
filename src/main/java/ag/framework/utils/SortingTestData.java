package ag.framework.utils;

import ag.framework.enums.SortOption;

public class SortingTestData {
    public static Object[][] sortOptions() {
        return new Object[][] {
                {SortOption.NAME_ASC},
                {SortOption.NAME_DESC},
                {SortOption.PRICE_LOW_HIGH},
                {SortOption.PRICE_HIGH_LOW}
        };
    }
}
