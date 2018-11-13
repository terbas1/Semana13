package com.terbas1.semana13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolicitudReposity {
    private static final String TAG = SolicitudReposity.class.getSimpleName();
    private static List<Solicitud> solicitudes = new ArrayList<>();

    public static List<Solicitud> getNotes() {
        return solicitudes;
    }
    private static long sequence = 1;
    public static Solicitud add(Solicitud solicitud){
        solicitud.setId(sequence++);
        solicitudes.add(0, solicitud);
        return solicitud;
    }
    public static Solicitud get(Long id){
        for (Solicitud solicitud : solicitudes) {
            if(solicitud.getId().equals(id))
                return solicitud;
        }
        return null;
    }
    public static Solicitud remove(Long id){
        for(Iterator<Solicitud> i = solicitudes.iterator(); i.hasNext();) {
            Solicitud solicitud = i.next();
            if(solicitud.getId().equals(id)) {
                i.remove();
                return solicitud;
            }
        }
        return null;
    }

}
