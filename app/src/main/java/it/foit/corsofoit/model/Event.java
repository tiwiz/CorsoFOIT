package it.foit.corsofoit.model;

import android.support.annotation.DrawableRes;

public final class Event {

    @DrawableRes
    private final int image;
    private final String title;
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
