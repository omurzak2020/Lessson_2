package kg.geektech.android3.lessson_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import kg.geektech.android3.lessson_2.R;
import kg.geektech.android3.lessson_2.data.model.Film;
import kg.geektech.android3.lessson_2.data.remote.GhibliApi;
import kg.geektech.android3.lessson_2.data.remote.RetrofitFactory;
import kg.geektech.android3.lessson_2.ui.AdapterFilm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterFilm.Listenerr {

    private RecyclerView recyclerView;
    private AdapterFilm adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycler();
        loadFilm();

    }

    private void initRecycler() {
        adapter = new AdapterFilm();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        adapter.setListenerr(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
    }

    private void loadFilm() {
//        RetrofitFactory
//                .getInstance()
//                .getFilm("ebbb6b7c-945c-41ee-a792-de0e43191bd8")
//                .enqueue(new Callback<Film>() {
//                    @Override
//                    public void onResponse(Call<Film> call, Response<Film> response) {
//                        if (response.isSuccessful() && response.body() != null) {
//                            Log.d("tag", response.body().getTitle());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Film> call, Throwable t) {
//                        Log.d("tag", t.getLocalizedMessage());
//                    }
//                });
        RetrofitFactory
                .getInstance()
                .getFilms()
                .enqueue(new Callback<List<Film>>() {
                    @Override
                    public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                        if(response.isSuccessful() && response.body() != null){
                            Log.e("jajaja", "onResponse: "+ response.body().size());

                            adapter.setlist(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Film>> call, Throwable t) {
                        Log.e("jajaja", "onResponse: "+ t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void onFilmClick(String id) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("key",id);

        startActivity(intent);

        Toast.makeText(this,"ass", Toast.LENGTH_SHORT).show();
    }
}