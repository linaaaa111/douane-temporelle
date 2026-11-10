package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    // Method bch na3mlou biha les clés b el matricule 9886
    public static String getCle(String matricule, String suffixe) {
        return matricule + "_" + suffixe;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Esta3mna el matricule 9886
        String matricule = "9886";
        String cleNom = getCle(matricule, "NOM_VOYAGEUR");
        String cleVerdict = getCle(matricule, "VERDICT_SAUT");

        // Nkobtrou les données eli jew mel Intent (el éran eli 9balha)
        String nomVoyageur = getIntent().getStringExtra(cleNom);
        boolean estApprouve = getIntent().getBooleanExtra(cleVerdict, false);

        // Nrboto les éléments ta3 el interface mte3na (m3a el initiales f el layout)
        LinearLayout layoutRoot = findViewById(R.id.layout_root_ya);
        TextView tvMessage = findViewById(R.id.tv_message_ya);
        Button btnNouveauVoyageur = findViewById(R.id.btn_nouveau_voyageur_ya);

        // nbadlo couleur el background w el message selon el verdict (akhdhar ken mawafe9, ahmar ken mrffodh)
        if (estApprouve) {
            layoutRoot.setBackgroundColor(Color.parseColor("#4CAF50")); // Akhdhar (Approuvé)
            tvMessage.setText("Bon voyage " + nomVoyageur);
        } else {
            layoutRoot.setBackgroundColor(Color.parseColor("#F44336")); // Ahmar (Refusé / Risque de paradoxe)
            tvMessage.setText(nomVoyageur + " est en état d'arrestation temporelle");
        }

        // El bouton bch narjaa lel début w nsakro les activités eli f west el pile
        btnNouveauVoyageur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}