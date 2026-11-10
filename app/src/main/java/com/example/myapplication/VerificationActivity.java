package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    // Les éléments mta3 l'interface (les ID fihom les lettres wb)
    private TextView tvNomWb, tvAgeWb, tvMotifWb, tvTrajetWb;
    private Button btnApprouverWb, btnRefuserWb;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  Houni norbtou l'activité b l'interface mta3 vérification
        setContentView(R.layout.activity_verification);

        // norbtou kol élément b l'ID mte3ou fel fichier XML
        tvNomWb = findViewById(R.id.tv_nom_wb);
        tvAgeWb = findViewById(R.id.tv_age_wb);
        tvMotifWb = findViewById(R.id.tv_motif_wb);
        tvTrajetWb = findViewById(R.id.tv_trajet_wb);
        btnApprouverWb = findViewById(R.id.btn_approuver_wb);
        btnRefuserWb = findViewById(R.id.btn_refuser_wb);

        // yrecuperi les données mel écran eli 9bal, w nesta3mlou les clés mta3 KeyUtils
        Intent recu = getIntent();
        nom = recu.getStringExtra(KeyUtils.keyNom());
        int naissance = lireAnnee(recu, KeyUtils.keyNaissance());
        int destination = lireAnnee(recu, KeyUtils.keyDestination());
        String motif = recu.getStringExtra(KeyUtils.keyMotif());

        // nehsbou l'âge temporel : année de destination - année de naissance
        int ageTemporel = destination - naissance;

        // Naffichiw résumé mta3 el voyageur kif passeport
        tvNomWb.setText("Nom : " + nom);
        tvAgeWb.setText("Âge temporel : " + ageTemporel + " ans");
        tvMotifWb.setText("Motif : " + motif);
        tvTrajetWb.setText("Trajet : " + naissance + " → " + destination);

        // Ken el motif houwa modification du passé w el âge nombre premier, nwakfou bouton approbation
        if (KeyUtils.MOTIF_MODIFICATION_PASSE.equals(motif) && estPremier(ageTemporel)) {
            btnApprouverWb.setEnabled(false);
        }

        //  Ki nenzelou 3al bouton approuver, nemchiw lel activité 3 w nab3thou verdict true
        btnApprouverWb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirVerdict(true);
            }
        });

        //  Ki nenzelou 3al bouton refuser, nemchiw lel activité 3 w nab3thou verdict false
        btnRefuserWb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirVerdict(false);
            }
        });
    }

    //  Nab3thou el décision finale (true wala false) w esm el voyageur lel ResultActivity
    private void ouvrirVerdict(boolean approuve) {
        Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
        intent.putExtra(KeyUtils.keyVerdict(), approuve);
        intent.putExtra(KeyUtils.keyNom(), nom);
        startActivity(intent);
    }

    //  Na9raw el année, ken mab3outha int wala String, bech netjanbou les erreurs bin les activités
    private int lireAnnee(Intent intent, String cle) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.get(cle) == null) {
            return 0;
        }
        try {
            return Integer.parseInt(String.valueOf(extras.get(cle)).trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    //  nthabtou ken el nombre premier (ay nombre asghar men 2 moch nombre premier)
    private boolean estPremier(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}