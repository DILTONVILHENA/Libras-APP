package com.example.libraskids.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.libraskids.R;

import java.util.Objects;


public class MenuCategoryActivity extends AppCompatActivity {

    private String basePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_crianca);

        // removendo side bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();
        basePath = bundle.getString("path");

        //botões definidos no menu de categoria
        ImageButton bt1 = findViewById(R.id.bt_um);
        ImageButton bt2 = findViewById(R.id.bt_dois);
        ImageButton bt3 = findViewById(R.id.bt_tres);
        ImageButton bt4 = findViewById(R.id.bt_quatro);
        ImageButton bt5 = findViewById(R.id.bt_cinco);


        TextView txt1 = findViewById(R.id.textView1);
        TextView txt2 = findViewById(R.id.textView2);
        TextView txt3 = findViewById(R.id.textView3);
        TextView txt4 = findViewById(R.id.textView4);
        TextView txt5 = findViewById(R.id.textView5);

        //ações em cada click dos botões
        if (basePath.equals("crianca")) {

            txt1.setText("Alfabeto");
            txt2.setText("Números");
            txt3.setText("Animais");
            txt4.setText("Cores");
            txt5.setText("Transportes");

            bt1.setImageResource(R.drawable.abc2);
            bt2.setImageResource(R.drawable.num123);
            bt3.setImageResource(R.drawable.animais2);
            bt4.setImageResource(R.drawable.cores2);
            bt5.setImageResource(R.drawable.transportes);

            bt1.setOnClickListener(v -> {
                callActivity("alfabeto");
            });

            bt2.setOnClickListener(v -> {
                callActivity("numeros");
            });


            bt3.setOnClickListener(v -> {
                callActivity("animais");
            });

            bt4.setOnClickListener(v -> {
                callActivity("cores");
            });

            bt5.setOnClickListener(v -> {
                callActivity("transportes");
            });
        } else {

            txt1.setText("Alimentos");
            txt2.setText("Escola");
            txt3.setText("Saudações");
            txt4.setText("Objetos");
            txt5.setText("Pará");

            bt1.setImageResource(R.drawable.alimentos2);
            bt2.setImageResource(R.drawable.escola2);
            bt3.setImageResource(R.drawable.saudacoes2);
            bt4.setImageResource(R.drawable.objetos2);
            bt5.setImageResource(R.drawable.para);


            bt1.setOnClickListener(v -> {
                callActivity("alimentos");
            });

            bt2.setOnClickListener(v -> {
                callActivity("escola");
            });

            bt3.setOnClickListener(v -> {
                callActivity("saudacoes");
            });

            bt4.setOnClickListener(v -> {
                callActivity("objetos");
            });

            bt5.setOnClickListener(v -> {
                callActivity("para");
            });
        }
    }


    //método de chamada da categoria, referenciando direto do banco de dados
    private void callActivity(String path){

        Intent intent = new Intent(this, DetailsCategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("basePath", basePath);
        bundle.putString("path", path);
        intent.putExtras(bundle);

        //iniciando a activity mencionada acima
        startActivity(intent);

    }
}
