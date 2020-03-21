package com.example.testapp.domain.mapper;

import com.example.testapp.domain.print.ResultLoginPrint;
import com.sample.core.dto.ResultLogin;

public class ResultLoginMapper extends Mapper<ResultLogin, ResultLoginPrint> {
    @Override
    protected ResultLoginPrint mapImp(ResultLogin item) {
        return new ResultLoginPrint(
                item.getTextResult(),
                item.getReason()
        );
    }
}
