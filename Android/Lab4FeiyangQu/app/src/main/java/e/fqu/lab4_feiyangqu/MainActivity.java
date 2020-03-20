package e.fqu.lab4_feiyangqu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText word;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        word = (EditText) findViewById(R.id.word);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_name = name.getText().toString();
                String text_word = word.getText().toString();
                if (text_word.equals("123456")&& text_name.equals("cs7455")){
                    Intent second = new Intent(getBaseContext(), SecondActivity.class);
                    second.putExtra("name", text_name);
                    second.putExtra("word", text_word);
                    startActivity(second);
                }else {
                    Intent third = new Intent(getBaseContext(), ThirdActivity.class);
                    startActivity(third);
                }
            }
        });
    }
}
