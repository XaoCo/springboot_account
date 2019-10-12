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
    public List<InAndOut> selRecord(InAndOut inAndOut) {
        return inAndOutMapper.selRecord(inAndOut);
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

    @Override
    public String findAllIn(String username) {
        return inAndOutMapper.findAllIn(username);
    }

    @Override
    public String findAllOut(String username) {
        return inAndOutMapper.findAllOut(username);
    }

    @Override
    public List<InAndOut> getAllOut(String username) {
        return inAndOutMapper.getAllOut(username);
    }

    @Override
    public List<InAndOut> getAllPreout(String username) {
        return inAndOutMapper.getAllPreout(username);
    }

    @Override
    public List<InAndOut> getAllIn(String username) {
        return inAndOutMapper.getAllIn(username);
    }
}
