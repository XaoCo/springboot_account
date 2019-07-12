package com.abc.account.service.impl;

import com.abc.account.mapper.InAndOutMapper;
import com.abc.account.pojo.InAndOut;
import com.abc.account.service.InAndOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package: com.abc.account.service.impl
 * auther： abc
 * date: 2019/7/12 15:13
 * introduce: TODO
 */
@Service
public class InAndOutServiceImpl implements InAndOutService {

    @Autowired
    private InAndOutMapper inAndOutMapper;

    @Override
    public List<InAndOut> selRecord(String userName) {
        return inAndOutMapper.selRecord(userName);
    }

    @Override
    public List<InAndOut> selAllRecord() {
        return inAndOutMapper.selAllRecord();
    }

    @Override
    public int addRecord(InAndOut inAndOut) {
        return inAndOutMapper.addRecord(inAndOut);
    }

    @Override
    public int updRecord(InAndOut inAndOut) {
        return inAndOutMapper.updRecord(inAndOut);
    }

    @Override
    public int delRecord(int id) {
        return inAndOutMapper.delRecord(id);
    }
}
