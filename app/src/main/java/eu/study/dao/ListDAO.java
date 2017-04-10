package eu.study.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import eu.study.helper.StudyHelper;
import eu.study.vo.ListVO;

/**
 * Created by root on 10/04/17.
 */

public class ListDAO {

    private StudyHelper helper;

    public ListDAO(Context context){
        this.helper = new StudyHelper(context);
    }

    public Cursor listar(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor crs = db.rawQuery("SELECT * FROM list", null);

        return crs;
    }

    public void salvar(ListVO list){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", list.getNome());

        db.insert("list", null, cv);
        db.close();
    }
}
