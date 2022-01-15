package com.joaovictorsm.padcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultMomentoActivity extends AppCompatActivity {

    private TextView valor_carga_momento;
    private TextView valor_lado_a_pilar_momento;
    private TextView valor_lado_b_pilar_momento;
    private TextView valor_cobrimento_momento;
    private TextView valor_fck_momento;
    private TextView valor_tensao_solo_momento;
    private TextView valor_tipo_de_aco_momento;
    private TextView lado_a_sapata_valor_momento;
    private TextView lado_b_sapata_valor_momento;
    private TextView h_sapata_valor_momento;
    private TextView h_zero_sapata_valor_momento;
    private TextView momento_x_valor_momento;
    private TextView momento_y_valor_momento;
    private TextView valor_aco_a_momento;
    private TextView valor_aco_b_momento;
    private TextView valor_num_0_momento;
    private TextView valor_num_1_momento;
    private TextView valor_num_2_momento;
    private TextView valor_num_3_momento;
    private TextView valor_num_4_momento;
    private TextView valor_num_5_momento;
    private TextView valor_esp_0_momento;
    private TextView valor_esp_1_momento;
    private TextView valor_esp_2_momento;
    private TextView valor_esp_3_momento;
    private TextView valor_esp_4_momento;
    private TextView valor_esp_5_momento;
    private TextView valor_num_b_0_momento;
    private TextView valor_num_b_1_momento;
    private TextView valor_num_b_2_momento;
    private TextView valor_num_b_3_momento;
    private TextView valor_num_b_4_momento;
    private TextView valor_num_b_5_momento;
    private TextView valor_esp_b_0_momento;
    private TextView valor_esp_b_1_momento;
    private TextView valor_esp_b_2_momento;
    private TextView valor_esp_b_3_momento;
    private TextView valor_esp_b_4_momento;
    private TextView valor_esp_b_5_momento;
    private TextView valor_aco_pilar_momento;
    private TextView valor_mx_momento;
    private TextView valor_my_momento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_momento);
        getSupportActionBar().setTitle(R.string.sapata_momento_fletor_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = this.getIntent();

        ResultMomento resultadoMomento = (ResultMomento) i.getSerializableExtra("resultado_momento");
        float aco_escolhido = i.getFloatExtra("tipo_aco", 0);
        String texto_aco = "";
        if (aco_escolhido == 500) {
            texto_aco = getResources().getString(R.string.ca_50);
        } else {
            texto_aco = getResources().getString(R.string.ca_60);
        }
        Log.e("veio pra result com", texto_aco);
        Log.e("", resultadoMomento.toString());


//----------------------FindViewById = Pega a célula -----------------------------------------
        valor_carga_momento = findViewById(R.id.valor_carga_momento);
        valor_lado_a_pilar_momento = findViewById(R.id.valor_lado_a_pilar_momento);
        valor_lado_b_pilar_momento = findViewById(R.id.valor_lado_b_pilar_momento);
        valor_cobrimento_momento = findViewById(R.id.valor_cobrimento_momento);
        valor_fck_momento = findViewById(R.id.valor_fck_momento);
        valor_tensao_solo_momento = findViewById(R.id.valor_tensao_solo_momento);
        valor_tipo_de_aco_momento = findViewById(R.id.valor_tipo_de_aco_momento);
        lado_a_sapata_valor_momento = findViewById(R.id.lado_a_sapata_valor_momento);
        lado_b_sapata_valor_momento = findViewById(R.id.lado_b_sapata_valor_momento);
        h_sapata_valor_momento = findViewById(R.id.h_sapata_valor_momento);
        h_zero_sapata_valor_momento = findViewById(R.id.h_zero_sapata_valor_momento);
        momento_x_valor_momento = findViewById(R.id.momento_x_valor_momento);
        momento_y_valor_momento = findViewById(R.id.momento_y_valor_momento);
        valor_aco_a_momento = findViewById(R.id.valor_aco_a_momento);
        valor_aco_b_momento = findViewById(R.id.valor_aco_b_momento);
        valor_num_0_momento = findViewById(R.id.valor_num_0_momento);
        valor_num_1_momento = findViewById(R.id.valor_num_1_momento);
        valor_num_2_momento = findViewById(R.id.valor_num_2_momento);
        valor_num_3_momento = findViewById(R.id.valor_num_3_momento);
        valor_num_4_momento = findViewById(R.id.valor_num_4_momento);
        valor_num_5_momento = findViewById(R.id.valor_num_5_momento);
        valor_esp_0_momento = findViewById(R.id.valor_esp_0_momento);
        valor_esp_1_momento = findViewById(R.id.valor_esp_1_momento);
        valor_esp_2_momento = findViewById(R.id.valor_esp_2_momento);
        valor_esp_3_momento = findViewById(R.id.valor_esp_3_momento);
        valor_esp_4_momento = findViewById(R.id.valor_esp_4_momento);
        valor_esp_5_momento = findViewById(R.id.valor_esp_5_momento);
        valor_num_b_0_momento = findViewById(R.id.valor_num_b_0_momento);
        valor_num_b_1_momento = findViewById(R.id.valor_num_b_1_momento);
        valor_num_b_2_momento = findViewById(R.id.valor_num_b_2_momento);
        valor_num_b_3_momento = findViewById(R.id.valor_num_b_3_momento);
        valor_num_b_4_momento = findViewById(R.id.valor_num_b_4_momento);
        valor_num_b_5_momento = findViewById(R.id.valor_num_b_5_momento);
        valor_esp_b_0_momento = findViewById(R.id.valor_esp_b_0_momento);
        valor_esp_b_1_momento = findViewById(R.id.valor_esp_b_1_momento);
        valor_esp_b_2_momento = findViewById(R.id.valor_esp_b_2_momento);
        valor_esp_b_3_momento = findViewById(R.id.valor_esp_b_3_momento);
        valor_esp_b_4_momento = findViewById(R.id.valor_esp_b_4_momento);
        valor_esp_b_5_momento = findViewById(R.id.valor_esp_b_5_momento);
        valor_aco_pilar_momento = findViewById(R.id.valor_aco_pilar_momento);
        valor_mx_momento = findViewById(R.id.valor_mx_momento);
        valor_my_momento = findViewById(R.id.valor_my_momento);


//--------------------------------SetText = Define o texto que vai aparecer na célula-------------------------
        valor_carga_momento.setText(" " + String.format("%.2f", resultadoMomento.getCargaPilar()) + " ");
        valor_lado_a_pilar_momento.setText(" " + String.format("%.2f", resultadoMomento.getAp()) + " ");
        valor_lado_b_pilar_momento.setText(" " + String.format("%.2f", resultadoMomento.getBp()) + " ");
        valor_cobrimento_momento.setText(" " + String.format("%.2f", resultadoMomento.getCobrimento()) + " ");
        valor_fck_momento.setText(" " + String.format("%.2f", resultadoMomento.getFck()) + " ");
        valor_tensao_solo_momento.setText(" " + String.format("%.2f", resultadoMomento.getTensaoSolo()) + " ");
        valor_tipo_de_aco_momento.setText(" = " + texto_aco);
        lado_a_sapata_valor_momento.setText(" " + String.format("%.2f", resultadoMomento.getA()) + " ");
        lado_b_sapata_valor_momento.setText(" " + String.format("%.2f", resultadoMomento.getB()) + " ");
        h_sapata_valor_momento.setText(" " + String.format("%.2f", resultadoMomento.getH()) + " ");
        h_zero_sapata_valor_momento.setText(" " + String.format("%.2f", resultadoMomento.getHzero()) + " ");
        momento_x_valor_momento.setText(" " + String.format("%.2f", resultadoMomento.getM1ak()) + " ");
        momento_y_valor_momento.setText(" " + String.format("%.2f", resultadoMomento.getM1bk()) + " ");
        valor_aco_a_momento.setText(" " + String.format("%.2f", resultadoMomento.getAreaAcoA()) + " ");
        valor_aco_b_momento.setText(" " + String.format("%.2f", resultadoMomento.getAreaAcoB()) + " ");
        valor_num_0_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasA()[0]));
        valor_num_1_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasA()[1]));
        valor_num_2_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasA()[2]));
        valor_num_3_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasA()[3]));
        valor_num_4_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasA()[4]));
        valor_num_5_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasA()[5]));
        valor_esp_0_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasA()[0]));
        valor_esp_1_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasA()[1]));
        valor_esp_2_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasA()[2]));
        valor_esp_3_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasA()[3]));
        valor_esp_4_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasA()[4]));
        valor_esp_5_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasA()[5]));
        valor_num_b_0_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasB()[0]));
        valor_num_b_1_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasB()[1]));
        valor_num_b_2_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasB()[2]));
        valor_num_b_3_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasB()[3]));
        valor_num_b_4_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasB()[4]));
        valor_num_b_5_momento.setText(" " + String.format("%.2f", resultadoMomento.getNumeroBarrasB()[5]));
        valor_esp_b_0_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasB()[0]));
        valor_esp_b_1_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasB()[1]));
        valor_esp_b_2_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasB()[2]));
        valor_esp_b_3_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasB()[3]));
        valor_esp_b_4_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasB()[4]));
        valor_esp_b_5_momento.setText(" " + String.format("%.2f", resultadoMomento.getEspacamentoBarrasB()[5]));
        valor_aco_pilar_momento.setText(" " + String.format("%.2f", resultadoMomento.getAcoPilar()) + " ");
        valor_mx_momento.setText(" " + String.format("%.2f", resultadoMomento.getMx()) + " ");
        valor_my_momento.setText(" " + String.format("%.2f", resultadoMomento.getMy()) + " ");


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
            startActivity(new Intent(ResultMomentoActivity.this, ModeloDeCalculo.class));
            return super.onOptionsItemSelected(item);
        } else {
            finish();
            return true;

        }

    }

}




