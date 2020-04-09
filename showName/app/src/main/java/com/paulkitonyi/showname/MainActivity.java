package com.paulkitonyi.showname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.paulkitonyi.showname.R;

public class MainActivity extends AppCompatActivity {
    private Button mybtn;
    private TextView myTxtView;
    private EditText enterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mybtn = findViewById(R.id.button);
        myTxtView = findViewById(R.id.textView);
        enterName = findViewById(R.id.editText);

        enterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterName.setText("");
            }
        });

        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterName.getText().toString();
                myTxtView.setText("Your name is "+name);
                enterName.setText("Enter a another name!!");
            }
        });
    }
}
