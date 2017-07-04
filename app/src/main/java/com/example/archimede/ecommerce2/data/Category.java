package com.example.archimede.ecommerce2.data;

/**
 * Created by archimede on 06/06/17.
 */

public class Category {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category() {

    }

    private int id;
    private String title;
    private String image;
    private String description;

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", image=" + image +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        if (image != null ? !image.equals(category.image) : category.image != null) return false;
        return description != null ? description.equals(category.description) : category.description == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public String getTitle() {
    
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(String title, String image, String description) {
    
        this.title = title;
        this.image = image;
        this.description = description;
    }
}
