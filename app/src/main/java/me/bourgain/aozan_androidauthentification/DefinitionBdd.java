package me.bourgain.aozan_androidauthentification;

import android.provider.BaseColumns;

/**
 * Created by Matthieu on 04/12/2016.
 */

public class DefinitionBdd {
    private DefinitionBdd() {}

    public static abstract class Utilisateur implements BaseColumns {
        public static final String NOM_TABLE = "utilisateur";
        public static final String ID = "id";
        public static final String LOGIN = "login";
        public static final String NOM = "nom";
    }
}
