package eu.study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import eu.study.dao.ListDAO;
import eu.study.vo.ListVO;

public class NewItemActivity extends AppCompatActivity {

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        this.name = (EditText) findViewById(R.id.inputName);
    }

    public void salvar(View v){
        ListVO list = new ListVO();
        list.setNome(name.getText().toString());

        ListDAO dao = new ListDAO(this);
        dao.salvar(list);

        setResult(RESULT_OK);
        finish();
    }
}
