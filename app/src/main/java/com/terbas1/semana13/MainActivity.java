package com.terbas1.semana13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.notesList = (RecyclerView)findViewById(R.id.notes_list);
        this.notesList.setLayoutManager(new LinearLayoutManager(this));
        this.notesList.setAdapter(new SolicitudAdapter());
        refreshData();
    }
    public void refreshData(){
        SolicitudAdapter adapter = (SolicitudAdapter) notesList.getAdapter();
        List<Solicitud> solicitudes = SolicitudReposity.getNotes();
        adapter.setSolicitudes(solicitudes);
        adapter.notifyDataSetChanged(); // Refrezca los cambios en el RV
    }
    public void showRegister(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REGISTER_FORM_REQUEST:
                if (resultCode == RESULT_OK) {
                    refreshData();
                }
                break;
            default:
        }

    }

}
