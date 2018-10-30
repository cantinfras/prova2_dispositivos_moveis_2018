package professorangoti.com.interaocomousuario.activities.api;

import java.util.List;

import professorangoti.com.interaocomousuario.activities.domain.Price;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PriceApi {

    @GET("/precos")
    Call<List<Price>> getPrices();
}
