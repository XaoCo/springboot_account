package com.abc.account.mapper;

import com.abc.account.pojo.Kind;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * package: com.abc.account.mapper
 * auther： abc
 * date: 2019/7/12 10:03
 * introduce: TODO
 */
public interface KindMapper {
    //    查询种类
    List<Kind> findAllKind(@Param("flag") String string);

//    //    查询所有收入种类
//    List<Kind> findAllinKind(@Param("flag") String string);
//
//    //    查询所有预留开支种类
//    List<Kind> findAllPreKind(@Param("flag") String string);

    // 根据名称查询种类信息
    Kind findByName(@Param("name") String name);

    //    新增种类
    int addKind(@Param("name") String name);

    //    修改种类名称
    int updKind(@Param("id") int id, @Param("newName") String name);

    //    删除某一种类
    int delKind(@Param("id") int id);
}
