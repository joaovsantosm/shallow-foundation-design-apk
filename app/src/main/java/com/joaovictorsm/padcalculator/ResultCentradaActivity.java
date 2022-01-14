package com.joaovictorsm.padcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultCentradaActivity extends AppCompatActivity {

    private TextView valor_carga, valor_lado_a_pilar, valor_lado_b_pilar, valor_cobrimento, valor_fck, valor_tensao_solo,
            valor_tipo_de_aco, lado_a_sapata_valor, lado_b_sapata_valor, h_sapata_valor, h_zero_sapata_valor,
            momento_x_valor, momento_y_valor, valor_aco_a, valor_aco_b, valor_num_0, valor_num_1, valor_num_2, valor_num_3,
            valor_num_4, valor_num_5, valor_esp_0, valor_esp_1, valor_esp_2, valor_esp_3, valor_esp_4, valor_esp_5, valor_num_b_0,
            valor_num_b_1, valor_num_b_2, valor_num_b_3, valor_num_b_4, valor_num_b_5, valor_esp_b_0, valor_esp_b_1, valor_esp_b_2,
            valor_esp_b_3, valor_esp_b_4, valor_esp_b_5, valor_aco_pilar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_centrada);
        getSupportActionBar().setTitle(R.string.sapata_centrada_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = this.getIntent();

        Result resultado = (Result) i.getSerializableExtra("resultado");
        float aco_escolhido = i.getFloatExtra("tipo_aco", 0);
        String texto_aco = "";
        if (aco_escolhido == 500) {
            texto_aco = getResources().getString(R.string.ca_50);
        } else {
            texto_aco = getResources().getString(R.string.ca_60);
        }

        Log.e("Veio para a Centrada:", "" + resultado);
//----------------------FindViewById = Pega a célula -----------------------------------------
        valor_carga = findViewById(R.id.valor_carga);
        valor_lado_a_pilar = findViewById(R.id.valor_lado_a_pilar);
        valor_lado_b_pilar = findViewById(R.id.valor_lado_b_pilar);
        valor_cobrimento = findViewById(R.id.valor_cobrimento);
        valor_fck = findViewById(R.id.valor_fck);
        valor_tensao_solo = findViewById(R.id.valor_tensao_solo);
        valor_tipo_de_aco = findViewById(R.id.valor_tipo_de_aco);
        lado_a_sapata_valor = findViewById(R.id.lado_a_sapata_valor);
        lado_b_sapata_valor = findViewById(R.id.lado_b_sapata_valor);
        h_sapata_valor = findViewById(R.id.h_sapata_valor);
        h_zero_sapata_valor = findViewById(R.id.h_zero_sapata_valor);
        momento_x_valor = findViewById(R.id.momento_x_valor);
        momento_y_valor = findViewById(R.id.momento_y_valor);
        //Lado A
        valor_aco_a = findViewById(R.id.valor_aco_a);
        valor_aco_b = findViewById(R.id.valor_aco_b);
        valor_num_0 = findViewById(R.id.valor_num_0);
        valor_num_1 = findViewById(R.id.valor_num_1);
        valor_num_2 = findViewById(R.id.valor_num_2);
        valor_num_3 = findViewById(R.id.valor_num_3);
        valor_num_4 = findViewById(R.id.valor_num_4);
        valor_num_5 = findViewById(R.id.valor_num_5);
        valor_esp_0 = findViewById(R.id.valor_esp_0);
        valor_esp_1 = findViewById(R.id.valor_esp_1);
        valor_esp_2 = findViewById(R.id.valor_esp_2);
        valor_esp_3 = findViewById(R.id.valor_esp_3);
        valor_esp_4 = findViewById(R.id.valor_esp_4);
        valor_esp_5 = findViewById(R.id.valor_esp_5);
        //Lado B
        valor_num_b_0 = findViewById(R.id.valor_num_b_0);
        valor_num_b_1 = findViewById(R.id.valor_num_b_1);
        valor_num_b_2 = findViewById(R.id.valor_num_b_2);
        valor_num_b_3 = findViewById(R.id.valor_num_b_3);
        valor_num_b_4 = findViewById(R.id.valor_num_b_4);
        valor_num_b_5 = findViewById(R.id.valor_num_b_5);
        valor_esp_b_0 = findViewById(R.id.valor_esp_b_0);
        valor_esp_b_1 = findViewById(R.id.valor_esp_b_1);
        valor_esp_b_2 = findViewById(R.id.valor_esp_b_2);
        valor_esp_b_3 = findViewById(R.id.valor_esp_b_3);
        valor_esp_b_4 = findViewById(R.id.valor_esp_b_4);
        valor_esp_b_5 = findViewById(R.id.valor_esp_b_5);
        //Aço do pilar
        valor_aco_pilar = findViewById(R.id.valor_aco_pilar);
        //Símbolos, subescrito, sobrescrito etc


//--------------------------------SetText = Define o texto que vai aparecer na célula-------------------------
        valor_carga.setText(" " + String.format("%.2f", resultado.getCargaPilar()) + " ");
        valor_lado_a_pilar.setText(" " + String.format("%.2f", resultado.getAp()) + " ");
        valor_lado_b_pilar.setText(" " + String.format("%.2f", resultado.getBp()) + " ");
        valor_cobrimento.setText(" " + String.format("%.2f", resultado.getCobrimento()) + " ");
        valor_fck.setText(" " + String.format("%.2f", resultado.getFck()) + " ");
        valor_tensao_solo.setText(" " + String.format("%.2f", resultado.getTensaoSolo()) + " ");
        valor_tipo_de_aco.setText(" = " + texto_aco);
        lado_a_sapata_valor.setText(" " + String.format("%.2f", resultado.getA()) + " ");
        lado_b_sapata_valor.setText(" " + String.format("%.2f", resultado.getB()) + " ");
        h_sapata_valor.setText(" " + String.format("%.2f", resultado.getH()) + " ");
        h_zero_sapata_valor.setText(" " + String.format("%.2f", resultado.getHzero()) + " ");
        momento_x_valor.setText(" " + String.format("%.2f", resultado.getM1ak()) + " ");
        momento_y_valor.setText(" " + String.format("%.2f", resultado.getM1bk()) + " ");
        valor_aco_a.setText(" " + String.format("%.2f", resultado.getAreaAcoA()) + " ");
        valor_aco_b.setText(" " + String.format("%.2f", resultado.getAreaAcoB()) + " ");
        //---------------Tabela de barras Lado A ------------------------------------//
        valor_num_0.setText(String.format("%.2f", resultado.getNumeroBarrasA()[0]));
        valor_num_1.setText(String.format("%.2f", resultado.getNumeroBarrasA()[1]));
        valor_num_2.setText(String.format("%.2f", resultado.getNumeroBarrasA()[2]));
        valor_num_3.setText(String.format("%.2f", resultado.getNumeroBarrasA()[3]));
        valor_num_4.setText(String.format("%.2f", resultado.getNumeroBarrasA()[4]));
        valor_num_5.setText(String.format("%.2f", resultado.getNumeroBarrasA()[5]));
        valor_esp_0.setText(String.format("%.2f", resultado.getEspacamentoBarrasA()[0]));
        valor_esp_1.setText(String.format("%.2f", resultado.getEspacamentoBarrasA()[1]));
        valor_esp_2.setText(String.format("%.2f", resultado.getEspacamentoBarrasA()[2]));
        valor_esp_3.setText(String.format("%.2f", resultado.getEspacamentoBarrasA()[3]));
        valor_esp_4.setText(String.format("%.2f", resultado.getEspacamentoBarrasA()[4]));
        valor_esp_5.setText(String.format("%.2f", resultado.getEspacamentoBarrasA()[5]));
        //---------------Tabela de barras Lado B ------------------------------------//
        valor_num_b_0.setText(String.format("%.2f", resultado.getNumeroBarrasB()[0]));
        valor_num_b_1.setText(String.format("%.2f", resultado.getNumeroBarrasB()[1]));
        valor_num_b_2.setText(String.format("%.2f", resultado.getNumeroBarrasB()[2]));
        valor_num_b_3.setText(String.format("%.2f", resultado.getNumeroBarrasB()[3]));
        valor_num_b_4.setText(String.format("%.2f", resultado.getNumeroBarrasB()[4]));
        valor_num_b_5.setText(String.format("%.2f", resultado.getNumeroBarrasB()[5]));
        valor_esp_b_0.setText(String.format("%.2f", resultado.getEspacamentoBarrasB()[0]));
        valor_esp_b_1.setText(String.format("%.2f", resultado.getEspacamentoBarrasB()[1]));
        valor_esp_b_2.setText(String.format("%.2f", resultado.getEspacamentoBarrasB()[2]));
        valor_esp_b_3.setText(String.format("%.2f", resultado.getEspacamentoBarrasB()[3]));
        valor_esp_b_4.setText(String.format("%.2f", resultado.getEspacamentoBarrasB()[4]));
        valor_esp_b_5.setText(String.format("%.2f", resultado.getEspacamentoBarrasB()[5]));
        //Aço do pilar
        valor_aco_pilar.setText(" " + String.format("%.2f", resultado.getAcoPilar()) + " ");

        //Símbolos, subescrito, sobrescrito etc


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            Log.e("", "Clicou no i");
            startActivity(new Intent(ResultCentradaActivity.this, ModeloDeCalculo.class));
            return super.onOptionsItemSelected(item);
        } else {
            finish();
            return true;

        }

    }

}
