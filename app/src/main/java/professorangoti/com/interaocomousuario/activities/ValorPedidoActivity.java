package professorangoti.com.interaocomousuario.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import professorangoti.com.interaocomousuario.R;
import professorangoti.com.interaocomousuario.activities.api.PriceApi;
import professorangoti.com.interaocomousuario.activities.api.RetrofitFactory;
import professorangoti.com.interaocomousuario.activities.domain.Price;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ValorPedidoActivity extends AppCompatActivity {

    private String pedido;
    private List<Price> valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        pedido = intent.getStringExtra("pedido");
        Log.i("pedido", "Seu Pedido: " + pedido);

        PriceApi api = RetrofitFactory.getPriceApi();
        api.getPrices().enqueue(new Callback<List<Price>>() {

            @Override
            public void onResponse(Call<List<Price>> call, Response<List<Price>> response) {
                valores = response.body();
                Log.i("prices:", valores.toString());

                for (Price price : valores) {
                    if (price.getProduto().contains(pedido)) {
                        TextView textView = findViewById(R.id.preco);
                        textView.setText(price.getValor());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Price>> call, Throwable t) {
                Log.e("Erro", "Erro na listagem dos valores", t);
            }
        });

    }
}
