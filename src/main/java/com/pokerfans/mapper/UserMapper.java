package com.pokerfans.mapper;

import com.pokerfans.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ziyu Wang
 * @version 0.1.0
 * @since 0.1.0
 */
@Mapper
public interface UserMapper {

    int insert(User user);

    User findById(Long id);

    List<User> findAll();

    void update(User user);

    void deleteById(Long id);

}

