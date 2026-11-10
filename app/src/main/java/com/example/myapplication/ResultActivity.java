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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        LinearLayout layoutwb = findViewById(R.id.layout_root_wb);
        TextView tvMessagewb = findViewById(R.id.tv_message_wb);
        Button btnNouveauwb = findViewById(R.id.btn_nouveau_voyageur_wb);

        boolean approuve = getIntent().getBooleanExtra(KeyUtils.keyVerdict(), false);
        String nom = getIntent().getStringExtra(KeyUtils.keyNom());

        if (approuve) {
            layoutwb.setBackgroundColor(getColor(R.color.color_accepted));
            tvMessagewb.setText("Bon voyage " + nom);
        } else {
            layoutwb.setBackgroundColor(getColor(R.color.color_refused));
            tvMessagewb.setText(nom + " est en état d'arrestation temporelle");
        }

        btnNouveauwb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}