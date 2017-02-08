package it.foit.corsofoit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import it.foit.corsofoit.R;
import it.foit.corsofoit.model.Event;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event> eventList;
    private final OnElementTappedListener listener;

    public EventAdapter(List<Event> eventList, final OnElementTappedListener listener) {
        this.eventList = eventList;
        this.listener = listener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         * Siccome ogni View può avere UNO ED UN SOLO parent, e noi abbiamo già specificato,
         * nella getLayoutInflater() quale parent ci da il Context, nella chiamata ad inflate()
         * dobbiamo dirgli che non si attacchi nuovamente al parent, ma tenga il primo.
         *
         * Non importa che sia lo stesso parent, la View non è abbastanza intelligente da comparare
         * i due, per lei sono diversi e se mettiamo a TRUE, si arrabbierà
         */
        View view = getLayoutInflater(parent).inflate(R.layout.single_element, parent, false);
        return new EventViewHolder(view, listener);
    }

    /**
     * Questo metodo serve ad ottenere un riferimento al {@link LayoutInflater}. QUesto oggetto serve
     * per collegare un layout ad una {@link View}. Per farlo, ci serve però un {@link Context}, un
     * God Object che ci permette di accedere a diversi servizi e file contenuti sul nostro dispositivo.
     * Possiamo ottenere il {@link Context} da diverse parti, ma noi abbiamo deciso di ottenerlo dal
     * <b>padre</b> del nostro layout, in modo da non doverlo passare dall'esterno.
     *
     * <b>Nota:</b> il fatto che sia il nostro {@code parent} a fornirci il {@link Context} è molto importante
     */
    private LayoutInflater getLayoutInflater(ViewGroup parent) {
        final Context context = parent.getContext();
        return LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.bindTo(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
