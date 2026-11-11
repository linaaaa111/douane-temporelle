
package com.example.myapplication;

public class KeyUtils {

    // matricule ekhr 4 nums taa num de la carte etudiant
    public static final String MATRICULE = "9886";

    // namlo fel les clées à partir de la matricule
    public static String buildKey(String matricule, String nomCle) {
        return matricule + "_" + nomCle;
    }

    // Clés predefinies
    public static String keyNom() {
        return buildKey(MATRICULE, "NOM_VOYAGEUR");
    }

    public static String keyNaissance() {
        return buildKey(MATRICULE, "ANNEE_NAISSANCE");
    }

    public static String keyDestination() {
        return buildKey(MATRICULE, "ANNEE_DESTINATION");
    }

    public static String keyMotif() {
        return buildKey(MATRICULE, "MOTIF");
    }

    public static String keyVerdict() {
        return buildKey(MATRICULE, "VERDICT");
    }

    // netjanbo fel akhtaa fel motif de voyage
    public static final String MOTIF_MODIFICATION_PASSE =
            "Modification du passé";
}
