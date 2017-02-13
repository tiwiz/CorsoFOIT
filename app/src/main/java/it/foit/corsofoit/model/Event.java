package it.foit.corsofoit.model;

import com.google.gson.annotations.SerializedName;

public final class Event {

    private final int id;
    @SerializedName("immagine")
    private final String image;
    @SerializedName("titolo")
    private final String title;
    @SerializedName("data")
    private final String dateTime;
    @SerializedName("costo")
    private final float price;

    public Event(int id, String image, String title, String dateTime, float price) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.dateTime = dateTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public float getPrice() {
        return price;
    }
}
