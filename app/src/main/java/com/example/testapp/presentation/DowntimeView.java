package com.example.testapp.presentation;

import com.arellomobile.mvp.MvpView;
import java.util.List;

public interface DowntimeView extends MvpView {
    void setAdapter(List<String> reasonsList);
    void showResult(Boolean result);
}
