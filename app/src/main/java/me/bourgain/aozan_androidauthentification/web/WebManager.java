package me.bourgain.aozan_androidauthentification.web;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import me.bourgain.aozan_androidauthentification.Utilisateur;

/**
 * Created by Matthieu on 10/12/2016.
 */

public class WebManager {
    private Context context;

    // Constructeur
    public WebManager(Context context){
        this.context = context;
    }

    // Authentification, appelé depuis le service
    public Utilisateur Authentification(String login, String password){
        ConnexionHTTP connexion = new ConnexionHTTP();
        connexion.execute(login, "Authentification", password);
        try {
            if (connexion.get()) {
                /* Connexion réussie */
                // Récupération des listes
                JSONObject jObject = new JSONObject(connexion.getReponse());
                JSONArray jArray = jObject.getJSONArray("reponse");
                for (int i=0; i < jArray.length(); i++)
                {
                    JSONObject oneObject = jArray.getJSONObject(i);
                    // Récup des éléments l'objet
                    Long id = oneObject.getLong("id");
                    String nom = oneObject.getString("nom");

                    Utilisateur user = new Utilisateur();
                    user.setId(id);
                    user.setLogin(login);
                    user.setNom(nom);

                    return user;
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur " + e);
            e.printStackTrace();
        }
        return null;
    }
}
