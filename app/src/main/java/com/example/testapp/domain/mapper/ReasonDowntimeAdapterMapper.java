package com.example.testapp.domain.mapper;

import com.example.testapp.domain.print.ReasonDowntimePrint;

public class ReasonDowntimeAdapterMapper extends Mapper<ReasonDowntimePrint, String> {
    @Override
    protected String mapImp(ReasonDowntimePrint item) {
        return item.getName();
    }
}
