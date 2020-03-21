package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.domain.print.InfoForkliftPrint;
import com.example.testapp.domain.impl.InformingUseCaseImpl;
import com.example.testapp.presentation.MenuActivityPresenter;
import com.example.testapp.presentation.MenuView;

public class ActivityMenu extends MvpAppCompatActivity
        implements View.OnClickListener, MenuView {

    TextView text_info;
    Button add_downtime;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    String textAccess;
    String idForklift;
    String userName;

    @InjectPresenter
    MenuActivityPresenter presenter;

    @ProvidePresenter
    MenuActivityPresenter providePresenter() {
        return new MenuActivityPresenter(new InformingUseCaseImpl(textAccess));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle arguments = getIntent().getExtras();
        textAccess = arguments.get("textAccess").toString();
        idForklift = arguments.get("idForklift").toString();
        userName = arguments.get("userName").toString();

        text_info = findViewById(R.id.text_info);
        add_downtime = findViewById(R.id.add_downtime);
        add_downtime.setOnClickListener(this);
        recyclerView = findViewById(R.id.last_downtime);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_downtime:
                Intent intent = new Intent(this, ActivityDowntime.class);
                intent.putExtra("textAccess", textAccess);
                intent.putExtra("idForklift", idForklift);
                intent.putExtra("userName", userName);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void setInfo(InfoForkliftPrint infoForkliftPrint) {
        text_info.setText(infoForkliftPrint.getNameForklift());

        DowntimeAdapter downtimeAdapter = new DowntimeAdapter(infoForkliftPrint.getLastDowntimeList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(downtimeAdapter);
        progressBar.setVisibility(View.GONE);
    }
}
