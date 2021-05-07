package com.olva.eser.util;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.olva.eser.entity.Persona;

public class MetodosGeneral {
	

    public MetodosGeneral() {

    }
    
    public static String nombrePersNatOrJur(Persona pPersona) {
        String _razonSocial = pPersona.getRazonSocial() != null ? pPersona.getRazonSocial().toUpperCase().trim() : "";
        String _nombres = pPersona.getNombres() != null ? pPersona.getNombres().toUpperCase().trim() : "";
        String _apePat = pPersona.getApellidoPaterno() != null ? pPersona.getApellidoPaterno().toUpperCase().trim() : "";
        String _apeMat = pPersona.getApellidoMaterno() != null ? pPersona.getApellidoMaterno().toUpperCase().trim() : "";
        String _concat = "".equals(_razonSocial) ? (_apePat + " " + _apeMat + " " + _nombres) : _razonSocial;
        return _concat.trim();
    }
    
    public static Date convertDateToDateFormatted(Date date, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        String sDate = formatter.format(date);
        return convertDateStringToDate(sDate);
    }
    
    public static Date convertDateStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException ex) {
        }
        return date;
    }

    public static String convertDateNowToStringFormatted(String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(Calendar.getInstance().getTime());
    }
    
    public static String formatString(int pTypeFormat, String pString) {
        String[] arrString;
        String string = pString.trim();
        int i;

        switch (pTypeFormat) {
            case 1: { 
                if (!pString.equals("")) {
                    string = string.toLowerCase();
                    arrString = string.split(" ");
                    string = arrString[0].trim();
                    if (!arrString[0].equals("") || !arrString[0].isEmpty()) {
                        string = string.substring(0, 1).toUpperCase() + string.substring(1, string.length());
                    }
                    for (i = 1; i < arrString.length; i++) {
                        String temp = arrString[i].trim();
                        if (!temp.equals("") || !temp.isEmpty()) {
                            string = string + " " + (temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()));
                        }
                    }
                }
                break;
            }

        }
        return string;
    }
    
     public static String quitarTildes(String strToStrip) {
        String strStripped = null;
        if (strToStrip != null) {
            //Normalizamos en la forma NFD (Canonical decomposition)
            strToStrip = Normalizer.normalize(strToStrip, Normalizer.Form.NFD);
            //Reemplazamos los acentos con una una expresión regular de Bloque Unicode
            strStripped = strToStrip.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        }
        return strStripped;
    }

}
