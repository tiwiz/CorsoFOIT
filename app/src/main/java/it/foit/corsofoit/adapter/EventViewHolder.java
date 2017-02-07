package it.foit.corsofoit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import it.foit.corsofoit.R;
import it.foit.corsofoit.model.Event;

class EventViewHolder extends RecyclerView.ViewHolder {

    private ImageView eventIcon;
    private TextView eventTitle;
    private TextView eventDate;

    EventViewHolder(View itemView) {
        super(itemView);

        eventIcon = (ImageView) itemView.findViewById(R.id.elementIcon);
        eventTitle = (TextView) itemView.findViewById(R.id.elementTitle);
        eventDate = (TextView) itemView.findViewById(R.id.elementTime);
    }

    void bindTo(Event event){
        eventIcon.setImageResource(event.getImage());
        eventTitle.setText(event.getTitle());
        eventDate.setText(event.getDateTime());
    }
}
