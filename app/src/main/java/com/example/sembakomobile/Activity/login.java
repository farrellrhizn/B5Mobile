package com.example.sembakomobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sembakomobile.Model.Retrofit.ResponseModel;
import com.example.sembakomobile.API.ApiClient;
import com.example.sembakomobile.API.ServiceLogin;
import com.example.sembakomobile.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity implements View.OnClickListener {
    private EditText username, password;
    private Button btnlogin, btnregister;
    private String Username, Password;
    private TextView lupa_pass;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);

        btnregister = findViewById(R.id.btnregister);
        btnregister.setOnClickListener(this);

        lupa_pass = findViewById(R.id.lupa_pass);
        lupa_pass.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnlogin:
                Username = username.getText().toString();
                Password = password.getText().toString();
                login(Username, Password);
                break;
            case R.id.btnregister:
                Intent intent = new Intent(this, register.class);
                startActivity(intent);
                break;
            case R.id.lupa_pass:
                Intent yaha = new Intent(this, lupa_password.class);
                startActivity(yaha);
                break;
        }
    }

    private void login(String username, String password) {
        if (username.equals("") || password.equals("")){
            Toast.makeText(login.this, "Harap Lengkapi Data", Toast.LENGTH_SHORT).show();
        } else {
            ServiceLogin service = ApiClient.getClient().create(ServiceLogin.class);
            Call<ResponseModel> loginCall = service.loginResponse(username, password);
            loginCall.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    if (response.body().getKode() == 1){
                        shared = getSharedPreferences("myapp-data", MODE_PRIVATE);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putBoolean("status", true);
                        editor.commit();
                        Toast.makeText(login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this, selamat_datang.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "Username Atau Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(login.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}