package com.example.hw6_2m;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText loginEditText = findViewById(R.id.et_email);
        EditText passwordEditText = findViewById(R.id.et_password);
        Button loginButton = findViewById(R.id.btn_enter);
        TextView welcomeText = findViewById(R.id.tv_welcome);

        loginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!loginEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.grey));
                }
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!loginEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.grey));
                }
            }
        });

        loginButton.setOnClickListener(v -> {
            String enteredLogin = loginEditText.getText().toString();
            String enteredPassword = passwordEditText.getText().toString();

            if (enteredLogin.equals("admin") && enteredPassword.equals("admin")) {
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                loginEditText.setVisibility(View.GONE);
                passwordEditText.setVisibility(View.GONE);
                loginButton.setVisibility(View.GONE);
                welcomeText.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }
}