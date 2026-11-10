package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
git fetch origin

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        LinearLayout layoutNj = findViewById(R.id.layout_result_nj);
        TextView tvMessageNj = findViewById(R.id.tv_message_nj);
        Button btnNouveauNj = findViewById(R.id.btn_nouveau_nj);

        boolean approuve = getIntent().getBooleanExtra(KeyUtils.keyVerdict(), false);
        String nom = getIntent().getStringExtra(KeyUtils.keyNom());

        if (approuve) {
            layoutNj.setBackgroundColor(Color.parseColor("#2E7D32"));
            tvMessageNj.setText("Bon voyage " + nom);
        } else {
            layoutNj.setBackgroundColor(Color.parseColor("#C62828"));
            tvMessageNj.setText(nom + " est en état d'arrestation temporelle");
        }

        btnNouveauNj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}