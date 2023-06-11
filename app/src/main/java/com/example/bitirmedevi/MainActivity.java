package com.example.bitirmedevi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewOyuncu,imageViewBilgisayar;

    TextView textViewOyuncu,textViewBilgisayar;

    Button btntas,btnkagit,btnmakas;

    int[] resimler={R.drawable.tas,R.drawable.pa,R.drawable.makas};

    int oyuncuPuan,bilgisayarPuan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewOyuncu=findViewById(R.id.iv_oyuncu);
        imageViewBilgisayar=findViewById(R.id.iv_bilgisayar);
        textViewBilgisayar=findViewById(R.id.tv_bilgisayar_puan);
        textViewOyuncu=findViewById(R.id.tv_oyuncu_puan);
        btntas=findViewById(R.id.btn_tas);
        btnkagit=findViewById(R.id.btn_kagit);
        btnmakas=findViewById(R.id.btn_makas);

        oyuncuPuan=0;
        bilgisayarPuan=0;

        btntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oyna(0);

            }
        });
        btnkagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oyna(1);

            }
        });
        btnmakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oyna(2);

            }
        });


    }

    private void oyna(int oyuncuSecim) {

        int bilgisayarSecim =(int)(Math.random()*3);

        imageViewOyuncu.setImageResource(resimler[oyuncuSecim]);
        imageViewBilgisayar.setImageResource(resimler[bilgisayarSecim]);

        if(oyuncuSecim==bilgisayarSecim){
            Toast.makeText(this, "Berabere.", Toast.LENGTH_SHORT).show();
        }else if(oyuncuSecim==0 && bilgisayarSecim==2 ||
                oyuncuSecim==1 && bilgisayarSecim==0  ||
                oyuncuSecim==2 && bilgisayarSecim==1 ){
            oyuncuPuan++;
            Toast.makeText(this, "Kazandınız.", Toast.LENGTH_SHORT).show();
        }
        else{
            bilgisayarPuan++;
            Toast.makeText(this, "Kaybettiniz.", Toast.LENGTH_SHORT).show();
        }

        textViewOyuncu.setText("Oyuncu:  "+oyuncuPuan);
        textViewBilgisayar.setText("Bilgisayar:  "+bilgisayarPuan);

    }
}