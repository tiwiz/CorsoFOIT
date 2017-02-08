package it.foit.corsofoit.model;

import android.support.annotation.DrawableRes;

import com.google.gson.annotations.SerializedName;

public final class Event {

    @DrawableRes
    @SerializedName("immagine")
    private final int image;
    @SerializedName("titolo")
    private final String title;
    @SerializedName("data")
    private final String dateTime;

    public Event(int image, String title, String dateTime) {
        this.image = image;
        this.title = title;
        this.dateTime = dateTime;
    }

    @DrawableRes
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDateTime() {
        return dateTime;
    }
}
