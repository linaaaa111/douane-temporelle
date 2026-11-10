package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ResultActivity extends AppCompatActivity {

    // Fonction bch na3mlou biha les clés b el matricule 9886
    public static String getCle(String matricule, String suffixe) {
        return matricule + "_" + suffixe;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // El matricule mte3na
        String matricule = "9886";
        String cleNom = getCle(matricule, "NOM_VOYAGEUR");
        String cleVerdict = getCle(matricule, "VERDICT_SAUT");

        // Nrecupériw les données eli jew mel Intent mel activité elli kbalha
        String nomVoyageur = getIntent().getStringExtra(cleNom);
        boolean estApprouve = getIntent().getBooleanExtra(cleVerdict, false);

        // Nrboto les éléments ta3 el interface (b les initiales _ya)
        LinearLayout layoutRoot = findViewById(R.id.layout_root_ya);
        TextView tvMessage = findViewById(R.id.tv_message_ya);
        Button btnNouveauVoyageur = findViewById(R.id.btn_nouveau_voyageur_ya);

        // Nbadlo couleur el background w el message selon el verdict (accepted wela refused)
        if (estApprouve) {
            layoutRoot.setBackgroundColor(ContextCompat.getColor(this, R.color.color_accepted));
            tvMessage.setText("Bon voyage " + nomVoyageur);
        } else {
            layoutRoot.setBackgroundColor(ContextCompat.getColor(this, R.color.color_refused));
            tvMessage.setText(nomVoyageur + " est en état d'arrestation temporelle");
        }

        // Nhotou couleur el texte el mouwada7a (vintage)
        tvMessage.setTextColor(ContextCompat.getColor(this, R.color.color_text));

        // El bouton bch narjaa lel début (MainActivity) w nsakro el pile mte3 el activités lkol
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