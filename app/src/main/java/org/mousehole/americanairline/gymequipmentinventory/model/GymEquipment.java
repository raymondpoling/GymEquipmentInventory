package org.mousehole.americanairline.gymequipmentinventory.model;

public class GymEquipment {

    private String name;
    private int quantity;
    private double price;
    private String description;
    private int id;
    private String url;

    public GymEquipment(String name, int quantity, double price, String description, String url, int id) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.id = id;
        this.url = url;
    }

    public GymEquipment(String name, int quantity, double price, String description, String url) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
