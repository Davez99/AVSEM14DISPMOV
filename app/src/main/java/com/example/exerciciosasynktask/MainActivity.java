package com.example.exerciciosasynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText matricula;
    private ProgressBar progressBar;
    private EstudanteDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.idNome);
        email = findViewById(R.id.idEmail);
        matricula = findViewById(R.id.idMatricula);
        progressBar = findViewById(R.id.progressBar);
        dao = new EstudanteDAO(this);

        // ExecuÃ§Ã£o da AsyncTask
        MyTask myTask = new MyTask();

        // NÃ£o Ã© necessÃ¡rio passar parÃ¢metros nesta chamada, esta executÃ§Ã£o deve ser chamada por exemplo, quando clicar no botÃ£o "inserir"
        myTask.execute();

    }

    public void startAsyncTask(View v){

        Estudante e = new Estudante();
        e.setNome(nome.getText().toString());
        e.setEmail(email.getText().toString());
        e.setMatricula(matricula.getText().toString());

        long id = dao.inserir(e);
        Toast.makeText(this, "Estudante Inserido! ID: " + id, Toast.LENGTH_SHORT).show();

    }

    public class MyTask extends AsyncTask<String, Void, String>
    {

        @Override
        public void onPreExecute()
        {
            /*
                Este Ã© o primeiro mÃ©todo q aser executado desta classe. Ã‰ uma chamda de mÃ©todo prÃ©via, necessÃ¡ria geralmente para mostrar a tela a dialog de loading.
            */
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public String doInBackground(String... parametros)
        {
            /*
                Qualquer cÃ³digo que for executado aqui dentro serÃ¡ executado dentro de uma Thread, ou seja, serÃ¡ executada em Background.
                Neste mÃ©todo Ã© que devemos fazer a chamada para o banco de dados, seja ela para inserir algum dado ou receber dados do banco.
                O tipo de cÃ³digo que retornarmos aqui cariÃ¡ no mÃ©todo do onPostExecute.

            */

            // EXEMPLO ABAIXO

            /*
            Estudante estudante = new Estudante("Alan Turing", "alanturing@pucpr.br", 123);
            EstudanteDAO estudanteDAO = new EstudanteDAO(MainActivity.this);
            estudanteDAO.inserir(estudante);
            return "Inserido com sucesso!";
            */

            return "Concluído";
        }

        @Override
        public void onPostExecute(String retorno)
        {
            /*
                Quando hÃ¡ o retorno da chamada do doInBackground, o tipo de dado retornado cairÃ¡ como parÃ¢metro deste mÃ©todo. Neste ponto a Thread jÃ¡ nÃ£o estÃ¡ em execuÃ§Ã£o.
            */

            // EXEMPLO ABAIXO

            //Toast.makeText(MainActivity.this, retorno, Toast.LENGTH_LONG).show();


        }
    }
}