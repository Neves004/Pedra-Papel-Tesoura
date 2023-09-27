package com.aulaandroid.pedrapapeletesoura;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    /**
     * Atribuição dos elementos do Design da MainActivity
     */
    TextView textResultado;
    ImageView imageApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Inicialização da MainActivity

        imageApp = findViewById(R.id.imageApp); //Encontrando a variável imageApp pelo ID
        textResultado = findViewById(R.id.textResultado); //Encontrando a variável textResultado pelo ID
    }

    /**
     * Quando uma opção for selecionada (pedra, papel ou tesoura) será armazenada
     * @param view
     */
    public void selecionadoPedra(View view) {

        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {

        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    /**
     * Com o uso do RANDOM, uma das três opcões será selecioanda aleatoriamente
     * Aparecendo a imagem na variável 'imageApp'
     * @param opcaoSelecionada
     */
    public void opcaoSelecionada(String opcaoSelecionada) {
        int n = new Random().nextInt(3);
        String[] selecao = {"pedra", "papel", "tesoura"};
        String selecaoApp = selecao[n];
        switch (selecao[n]) {
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra__1_);
                break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel__1_);
                break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura__1_);
                break;

            /**
             * Agora com base na opção selecionada no RANDOM e com a opção selecionada pelo usuário
             * Criamos uma regra de negócio para verificação se o App ganhou, se o usuário ganhou ou se houve Empate
             */
        }


        if(
                (selecao[n]=="pedra" && opcaoSelecionada == "tesoura") ||
                        (selecao[n]=="papel" && opcaoSelecionada == "pedra") ||
                        (selecao[n]=="tesoura" && opcaoSelecionada == "papel")) {
            textResultado.setText("O App ganhou");
        }else if(
                (selecao[n]=="pedra" && opcaoSelecionada == "papel") ||
                        (selecao[n]=="tesoura" && opcaoSelecionada == "pedra") ||
                        (selecao[n]=="papel" && opcaoSelecionada == "tesoura")) {
            textResultado.setText("Você ganhou");
        }else{
            textResultado.setText("Empate");
        }

    }
}
