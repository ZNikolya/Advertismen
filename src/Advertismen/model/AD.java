package Advertismen.model;

import java.util.Date;

public class AD {

    private String title;
    private String text;
    private int price;
    private Date createdData;
    private String category;
    private User user;

    public AD(String title, String text, int price, Date createdData, String category, User user) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.createdData = createdData;
        this.category = category;
        this.user = user;
    }

    public AD() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AD ad = (AD) o;

        if (price != ad.price) return false;
        if (title != null ? !title.equals(ad.title) : ad.title != null) return false;
        if (text != null ? !text.equals(ad.text) : ad.text != null) return false;
        if (createdData != null ? !createdData.equals(ad.createdData) : ad.createdData != null) return false;
        if (category != null ? !category.equals(ad.category) : ad.category != null) return false;
        return user != null ? user.equals(ad.user) : ad.user == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (createdData != null ? createdData.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AD{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", createdData=" + createdData +
                ", category='" + category + '\'' +
                ", user=" + user +
                '}';
    }
}
