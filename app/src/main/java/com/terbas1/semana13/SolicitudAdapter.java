package com.terbas1.semana13;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.List;

public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder> {
    private static final String TAG = SolicitudAdapter.class.getSimpleName();

    private List<Solicitud> solicitudes;
    public SolicitudAdapter(){
        this.solicitudes = new ArrayList<>();
    }
    public void setSolicitudes(List<Solicitud> notes) {
        this.solicitudes = solicitudes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView solicitud;
        private TextView email;
        private TextView gps;

        public ViewHolder(View itemView) {
            super(itemView);
            solicitud=itemView.findViewById(R.id.solicitud_text);
            email=itemView.findViewById(R.id.content_text);
            gps=itemView.findViewById(R.id.gps_text);
        }
    }


    @Override
    public SolicitudAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.pedido_note,parent,false);
        ViewHolder viewHolder= new ViewHolder(itemView);
        return null;
    }

    @Override
    public void onBindViewHolder( ViewHolder ViewHolder, final int position) {
        final Solicitud solicitud=this.solicitudes.get(position);

        int color = ColorGenerator.MATERIAL.getColor(solicitud.getTipoSolicitud());
        TextDrawable drawable = TextDrawable.builder().buildRect(solicitud.getTipoSolicitud().substring(0, 1), color);
        ViewHolder.solicitud.setText(solicitud.getTipoSolicitud());
        ViewHolder.email.setText(solicitud.getCorreo());
        ViewHolder.gps.setText(solicitud.getGps());

        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), detailActivity.class);
                intent.putExtra("ID", solicitud.getId());
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() { return this.solicitudes.size();}
}
