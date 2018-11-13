package com.terbas1.semana13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText correoElectro;
    private EditText motivo;
    private Spinner spinner;
    String[] tipos = {"Solicitud de Certificado","Solicitud de Salud","Solcitud de Tercio superior","Solicitud de exoneración","Solicitud de retraso mental"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spinner =findViewById(R.id.tipo_input1);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipos));

        correoElectro=findViewById(R.id.correo_input);
        motivo=findViewById(R.id.motivo1_input);

    }
    public void callRegister(){
        int indice=spinner.getSelectedItemPosition();
        String tipo2 = " " ;
        String email=correoElectro.getText().toString();
        String moti=motivo.getText().toString();
        if (indice==0){
            tipo2="Solicitud de Certificado";
        }else if(indice==1){
            tipo2="Solicitud de Salud";

        }else if(indice==3){
            tipo2="Solicitud de Tercio superior";

        }else if(indice==4){
            tipo2="Solicitud de exoneración";

        }else if(indice==5){
            tipo2="Solicitud de retraso mental";

        }

        if(email.isEmpty() || moti.isEmpty() ){
            Toast.makeText(this, "Debe completar todo los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Solicitud solicitud= new Solicitud();

        solicitud.setCorreo(email);
        solicitud.setMotivo(moti);
        solicitud.setTipoSolicitud(tipo2);

        SolicitudReposity.add(solicitud);

        Toast.makeText(this, "Registrado Correctamente", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();

    }


}
