package professorangoti.com.interaocomousuario.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import professorangoti.com.interaocomousuario.R;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String pedido;
    private int entrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        pedido = intent.getStringExtra("mensagem");
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(pedido);

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    entrega = R.string.entrega_no_dia_seguinte;
                    displayToast(getString(entrega));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    entrega = R.string.entrega_no_dia_seguinte;
                    displayToast(getString(entrega));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    entrega = R.string.retirar_na_loja;
                    displayToast(getString(entrega));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        displayToast(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void fecharConta(View view) {
        Intent intent = new Intent(OrderActivity.this, ValorPedidoActivity.class);
        intent.putExtra("pedido", pedido);
        startActivity(intent);
    }
}
