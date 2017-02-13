package it.foit.corsofoit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import it.foit.corsofoit.DateConverter;
import it.foit.corsofoit.R;
import it.foit.corsofoit.model.Event;

import static it.foit.corsofoit.DateConverter.*;

class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView eventIcon;
    private TextView eventTitle;
    private TextView eventDate;

    private Event event;
    private final OnElementTappedListener listener;

    EventViewHolder(View itemView, final OnElementTappedListener listener) {
        super(itemView);

        this.listener = listener;

        eventIcon = (ImageView) itemView.findViewById(R.id.elementIcon);
        eventTitle = (TextView) itemView.findViewById(R.id.elementTitle);
        eventDate = (TextView) itemView.findViewById(R.id.elementTime);

        itemView.setOnClickListener(this);

    }

    void bindTo(Event event){
        this.event = event;

        Picasso.with(itemView.getContext())
                .load(event.getImage())
                .into(eventIcon);

        eventTitle.setText(event.getTitle());
        eventDate.setText(convertToHumanReadableTime(event.getDateTime()));
    }

    @Override
    public void onClick(View v) {
        listener.onElementTapped(event);
    }
}
