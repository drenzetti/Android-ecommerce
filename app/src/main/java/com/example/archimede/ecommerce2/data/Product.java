package com.example.archimede.ecommerce2.data;

/**
 * Created by archimede on 14/06/17.
 */

public class Product {
    private String name;
    private String desc;
    private double price;
    private boolean bookmark;


    public Product(String name, String desc, double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.bookmark = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (bookmark != product.bookmark) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return desc != null ? desc.equals(product.desc) : product.desc == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (bookmark ? 1 : 0);
        return result;
    }

    public boolean isBookmark() {

        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
