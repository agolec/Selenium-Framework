package ag.applications.saucedemo.enums;

import ag.applications.saucedemo.pages.Product;

import java.util.Comparator;

public enum SortOption {

    NAME_ASC("Name (A to Z)", Comparator.comparing(Product::getName)),
    NAME_DESC("Name (Z to A)", Comparator.comparing(Product::getName).reversed()),
    PRICE_LOW_HIGH("Price (low to high)", Comparator.comparing(Product::getPrice)),
    PRICE_HIGH_LOW("Price (high to low)", Comparator.comparing(Product::getPrice).reversed());

    private final String label;
    private final Comparator<Product> comparator;

    SortOption(String label, Comparator<Product> comparator){
        this.label = label;
        this.comparator = comparator;
    }

    public String getLabel() {
        return label;
    }

    public Comparator<Product> getComparator() {
        return comparator;
    }
}