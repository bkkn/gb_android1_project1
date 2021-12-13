package me.bkkn.gb_android1_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextName;
    EditText editTextAge;
    EditText editTextPhone;
    EditText editTextEmail;
    EditText editTextPassword;
    TextView textViewMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        attachListeners();
    }

    private void initUI(){
        button = findViewById(R.id.button_ok);
        editTextName = findViewById(R.id.edit_text_name);
        textViewMessage = findViewById(R.id.edit_text_message);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextPhone = findViewById(R.id.edit_text_phone);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);
    }

    private void attachListeners(){
        button.setOnClickListener((val)->{

            int maxEms = editTextName.getMaxEms();
            int minEms = editTextName.getMinEms();

            textViewMessage.setText(editTextName.getText());
        });
    }
}