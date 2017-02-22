package it.foit.corsofoit.model;

import com.google.gson.annotations.SerializedName;

public final class Event implements EventBase {

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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDateTime() {
        return dateTime;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
