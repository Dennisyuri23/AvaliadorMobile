package com.example.aula15;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView txt = (TextView) findViewById(R.id.txtVotoFinal);

        // Pega o texto que enviamos da primeira tela
        String resultado = getIntent().getStringExtra("p_voto");
        txt.setText("Sua nota: " + resultado);
    }
}