package kg.geektech.android3.lessson_2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.android3.lessson_2.R;
import kg.geektech.android3.lessson_2.data.model.Film;
import retrofit2.Response;

public class AdapterFilm extends RecyclerView.Adapter<AdapterFilm.FilmViewholder>{

    private List<Film> list = new ArrayList<>();
    private Listenerr listenerr;


    @NonNull
    @Override
    public FilmViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_film,parent,false);
        return new FilmViewholder(view,listenerr);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewholder holder, int position) {
        holder.onbind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setlist(List<Film> response) {
        list.addAll(response);
        notifyDataSetChanged();
    }

    public void setListenerr(Listenerr listenerr){
        this.listenerr = listenerr;

    }

    class FilmViewholder extends RecyclerView.ViewHolder{

        private TextView textTitle;
        private  Listenerr listenerr;

       public FilmViewholder(@NonNull View itemView,Listenerr listenerr) {
           super(itemView);
           this.listenerr = listenerr;
        textTitle = itemView.findViewById(R.id.text_title);

       }


        public void onbind(Film film) {
        textTitle.setText(film.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerr.onFilmClick(film.getId());

            }
        });

        }
    }

  public   interface Listenerr{
        void  onFilmClick(String id);
    }
}
