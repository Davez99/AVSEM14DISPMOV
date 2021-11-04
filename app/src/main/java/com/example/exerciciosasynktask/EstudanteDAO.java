package com.example.exerciciosasynktask;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EstudanteDAO {

    private com.example.exerciciosasynktask.Conexao con;
    private SQLiteDatabase db;

    public EstudanteDAO(Context context){
        con = new com.example.exerciciosasynktask.Conexao(context);
        db = con.getWritableDatabase();
    }

    public long inserir(com.example.exerciciosasynktask.Estudante estudante){

        ContentValues values = new ContentValues();
        values.put("nome", estudante.getNome());
        values.put("email", estudante.getEmail());
        values.put("matricula", estudante.getMatricula());
        return db.insert("estudantes", null, values);
    }
}