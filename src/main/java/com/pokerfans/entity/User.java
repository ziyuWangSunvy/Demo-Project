package com.pokerfans.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author Ziyu Wang
 * @version 0.1.0
 * @since 0.1.0
 */
@TableName("users")
@lombok.Setter
@lombok.Getter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class User {

    @TableId
    private Long id;

    private String username;

    private String email;
}
