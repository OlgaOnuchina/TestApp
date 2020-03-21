package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.domain.impl.InformingUseCaseImpl;
import com.example.testapp.presentation.ScanActivityPresenter;
import com.example.testapp.presentation.ScanView;

public class ActivityScan extends MvpAppCompatActivity implements View.OnClickListener, ScanView {

    EditText barcode;
    Button scan;
    String textAccess;
    String userName;

    @InjectPresenter
    ScanActivityPresenter presenter;

    @ProvidePresenter
    ScanActivityPresenter providePresenter() {
        return new ScanActivityPresenter(new InformingUseCaseImpl(textAccess));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        Bundle arguments = getIntent().getExtras();
        textAccess = arguments.get("textAccess").toString();
        userName = arguments.get("userName").toString();

        //Log.d("myLogs", "активити скан. textAccess = "+textAccess);

        barcode = findViewById(R.id.barcode);
        scan = findViewById(R.id.scan);
        scan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.scan:
                Intent intent = new Intent(this, ActivityMenu.class);
                intent.putExtra("textAccess", textAccess);
                intent.putExtra("idForklift", barcode.getText().toString());
                intent.putExtra("userName", userName);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
