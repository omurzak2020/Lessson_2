package kg.geektech.android3.lessson_2.data.remote;

import java.util.List;

import kg.geektech.android3.lessson_2.data.model.Film;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET(Endpoints.GET_FILM)
    Call<Film> getFilm(
        @Path("id") String id
    );

    @GET(Endpoints.GET_FILMS)
    Call<List<Film>> getFilms();
}
