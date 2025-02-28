package com.example.prakt2;

import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.widget. *;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Проверка логирования";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "info in OnCreate");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button actbutton = findViewById(R.id.button);
        actbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Переход",
                        Toast.LENGTH_SHORT).show();
                onNextActivity(v);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "info in OnStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "info in OnResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "info in OnPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "info in onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "info in onDestroy");
    }
    private void onNextActivity(View view){
        EditText nameText = findViewById(R.id.Text);
        EditText groupText = findViewById(R.id.Text2);
        EditText ageText = findViewById(R.id.Text3);
        EditText gradeText = findViewById(R.id.Text4);

        String name = nameText.getText().toString();
        String group = groupText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());
        int grade = Integer.parseInt(gradeText.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("group", group);
        intent.putExtra("age", age);
        intent.putExtra("grade", grade);
        startActivity(intent);
    }
}