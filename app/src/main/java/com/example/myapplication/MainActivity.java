
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNomwb, etNaissancewb, etDestinationwb;
    private Spinner spMotifwb;
    private Button btnInspecterwb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des composants
        etNomwb = findViewById(R.id.et_nom_wb);
        etNaissancewb = findViewById(R.id.et_naissance_wb);
        etDestinationwb = findViewById(R.id.et_destination_wb);
        spMotifwb = findViewById(R.id.sp_motif_wb);
        btnInspecterwb = findViewById(R.id.btn_inspecter_wb);

        btnInspecterwb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // el saisie des données
                String nom = etNomwb.getText().toString().trim();
                String naissance = etNaissancewb.getText().toString().trim();
                String destination = etDestinationwb.getText().toString().trim();
                String motif = spMotifwb.getSelectedItem().toString();

                // nverifiw les champs meebin
                if (nom.isEmpty() || naissance.isEmpty() || destination.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                int anneeNaissance;
                int anneeDestination;

                try {
                    anneeNaissance = Integer.parseInt(naissance);
                    anneeDestination = Integer.parseInt(destination);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,
                            "Veuillez saisir des années valides",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this,
                        VerificationActivity.class);

                // nebafo les infos
                intent.putExtra(KeyUtils.keyNom(), nom);
                intent.putExtra(KeyUtils.keyNaissance(), anneeNaissance);
                intent.putExtra(KeyUtils.keyDestination(), anneeDestination);
                intent.putExtra(KeyUtils.keyMotif(), motif);

                startActivity(intent);
            }
        });
    }
}
