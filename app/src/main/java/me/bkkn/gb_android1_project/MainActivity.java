package me.bkkn.gb_android1_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextName;
    EditText editTextAge;
    EditText editTextPhone;
    EditText editTextEmail;
    //    EditText editTextPassword;
    TextView textViewMessage;
    CalendarView calendarView;
    String name = "";
    String age = "";
    String message = "";
    String selectedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        attachListeners();
    }

    private void initUI() {
        button = findViewById(R.id.ok_button);
        editTextName = findViewById(R.id.name_edit_text);
        textViewMessage = findViewById(R.id.message_edit_text);
        editTextAge = findViewById(R.id.age_edit_text);
        editTextPhone = findViewById(R.id.phone_edit_text);
        editTextEmail = findViewById(R.id.email_edit_text);
//        editTextPassword = findViewById(R.id.edit_text_password);
        calendarView = findViewById(R.id.calendar_view);
    }

    private void attachListeners() {
        calendarView.setOnDateChangeListener((calendarView1, i, i1, i2) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            selectedDate = sdf.format(new Date(calendarView.getDate()));
        });
        editTextName.setOnClickListener(view -> name = view.getTransitionName());
        button.setOnClickListener((view) -> {
            if (!name.isEmpty() && !age.isEmpty() && !selectedDate.isEmpty())
                textViewMessage.setText(formMessage());
            else
                textViewMessage.setText(R.string.warning);
        });
    }

    private String formMessage() {
        message = "Today is " + selectedDate + " and the person named " + name + " is " + age + " years old";
        return message;
    }
}