package org.mousehole.americanairline.gymequipmentinventory.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GymEquipment implements Parcelable {

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

    protected GymEquipment(Parcel in) {
        name = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
        description = in.readString();
        id = in.readInt();
        url = in.readString();
    }

    public static final Creator<GymEquipment> CREATOR = new Creator<GymEquipment>() {
        @Override
        public GymEquipment createFromParcel(Parcel in) {
            return new GymEquipment(in);
        }

        @Override
        public GymEquipment[] newArray(int size) {
            return new GymEquipment[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(quantity);
        parcel.writeDouble(price);
        parcel.writeString(description);
        parcel.writeInt(id);
        parcel.writeString(url);
    }
}
