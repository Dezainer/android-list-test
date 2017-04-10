package eu.study.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 10/04/17.
 */

public class StudyHelper extends SQLiteOpenHelper{

    public StudyHelper(Context context) {
        super(context, "study", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE list( ");
        sb.append(" _id INTEGER PRIMARY KEY, ");
        sb.append(" nome TEXT )");

        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
