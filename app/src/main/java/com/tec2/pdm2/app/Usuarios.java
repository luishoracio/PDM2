package com.tec2.pdm2.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luishoracio on 29/04/14.
 */
public class Usuarios{

    private ArrayList<HashMap<String,String>> usuarios;
    private ArrayList<HashMap<String,String>> nombres;
    private JSONArray datosAUsar;

    Usuarios(){}

    Usuarios(JSONArray datos){
        datosAUsar = datos;
        usuarios = new ArrayList<HashMap<String, String>>();
        setValores();
    }

    private void setValores (){
        try {
            for (int i = 0; i < datosAUsar.length(); i++) {
                JSONObject valor = datosAUsar.getJSONObject(i);

                HashMap<String, String> hashValor =
                        new HashMap<String, String>();

                hashValor.put("id", valor.getString("id"));
                hashValor.put("nombre", valor.getString("nombre"));

                usuarios.add(hashValor);

            }
        }catch (JSONException e){}
    }

    private void setTelefonos(){
        try {
            for (int i = 0; i < datosAUsar.length(); i++) {
                JSONObject valor = datosAUsar.getJSONObject(i);

                HashMap<String, String> hashValor =
                        new HashMap<String, String>();

                hashValor.put("id", valor.getString("id"));
                hashValor.put("telefonos", valor.getString("telefonos"));

                usuarios.add(hashValor);

            }
        }catch (JSONException e){}
    }

    public ArrayList<HashMap<String,String>> getUsuarios(){
        return usuarios;
    }

}
