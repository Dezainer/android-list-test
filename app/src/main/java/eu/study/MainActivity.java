package eu.study;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import eu.study.adapter.ListaAdapter;
import eu.study.dao.ListDAO;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    private ListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.list = (ListView) findViewById(R.id.list);

        ListDAO dao = new ListDAO(this);
        Cursor crsList = dao.listar();

        this.adapter = new ListaAdapter(this, crsList);
        this.list.setAdapter(this.adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.list_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.lblNovo) {
            Intent i = new Intent(this, NewItemActivity.class);
            startActivityForResult(i, 1);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            ListDAO dao = new ListDAO(this);
            Cursor crsList = dao.listar();

            this.adapter.swapCursor(crsList);
            adapter.notifyDataSetChanged();
        }
    }
}
