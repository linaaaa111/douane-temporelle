
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

    private EditText etNomNj, etNaissanceNj, etDestinationNj;
    private Spinner spMotifNj;
    private Button btnInspecterNj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des composants
        etNomNj = findViewById(R.id.et_nom_nj);
        etNaissanceNj = findViewById(R.id.et_naissance_nj);
        etDestinationNj = findViewById(R.id.et_destination_nj);
        spMotifNj = findViewById(R.id.sp_motif_nj);
        btnInspecterNj = findViewById(R.id.btn_inspecter_nj);

        btnInspecterNj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // el saisie des données
                String nom = etNomNj.getText().toString().trim();
                String naissance = etNaissanceNj.getText().toString().trim();
                String destination = etDestinationNj.getText().toString().trim();
                String motif = spMotifNj.getSelectedItem().toString();

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
