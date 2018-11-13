package com.terbas1.semana13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {

    private static final String TAG = detailActivity.class.getSimpleName();

    private Long id;

    private TextView tipoSolicitud;
    private TextView motivo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tipoSolicitud = findViewById(R.id.title_text);
        motivo = findViewById(R.id.content_text);

        id = getIntent().getExtras().getLong("ID");
        Log.e(TAG, "ID: " + id);

        // Get Note by ID from Repository
        Solicitud solicitud = SolicitudReposity.get(id);

        tipoSolicitud.setText(solicitud.getTipoSolicitud());
        motivo.setText(solicitud.getMotivo());
        }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}