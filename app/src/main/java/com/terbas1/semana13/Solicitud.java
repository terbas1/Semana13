package com.terbas1.semana13;

import java.util.Date;

public class Solicitud {
    private Long id;
    private String correo;
    private String tipoSolicitud;
    private String motivo;

    private String gps;

    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", tipoSolicitud='" + tipoSolicitud + '\'' +
                ", motivo='" + motivo + '\'' +
                ", gps='" + gps + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }



    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }
}
