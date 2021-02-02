package kg.geektech.android3.lessson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import kg.geektech.android3.lessson_2.R;
import kg.geektech.android3.lessson_2.data.model.Film;
import kg.geektech.android3.lessson_2.data.remote.GhibliApi;
import kg.geektech.android3.lessson_2.data.remote.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFilm();
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
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Film>> call, Throwable t) {
                        Log.e("jajaja", "onResponse: "+ t.getLocalizedMessage());
                    }
                });
    }
}