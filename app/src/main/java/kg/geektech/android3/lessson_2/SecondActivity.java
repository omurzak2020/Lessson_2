package kg.geektech.android3.lessson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import kg.geektech.android3.lessson_2.data.model.Film;
import kg.geektech.android3.lessson_2.data.remote.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SecondActivity extends AppCompatActivity {
    private String id;
    private TextView title, description, director,people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();

        Intent intent = getIntent();
        id = intent.getStringExtra("key");
        Toast.makeText(this, "ololol " + id, Toast.LENGTH_SHORT).show();
        getFilmByID();

    }

    private void init() {
        title = findViewById(R.id.titlefilm);
        description = findViewById(R.id.descriptionfilm);
        director = findViewById(R.id.directorfilm);
        people = findViewById(R.id.peoplefilm);
    }

    private void getFilmByID() {
        RetrofitFactory.getInstance().getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                title.setText(response.body().getTitle());
                director.setText(response.body().getDirector());
                description.setText(response.body().getDescription());
                // people.setText(response.body().getPeople());
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });

    }


}