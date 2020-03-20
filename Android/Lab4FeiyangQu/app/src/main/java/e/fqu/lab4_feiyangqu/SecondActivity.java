package e.fqu.lab4_feiyangqu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String username = getIntent().getStringExtra("name");
        ((TextView) findViewById(R.id.accept)).setText(username + " ,Welcome to my webpage!");
    }
}
