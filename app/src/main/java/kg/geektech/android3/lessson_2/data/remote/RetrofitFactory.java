package kg.geektech.android3.lessson_2.data.remote;

import kg.geektech.android3.lessson_2.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private RetrofitFactory() { }

    private static GhibliApi instance;

    public static GhibliApi getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(GhibliApi.class);
        }
        return instance;
    }
}
