package com.example.aula15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends Activity {

    RatingBar rtb;
    TextView txt;
    Button btn;
    String classificacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rtb = (RatingBar) findViewById(R.id.rtbvotacao);
        txt = (TextView) findViewById(R.id.txtstatus);
        btn = (Button) findViewById(R.id.btnOk);

        rtb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                classificacao = obterDescricao((int) rating);
                txt.setText("Status: " + classificacao);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ResultadoActivity.class);
                it.putExtra("p_voto", classificacao);
                startActivity(it);
            }
        });
    }

    private String obterDescricao(int nota) {
        if (nota == 1) return "Regular";
        if (nota == 2) return "Bom";
        if (nota == 3) return "Ótimo";
        if (nota == 4) return "Excelente";
        if (nota == 5) return "Espetacular";
        return "Sem nota";
    }
}