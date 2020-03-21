package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.domain.impl.InformingUseCaseImpl;
import com.example.testapp.presentation.MainActivityPresenter;
import com.example.testapp.presentation.MainView;

public class MainActivity extends MvpAppCompatActivity implements View.OnClickListener, MainView {

    TextView welcomeText;
    EditText userName;
    EditText password;
    Button login;
    String textAccess;

    @InjectPresenter
    MainActivityPresenter presenter;

    @ProvidePresenter
    MainActivityPresenter providePresenter() {
        return new MainActivityPresenter(new InformingUseCaseImpl(""));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcome_text);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                textAccess = userName.getText().toString()+":"+password.getText().toString()+"@";
                presenter.onLogin(userName.getText().toString(), password.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoginSuccessfully() {
        Intent intent = new Intent(this, ActivityScan.class);
        intent.putExtra("textAccess", textAccess);
        intent.putExtra("userName", userName.getText().toString());
        startActivity(intent);
    }

    @Override
    public void showResultLogin(String reason) {
        Toast toast = Toast.makeText(this, reason, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }


}
