package com.abc.account.service.impl;

import com.abc.account.mapper.KindMapper;
import com.abc.account.pojo.Kind;
import com.abc.account.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package: com.abc.account.service.impl
 * auther： abc
 * date: 2019/7/12 10:24
 * introduce: TODO
 */
@Service
public class KindServiceImpl implements KindService {
    @Autowired
    private KindMapper kindMapper;

    @Override
    public List<Kind> findAllKind(String string) {
        return kindMapper.findAllKind(string);
    }


    @Override
    public Kind findByName(String name) {
        return kindMapper.findByName(name);
    }

    @Override
    public int addKind(String name) {
        return kindMapper.addKind(name);
    }

    @Override
    public int updKind(int id, String name) {
        return kindMapper.updKind(id, name);
    }

    @Override
    public int delKind(int id) {
        return kindMapper.delKind(id);
    }
}
