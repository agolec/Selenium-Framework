package ag.framework.pages;

import java.util.Objects;

public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }
    public String toString(){
        return
                this.name + "\n" +
                this.price;
    }
    public String getName(){
        return this.name;
    }
    public Double getPrice(){
        return this.price;
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }
        //safe to cast?
        Product sourceProduct = (Product) o;
         return (this.getName().equals(sourceProduct.getName())
        && this.getPrice().equals(sourceProduct.getPrice()));
    }
    public int hashCode(){
        return Objects.hash(getName(),getPrice());
    }
}
