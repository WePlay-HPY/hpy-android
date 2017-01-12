package hpy.pixstreet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PseudoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);
    }

    public void validatePseudo(View v)
    {
        EditText etPseudo;
        etPseudo = (EditText)findViewById(R.id.editTextPseudo);
        CharSequence pseudo = etPseudo.getText();

        /*
        if(pseudo.length()==0)
        {
            Toast.makeText(getApplicationContext(), "Entrez un pseudo", Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(getApplicationContext(), "Pseudo:" + pseudo, Toast.LENGTH_LONG).show();
        */

        AsyncLoadMap task = new AsyncLoadMap(this);
        task.execute();
        /*
        Intent intent = new Intent(this, OpenStreetMap.class);
        startActivity(intent);
        */
    }

}
