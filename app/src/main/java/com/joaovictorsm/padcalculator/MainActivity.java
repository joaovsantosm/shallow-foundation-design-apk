// CÓDIGO DA MAIN_ACTIVITY

package com.joaovictorsm.padcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText ladoAEditText;
    private EditText ladoBEditText;
    private EditText cobrimentoEditText;
    private EditText cargaEditText;
    private EditText fckEditText;
    private EditText tensaoEditText;
    private boolean cargaMomento;
    private TextView momentoxTextView;
    private EditText momentoxEditText;
    private TextView momentoyTextView;
    private EditText momentoyEditText;
    private RadioGroup radioGroup;
    private RadioButton radio1;
    private RadioButton radio2;
    private float aco_escolhido;
    private ImageButton infoImage;
    private Spinner spinner;
    private double aco_pilar = 0;
    private String[] listaAco = new String[]{"10 mm", "12.5 mm", "16 mm", "20 mm", "25 mm", "32 mm"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.main_dimensionamento);
        ladoAEditText = findViewById(R.id.caixa_pilar_a);
        ladoBEditText = findViewById(R.id.caixa_pilar_b);
        cobrimentoEditText = findViewById(R.id.caixa_cobrimento);
        cargaEditText = findViewById(R.id.caixa_carga);
        fckEditText = findViewById(R.id.caixa_fck);
        tensaoEditText = findViewById(R.id.caixa_tensao);
        cargaMomento = false;
        momentoxTextView = findViewById(R.id.rotulo_momentox);
        momentoyTextView = findViewById(R.id.rotulo_momentoy);
        momentoxEditText = findViewById(R.id.caixa_momentox);
        momentoyEditText = findViewById(R.id.caixa_momentoy);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaAco);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.selecionar_aco_pilar);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(16);
                if (position == 0) {
                    aco_pilar = 10.0;
                    Log.e(String.valueOf(aco_pilar), "pos 0");
                } else if (position == 1) {
                    aco_pilar = 12.5;
                    Log.e(String.valueOf(aco_pilar), "pos 1");
                } else if (position == 2) {
                    aco_pilar = 16.0;
                    Log.e(String.valueOf(aco_pilar), "pos 2");
                } else if (position == 3) {
                    aco_pilar = 20.0;
                    Log.e(String.valueOf(aco_pilar), "pos 3");
                } else if (position == 4) {
                    aco_pilar = 25.0;
                    Log.e(String.valueOf(aco_pilar), "pos 4");
                } else {
                    aco_pilar = 32.0;
                    Log.e(String.valueOf(aco_pilar), "pos 5");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast toast = Toast.makeText(getApplicationContext(), "Selecione o aço do pilar", Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.show();

            }
        });

        radioGroup = findViewById(R.id.radio_group);
        aco_escolhido = 500;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.radio1 == checkedId) {
                    Log.e("radio", "1");
                    aco_escolhido = 500;
                } else if (R.id.radio2 == checkedId) {
                    Log.e("radio", "2");
                    aco_escolhido = 600;
                } else {
                    Log.e("nenhum", "nenhum");
                }
            }
        });

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
            startActivity(new Intent(MainActivity.this, ModeloDeCalculo.class));
            return super.onOptionsItemSelected(item);
        } else {
            finish();
            return true;

        }

    }


    public void calcule(View view) {
        double ladoa, ladob, cobrimento, carga, fck, tensao, momentox, momentoy;
        String ladoAString = ladoAEditText.getText().toString();
        String ladoBString = ladoBEditText.getText().toString();
        String cobrimentoString = cobrimentoEditText.getText().toString();
        String cargaString = cargaEditText.getText().toString();
        String fckString = fckEditText.getText().toString();
        String tensaoString = tensaoEditText.getText().toString();
        try {
            ladoa = Double.parseDouble(ladoAString);
            ladob = Double.parseDouble(ladoBString);
            cobrimento = Double.parseDouble(cobrimentoString);
            carga = Double.parseDouble(cargaString);
            fck = Double.parseDouble(fckString);
            tensao = Double.parseDouble(tensaoString);
            if (cargaMomento) {
                // Abre as caixas para inserir os momentos
                momentox = Double.parseDouble(momentoxEditText.getText().toString());
                momentoy = Double.parseDouble(momentoyEditText.getText().toString());
                ResultMomento resultadoMomento = dimensionaSapatasComMomento(cobrimento, ladoa, ladob, aco_escolhido, carga, fck, tensao, momentox, momentoy, aco_pilar);
                if (resultadoMomento != null) {
                    Intent i = new Intent(MainActivity.this, ResultMomentoActivity.class);
                    i.putExtra("resultado_momento", resultadoMomento);
                    i.putExtra("tipo_aco", aco_escolhido);
                    MainActivity.this.startActivity(i);
                }
            } else {
                // vai pro negocio sem momento
                Result resultado = dimensionaSapatasSemMomento(cobrimento, ladoa, ladob, aco_escolhido, carga, fck, tensao, aco_pilar);
                if (resultado != null) {
                    Intent i = new Intent(MainActivity.this, ResultCentradaActivity.class);
                    i.putExtra("resultado", resultado);
                    i.putExtra("tipo_aco", aco_escolhido);
                    MainActivity.this.startActivity(i);
                }

            }
        } catch (Exception e) {
            Log.e("e", "Insira um número válido");
        }
    }

    public ResultMomento dimensionaSapatasComMomento(double cobrimento, double ap, double bp, double fyk, double cargaPilar, double fck, double tensaoSolo, double mx, double my, double aco_pilar) {

        double Ssapata = cargaPilar / tensaoSolo;
        double B = 5 * (Math
                .ceil(Math.abs((0.5 * (bp - ap) + Math.sqrt(0.25 * Math.pow((ap - bp), 2) + Ssapata * 10000)) / 5)));
        double A = 5 * (Math.ceil(Math.abs((Ssapata * 10000 / B) / 5))); // Arredonda para múltiplos de 5 (Round up) A
        System.out.println("A = " + A + " cm");
        System.out.println("B = " + B + " cm");                // Sapata
        double SSapataReal = A * B; // Área real após o arrendodamento em cm²
        // --------------- Valor de H total---------------------------
        double h1 = ((A - ap) / 3);
        double h2 = ((B - bp) / 3);
        double h = 5 * (Math.ceil(Math.abs(Math.max(h1, h2)) / 5));

        // --------------- Valor de ho---------------------------
        double hz1 = 15;
        double hz2 = h / 3;
        double hz3 = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
        double hz4 = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
        double hzero = 5 * (Math.round(Math.max(Math.max(hz1, hz2), Math.max(hz3, hz4)) / 5));
        double Vsapata = ((hzero * SSapataReal)
                + ((h - hzero) / 3) * (SSapataReal + (ap * bp) + (Math.sqrt(SSapataReal * ap * bp)))) / 1000000;
        int GammaConc = 25;
        double Psapata = Vsapata * GammaConc;
        double CargaReal = cargaPilar + Psapata;
        double TensaoReal = CargaReal / (SSapataReal / 10000);
        double ex = (mx / CargaReal) * 100; // em centímetros
        double ey = (my / CargaReal) * 100; // em centímetros
        double nx = ex / A;
        double ny = ey / B;
        double k = nx + ny;

        int num_iteracoes_nci = 0;
        int num_iteracoes_tensao = 0;

        while (k > 1.0 / 6.0) {
            num_iteracoes_nci += 1;
            A = A + 5;
            B = B + 5;
            System.out.println("A = " + A + " cm");
            System.out.println("B = " + B + " cm");                // Sapata
            SSapataReal = A * B; // Área real após o arrendodamento em cm²
            // --------------- Valor de H total---------------------------
            h1 = ((A - ap) / 3);
            h2 = ((B - bp) / 3);
            h = 5 * (Math.ceil(Math.abs(Math.max(h1, h2)) / 5));

            // --------------- Valor de ho---------------------------
            hz1 = 15;
            hz2 = h / 3;
            hz3 = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
            hz4 = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
            hzero = 5 * (Math.round(Math.max(Math.max(hz1, hz2), Math.max(hz3, hz4)) / 5));
            Vsapata = ((hzero * SSapataReal) + ((h - hzero) / 3) * (SSapataReal + (ap * bp) + (Math.sqrt(SSapataReal * ap * bp)))) / 1000000;
            GammaConc = 25;
            Psapata = Vsapata * GammaConc;
            CargaReal = cargaPilar + Psapata;
            TensaoReal = CargaReal / (SSapataReal / 10000);
            ex = (mx / CargaReal) * 100; // em centímetros
            ey = (my / CargaReal) * 100; // em centímetros
            nx = ex / A;
            ny = ey / B;
            k = nx + ny;

        }
        double tensao_maxima = (CargaReal / (A / 100 * B / 100))
                * (1 + (6 * (ex / 100) / (A / 100)) + (6 * (ey / 100) / (B / 100)));
        double tensao_minima = (CargaReal / (A / 100 * B / 100))
                * (1 - (6 * (ex / 100) / (A / 100)) - (6 * (ey / 100) / (B / 100)));
        while (tensao_maxima >= tensaoSolo) {

            num_iteracoes_tensao += 1;
            A = A + 5;
            B = B + 5;
            SSapataReal = A * B; // Área real após o arrendodamento

            // --------------- Valor de H total---------------------------
            h1 = ((A - ap) / 3);
            h2 = ((B - bp) / 3);
            h = 5 * (Math.ceil(Math.abs(Math.max(h1, h2)) / 5));

            // --------------- Valor de ho---------------------------
            hz1 = 15;
            hz2 = h / 3;
            hz3 = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
            hz4 = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
            hzero = 5 * (Math.round(Math.max(Math.max(hz1, hz2), Math.max(hz3, hz4)) / 5));
            Vsapata = ((hzero * SSapataReal)
                    + ((h - hzero) / 3) * (SSapataReal + (ap * bp) + (Math.sqrt(SSapataReal * ap * bp)))) / 1000000;
            Psapata = Vsapata * GammaConc;
            CargaReal = cargaPilar + Psapata;
            TensaoReal = CargaReal / (SSapataReal / 10000);
            tensao_maxima = (CargaReal / (A / 100 * B / 100))
                    * (1 + (6 * (ex / 100) / (A / 100)) + (6 * (ey / 100) / (B / 100))); // Característica
            tensao_minima = (CargaReal / (A / 100 * B / 100))
                    * (1 - (6 * (ex / 100) / (A / 100)) - (6 * (ey / 100) / (B / 100))); // Característica
            ex = (mx / CargaReal) * 100; // em centímetros
            ey = (my / CargaReal) * 100;

        }
        double d = h - 5;
        System.out.println("A = " + A + " cm");
        System.out.println("B = " + B + " cm");
        System.out.println("h0 = " + hzero + " cm");
        System.out.println("h = " + h + " cm");
        System.out.println("d = " + d + " cm");
        // Cálculo da ancoragem da armadura do pilar

        // Comprimento básico lb: lbBasico=aco_pilar*fyd/(4*fbd)

        double fctm;
        if (fck > 50.0) {
            fctm = 2.12 * (Math.log(1 + (0.11 * fck))); // Logarítmo Natural (ln)

        } else {
            fctm = 0.3 * (Math.pow(fck, (2.0 / 3.0)));

        }

        double fctd = 0.7 * fctm / 1.4;
        double n1 = 2.25;
        double n2 = 1.0;
        double n3 = 1.0;
        double fbd = fctd * n1 * n2 * n3;
        double lbBasico = (aco_pilar * (fyk / 1.15)) / (4 * fbd); // em milímetros

        // ---Comprimento necessário considerando As,ef = As,nec
        // Para sapatas, utilizaremos os ganchos dobrados, isto é, segundo a NBR 6118
        // (ABNT, 2014), para este caso
        // reduz-se o valor lb,básico para 70% deste. (lb, nec = alpha * lbBasico) Em
        // que alpha = 0,7;
        // Calcula-se o lbMinimo
        double lbMinimo = Math.max(0.3 * lbBasico, Math.max(10 * aco_pilar, 100)); // em milímetros
        double lbNecessario = Math.max(0.7 * lbBasico, lbMinimo);
        /*
         * Continuação. Bastos(2019) recomenda que a altura útil da sapata deve ser
         * maior de que o comprimento total de ancoragem da armadura do pilar. Assim,
         * faz-se:
         */
        //double d = h - 5; // em centímetros
        double Ca = (A - ap) / 2; // em centímetros
        double Cb = (B - bp) / 2; // em centímetros
        System.out.println("d = " + d + " cm");
        if (d < (lbNecessario / 10)) {

            d = 5 * (Math.ceil(Math.abs((lbNecessario / 10)) / 5));
            h = d + 5;
            // --------------- Valor de ho-----------------------
            double hz1new = 15;
            double hz2new = h / 3;
            double hz3new = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
            double hz4new = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
            hzero = 5 * (Math.round(Math.max(Math.max(hz1new, hz2new), Math.max(hz3new, hz4new)) / 5));
            System.out.println("VEIO PRA K");
            System.out.println("A = " + A + " cm");
            System.out.println("B = " + B + " cm");
            System.out.println("h0 = " + hzero + " cm");
            System.out.println("h = " + h + " cm");
            System.out.println("d = " + d + " cm");
            System.out.println("Lb Necessário = " + lbNecessario / 10 + " cm");
            System.out.println("ca = " + Ca + " cm");
            System.out.println("cb = " + Cb + " cm");
            System.out.println("-----------------------------");


        }


        if ((Ca >= (h / 2) && Ca <= (2 * h))) {

            double cisalhamentoAplicado = (CargaReal) / ((2 * ap + 2 * bp) * d);
            double cisalhamentoResistente = 0.27 * (1 - (fck / 250)) * (fck / 1.4);
            if (cisalhamentoAplicado <= cisalhamentoResistente) {
                // Continuar o dimensionaemnto das áreas de aço.
                Ssapata = cargaPilar / tensaoSolo;
                SSapataReal = A * B; // Área real após o arrendodamento em cm²
// --------------- Valor de H total---------------------------
                h1 = ((A - ap) / 3);
                h2 = ((B - bp) / 3);
                h = 5 * (Math.ceil(Math.abs(Math.max(h1, h2)) / 5));

// --------------- Valor de ho---------------------------
                hz1 = 15;
                hz2 = h / 3;
                hz3 = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
                hz4 = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
                hzero = 5 * (Math.round(Math.max(Math.max(hz1, hz2), Math.max(hz3, hz4)) / 5));
                d = h - 5;
                Vsapata = ((hzero * SSapataReal)
                        + ((h - hzero) / 3) * (SSapataReal + (ap * bp) + (Math.sqrt(SSapataReal * ap * bp)))) / 1000000;
                GammaConc = 25;
                Psapata = Vsapata * GammaConc;
                CargaReal = cargaPilar + Psapata;
                TensaoReal = CargaReal / (SSapataReal / 10000);
                double xa = Ca + 0.15 * ap;
                double xb = Cb + 0.15 * bp;
                // Momentos característicos
                double m1ak = TensaoReal * (B / 100) * ((Math.pow((xa / 100), 2)) / 2);
                double m1bk = TensaoReal * (A / 100) * ((Math.pow((xb / 100), 2)) / 2);
                // Cálculo da armadura mínima
                double areaAcoAMinima = (0.15 / 100) * h * xa;
                double areaAcoBMinima = (0.15 / 100) * h * xb;
                // Cálculo da área de aço em A e B:
                double areaAcoA = Math.max(((m1ak * 1.4 * 100) / (0.85 * d * fyk / 11.5)), areaAcoAMinima);
                double areaAcoB = Math.max(((m1bk * 1.4 * 100) / (0.85 * d * fyk / 11.5)), areaAcoBMinima);

                // ----------------Numero de Barras------------------------//
                // --------------LADO A--------------------------//
                double Aaco10 = (Math.PI * Math.pow(1, 2)) / 4; // 10 milímetros
                double Aaco12 = (Math.PI * Math.pow(1.25, 2)) / 4; // 12.5 milímetros
                double Aaco16 = (Math.PI * Math.pow(1.6, 2)) / 4; // 16 milímetros
                double Aaco20 = (Math.PI * Math.pow(2.0, 2)) / 4; // 20 milímetros
                double Aaco25 = (Math.PI * Math.pow(2.5, 2)) / 4; // 25 milímetros
                double Aaco32 = (Math.PI * Math.pow(3.2, 2)) / 4; // 32 milímetros

                double[] numeroBarrasA = new double[6];
                numeroBarrasA[0] = Math.ceil(areaAcoA / Aaco10);
                numeroBarrasA[1] = Math.ceil(areaAcoA / Aaco12);
                numeroBarrasA[2] = Math.ceil(areaAcoA / Aaco16);
                numeroBarrasA[3] = Math.ceil(areaAcoA / Aaco20);
                numeroBarrasA[4] = Math.ceil(areaAcoA / Aaco25);
                numeroBarrasA[5] = Math.ceil(areaAcoA / Aaco32);

                // ------------Lado B------------------//

                double[] numeroBarrasB = new double[6];
                numeroBarrasB[0] = Math.ceil(areaAcoB / Aaco10);
                numeroBarrasB[1] = Math.ceil(areaAcoB / Aaco12);
                numeroBarrasB[2] = Math.ceil(areaAcoB / Aaco16);
                numeroBarrasB[3] = Math.ceil(areaAcoB / Aaco20);
                numeroBarrasB[4] = Math.ceil(areaAcoB / Aaco25);
                numeroBarrasB[5] = Math.ceil(areaAcoB / Aaco32);

                // ----------------Distancia entre barras------------------------//
                double phi10 = 1.0;// cm
                double phi12 = 1.25;// cm
                double phi16 = 1.6;// cm
                double phi20 = 2.0;// cm
                double phi25 = 2.5;// cm
                double phi32 = 3.2;// cm

                // Espacamento Lado A
                double[] espacamentoBarrasA = new double[6];
                espacamentoBarrasA[0] = (B - 2 * cobrimento - numeroBarrasA[0] * phi10) / (numeroBarrasA[0] - 1);
                espacamentoBarrasA[1] = (B - 2 * cobrimento - numeroBarrasA[1] * phi12) / (numeroBarrasA[1] - 1);
                espacamentoBarrasA[2] = (B - 2 * cobrimento - numeroBarrasA[2] * phi16) / (numeroBarrasA[2] - 1);
                espacamentoBarrasA[3] = (B - 2 * cobrimento - numeroBarrasA[3] * phi20) / (numeroBarrasA[3] - 1);
                espacamentoBarrasA[4] = (B - 2 * cobrimento - numeroBarrasA[4] * phi25) / (numeroBarrasA[4] - 1);
                espacamentoBarrasA[5] = (B - 2 * cobrimento - numeroBarrasA[5] * phi32) / (numeroBarrasA[5] - 1);

                // Espacamento Lado B
                double[] espacamentoBarrasB = new double[6];
                espacamentoBarrasB[0] = (A - 2 * cobrimento - numeroBarrasB[0] * phi10) / (numeroBarrasB[0] - 1);
                espacamentoBarrasB[1] = (A - 2 * cobrimento - numeroBarrasB[1] * phi12) / (numeroBarrasB[1] - 1);
                espacamentoBarrasB[2] = (A - 2 * cobrimento - numeroBarrasB[2] * phi16) / (numeroBarrasB[2] - 1);
                espacamentoBarrasB[3] = (A - 2 * cobrimento - numeroBarrasB[3] * phi20) / (numeroBarrasB[3] - 1);
                espacamentoBarrasB[4] = (A - 2 * cobrimento - numeroBarrasB[4] * phi25) / (numeroBarrasB[4] - 1);
                espacamentoBarrasB[5] = (A - 2 * cobrimento - numeroBarrasB[5] * phi32) / (numeroBarrasB[5] - 1);

                double numIteracoes = num_iteracoes_nci + num_iteracoes_tensao;

                // Resultados
                System.out.println("A = " + A + " cm");
                System.out.println("B = " + B + " cm");
                System.out.println("h0 = " + hzero + " cm");
                System.out.println("h = " + h + " cm");
                System.out.println("d = " + d + " cm");
                System.out.println("Lb Necessário = " + lbNecessario / 10 + " cm");
                System.out.println("ca = " + Ca + " cm");
                System.out.println("cb = " + Cb + " cm");
                System.out.println("xa = " + xa + " cm");
                System.out.println("xb = " + xb + " cm");
                System.out.println("M1ad = " + m1ak * 1.4 + " KNm");
                System.out.println("M1bd = " + m1bk * 1.4 + " KNm");
                System.out.println("As,a = " + areaAcoA + " cm²");
                System.out.println("As,b = " + areaAcoB + " cm²");
                System.out.println("Carga Real app = " + CargaReal + " KN");
                System.out.println("Peso da Sapata = " + Psapata + " KN");
                //System.out.println("Carga do pilar bastos = " + cargaPilar * 1.05 + " KN");
                System.out.println("Volume da sapata = " + Vsapata + " m³");
                return new ResultMomento(cobrimento, ap, bp, aco_escolhido, cargaPilar, fck,
                        tensaoSolo, aco_pilar, mx, my, A, B, h, d, Ca, Cb, hzero, Vsapata,
                        Psapata, m1ak, m1bk, areaAcoA, areaAcoB, xa, xb, numIteracoes, numeroBarrasA,
                        numeroBarrasB, espacamentoBarrasA, espacamentoBarrasB);
            } else {
                Toast.makeText(this.getApplicationContext(), getResources().getString(R.string.nao_passou_cisalhamento), Toast.LENGTH_SHORT).show();
                return null;
            }

        } else {
            Toast.makeText(this.getApplicationContext(), getResources().getString(R.string.nao_passou_ceb), Toast.LENGTH_SHORT).show();
            return null;
        }

    }

    public void ativaCaixaMomento(View view) {
        cargaMomento = !cargaMomento; //Troca o valor da variável [negando] [V==> F e vice-versa]
        if (cargaMomento == true) {
            momentoxTextView.setVisibility(View.VISIBLE);
            momentoyTextView.setVisibility(View.VISIBLE);
            momentoxEditText.setVisibility(View.VISIBLE);
            momentoyEditText.setVisibility(View.VISIBLE);
        } else {
            momentoxTextView.setVisibility(View.GONE);
            momentoyTextView.setVisibility(View.GONE);
            momentoxEditText.setVisibility(View.GONE);
            momentoyEditText.setVisibility(View.GONE);
        }
        Log.e("mudou", cargaMomento + "");
    }

    public Result dimensionaSapatasSemMomento(double cobrimento, double ap, double bp, double fyk, double cargaPilar, double fck, double tensaoSolo, double aco_pilar) {


        double Ssapata = cargaPilar / tensaoSolo;
        double B = 5 * (Math
                .ceil(Math.abs((0.5 * (bp - ap) + Math.sqrt(0.25 * Math.pow((ap - bp), 2) + Ssapata * 10000)) / 5)));
        double A = 5 * (Math.ceil(Math.abs((Ssapata * 10000 / B) / 5))); // Arredonda para múltiplos de 5 (Round up)
        // A
        // Sapata
        double SSapataReal = A * B; // Área real após o arrendodamento
        // --------------- Valor de H total---------------------------
        double h1 = ((A - ap) / 3);
        double h2 = ((B - bp) / 3);
        double h = 5 * (Math.ceil(Math.abs(Math.max(h1, h2)) / 5));

        // --------------- Valor de ho---------------------------
        double hz1 = 15;
        double hz2 = h / 3;
        double hz3 = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
        double hz4 = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
        double hzero = 5 * (Math.round(Math.max(Math.max(hz1, hz2), Math.max(hz3, hz4)) / 5));
        double Vsapata = ((hzero * SSapataReal)
                + ((h - hzero) / 3) * (SSapataReal + (ap * bp) + (Math.sqrt(SSapataReal * ap * bp)))) / 1000000;
        int GammaConc = 25;
        double Psapata = Vsapata * GammaConc;
        double CargaReal = cargaPilar + Psapata;
        double TensaoReal = CargaReal / (Ssapata);
        int num_iteracoes = 0;

        while (TensaoReal >= tensaoSolo) {
            num_iteracoes += 1;
            A = A + 5;
            B = B + 5;
            SSapataReal = A * B; // Área real após o arrendodamento

            // --------------- Valor de H total---------------------------
            h1 = ((A - ap) / 3);
            h2 = ((B - bp) / 3);
            h = 5 * (Math.ceil(Math.abs(Math.max(h1, h2)) / 5));

            // --------------- Valor de ho---------------------------
            hz1 = 15;
            hz2 = h / 3;
            hz3 = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
            hz4 = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
            hzero = 5 * (Math.round(Math.max(Math.max(hz1, hz2), Math.max(hz3, hz4)) / 5));
            Vsapata = ((hzero * SSapataReal)
                    + ((h - hzero) / 3) * (SSapataReal + (ap * bp) + (Math.sqrt(SSapataReal * ap * bp)))) / 1000000;
            Psapata = Vsapata * GammaConc;
            CargaReal = cargaPilar + Psapata;
            TensaoReal = CargaReal / (SSapataReal / 10000);
        }
        // Cálculo da ancoragem da armadura do pilar
        // Comprimento básico lb: lbBasico=aco_pilar*fyd/(4*fbd)
        double fctm;
        if (fck > 50.0) {
            fctm = 2.12 * (Math.log(1 + (0.11 * fck))); // Logarítmo Natural (ln)

        } else {
            fctm = 0.3 * (Math.pow(fck, (2.0 / 3.0)));

        }

        double fctd = 0.7 * fctm / 1.4;
        double n1 = 2.25;
        double n2 = 1.0;
        double n3 = 1.0;
        double fbd = fctd * n1 * n2 * n3;
        double lbBasico = (aco_pilar * (fyk / 1.15)) / (4 * fbd); // em milímetros

        // ---Comprimento necessário considerando As,ef = As,nec
        // Para sapatas, utilizaremos os ganchos dobrados, isto é, segundo a NBR 6118
        // (ABNT, 2014), para este caso
        // reduz-se o valor lb,básico para 70% deste. (lb, nec = alpha * lbBasico) Em
        // que alpha = 0,7;
        // Calcula-se o lbMinimo
        double lbMinimo = Math.max(0.3 * lbBasico, Math.max(10 * aco_pilar, 100)); // em milímetros
        double lbNecessario = Math.max(0.7 * lbBasico, lbMinimo);
        // Continuação
        // Bastos(2019) recomenda que a altura útil da sapata deve ser maior de que o
        // comprimento total de
        // aconragem da armadura do pilar. Assim, faz-se:

        double d = h - 5; // em centímetros

        if (d < (lbNecessario / 10)) {
            d = 5 * (Math.ceil(Math.abs((lbNecessario / 10)) / 5));
            h = d + 5;
            // --------------- Valor de ho-----------------------
            double hz1new = 15;
            double hz2new = h / 3;
            double hz3new = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
            double hz4new = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
            hzero = 5 * (Math.round(Math.max(Math.max(hz1new, hz2new), Math.max(hz3new, hz4new)) / 5));

        }
        // Continuação normal do dimensionamento

        double Ca = (A - ap) / 2; // em centímetros
        double Cb = (B - bp) / 2; // em centímetros

        if ((Ca >= (h / 2) && Ca <= 2 * h)) {

            double cisalhamentoAplicado = (CargaReal) / ((2 * ap + 2 * bp) * d); // Verificar essas fórmula do
            // cisalhamento com Bergson
            double cisalhamentoResistente = 0.27 * (1 - (fck / 250)) * (fck / 1.4); // Verificar essas fórmula do
            // cisalhamento com Bergson

            if (cisalhamentoAplicado <= cisalhamentoResistente) {
                Ssapata = cargaPilar / tensaoSolo;
                SSapataReal = A * B; // Área real após o arrendodamento em cm²
// --------------- Valor de H total---------------------------
                h1 = ((A - ap) / 3);
                h2 = ((B - bp) / 3);
                h = 5 * (Math.ceil(Math.abs(Math.max(h1, h2)) / 5));

// --------------- Valor de ho---------------------------
                hz1 = 15;
                hz2 = h / 3;
                hz3 = h - ((A - ap) / 2) * Math.tan(Math.toRadians(30));
                hz4 = h - ((B - bp) / 2) * Math.tan(Math.toRadians(30));
                hzero = 5 * (Math.round(Math.max(Math.max(hz1, hz2), Math.max(hz3, hz4)) / 5));
                d = h - 5;
                Vsapata = ((hzero * SSapataReal)
                        + ((h - hzero) / 3) * (SSapataReal + (ap * bp) + (Math.sqrt(SSapataReal * ap * bp)))) / 1000000;
                GammaConc = 25;
                Psapata = Vsapata * GammaConc;
                CargaReal = cargaPilar + Psapata;
                TensaoReal = CargaReal / (SSapataReal / 10000);
                // Continuar o dimensionaemnto das áreas de aço.
                double xa = Ca + 0.15 * ap;
                double xb = Cb + 0.15 * bp;
                // Momentos característicos
                double m1ak = TensaoReal * (B / 100) * ((Math.pow((xa / 100), 2)) / 2);
                double m1bk = TensaoReal * (A / 100) * ((Math.pow((xb / 100), 2)) / 2);
                // Cálculo da armadura mínima
                double areaAcoAMinima = (0.15 / 100) * h * xa;
                double areaAcoBMinima = (0.15 / 100) * h * xb;
                // Cálculo da área de aço em A e B:
                double areaAcoA = Math.max(((m1ak * 1.4 * 100) / (0.85 * d * fyk / 11.5)), areaAcoAMinima);
                double areaAcoB = Math.max(((m1bk * 1.4 * 100) / (0.85 * d * fyk / 11.5)), areaAcoBMinima);

                // ----------------Numero de Barras------------------------//
                // --------------LADO A--------------------------//
                double Aaco10 = (Math.PI * Math.pow(1, 2)) / 4; // 10 milímetros
                double Aaco12 = (Math.PI * Math.pow(1.25, 2)) / 4; // 12.5 milímetros
                double Aaco16 = (Math.PI * Math.pow(1.6, 2)) / 4; // 16 milímetros
                double Aaco20 = (Math.PI * Math.pow(2.0, 2)) / 4; // 20 milímetros
                double Aaco25 = (Math.PI * Math.pow(2.5, 2)) / 4; // 25 milímetros
                double Aaco32 = (Math.PI * Math.pow(3.2, 2)) / 4; // 32 milímetros

                double[] numeroBarrasA = new double[6];
                numeroBarrasA[0] = Math.ceil(areaAcoA / Aaco10);
                numeroBarrasA[1] = Math.ceil(areaAcoA / Aaco12);
                numeroBarrasA[2] = Math.ceil(areaAcoA / Aaco16);
                numeroBarrasA[3] = Math.ceil(areaAcoA / Aaco20);
                numeroBarrasA[4] = Math.ceil(areaAcoA / Aaco25);
                numeroBarrasA[5] = Math.ceil(areaAcoA / Aaco32);

                // ------------Lado B------------------//

                double[] numeroBarrasB = new double[6];
                numeroBarrasB[0] = Math.ceil(areaAcoB / Aaco10);
                numeroBarrasB[1] = Math.ceil(areaAcoB / Aaco12);
                numeroBarrasB[2] = Math.ceil(areaAcoB / Aaco16);
                numeroBarrasB[3] = Math.ceil(areaAcoB / Aaco20);
                numeroBarrasB[4] = Math.ceil(areaAcoB / Aaco25);
                numeroBarrasB[5] = Math.ceil(areaAcoB / Aaco32);

                // ----------------Distancia entre barras------------------------//
                double phi08 = 0.8;// cm
                double phi10 = 1.0;// cm
                double phi12 = 1.25;// cm
                double phi16 = 1.6;// cm
                double phi20 = 2.0;// cm
                double phi25 = 2.5;// cm
                double phi32 = 3.2;// cm

                // Espacamento Lado A
                double[] espacamentoBarrasA = new double[6];
                espacamentoBarrasA[0] = (B - 2 * cobrimento - numeroBarrasA[0] * phi10) / (numeroBarrasA[0] - 1);
                espacamentoBarrasA[1] = (B - 2 * cobrimento - numeroBarrasA[1] * phi12) / (numeroBarrasA[1] - 1);
                espacamentoBarrasA[2] = (B - 2 * cobrimento - numeroBarrasA[2] * phi16) / (numeroBarrasA[2] - 1);
                espacamentoBarrasA[3] = (B - 2 * cobrimento - numeroBarrasA[3] * phi20) / (numeroBarrasA[3] - 1);
                espacamentoBarrasA[4] = (B - 2 * cobrimento - numeroBarrasA[4] * phi25) / (numeroBarrasA[4] - 1);
                espacamentoBarrasA[5] = (B - 2 * cobrimento - numeroBarrasA[5] * phi32) / (numeroBarrasA[5] - 1);

                // Espacamento Lado B
                double[] espacamentoBarrasB = new double[6];
                espacamentoBarrasB[0] = (A - 2 * cobrimento - numeroBarrasB[0] * phi10) / (numeroBarrasB[0] - 1);
                espacamentoBarrasB[1] = (A - 2 * cobrimento - numeroBarrasB[1] * phi12) / (numeroBarrasB[1] - 1);
                espacamentoBarrasB[2] = (A - 2 * cobrimento - numeroBarrasB[2] * phi16) / (numeroBarrasB[2] - 1);
                espacamentoBarrasB[3] = (A - 2 * cobrimento - numeroBarrasB[3] * phi20) / (numeroBarrasB[3] - 1);
                espacamentoBarrasB[4] = (A - 2 * cobrimento - numeroBarrasB[4] * phi25) / (numeroBarrasB[4] - 1);
                espacamentoBarrasB[5] = (A - 2 * cobrimento - numeroBarrasB[5] * phi32) / (numeroBarrasB[5] - 1);
                // Área de forma da sapata (Somente do espelho)
                double areaDeForma = ((hzero * A) * 2 + (hzero * B) * 2) / 10000; // em metros quadrados


                return new Result(cobrimento, ap, bp, fyk,
                        cargaPilar, fck, tensaoSolo, aco_pilar, A, B, h,
                        d, Ca, Cb, hzero, Vsapata, Psapata, m1ak, m1bk, areaAcoA, areaAcoB,
                        xa, xb, num_iteracoes, numeroBarrasA, numeroBarrasB, espacamentoBarrasA, espacamentoBarrasB);

            } else {
                Toast.makeText(this.getApplicationContext(), getResources().getString(R.string.nao_passou_cisalhamento), Toast.LENGTH_SHORT).show();
                return null;
            }
        } else {
            Toast.makeText(this.getApplicationContext(), getResources().getString(R.string.nao_passou_ceb), Toast.LENGTH_SHORT).show();
            return null;
        }


    }


}
