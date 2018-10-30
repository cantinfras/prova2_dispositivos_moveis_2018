package professorangoti.com.interaocomousuario.activities.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    public static PriceApi getPriceApi() {
        return getApiCaller().create(PriceApi.class);
    }

    private static Retrofit getApiCaller() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return new Retrofit.Builder()
                .baseUrl("http://provaddm2018.atwebpages.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
