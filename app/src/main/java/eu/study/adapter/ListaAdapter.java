package eu.study.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import eu.study.R;

public class ListaAdapter extends CursorAdapter{

    private LayoutInflater inflater;

    public ListaAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View item = inflater.inflate(R.layout.item_list, null);
        return item;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView lblName = (TextView) view.findViewById(R.id.lblName);

        String name = cursor.getString(cursor.getColumnIndex("nome"));
        lblName.setText(name);
    }


}
