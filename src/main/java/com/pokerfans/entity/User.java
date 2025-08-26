package com.pokerfans.entity;

/**
 * @author Ziyu Wang
 * @version 0.1.0
 * @since 0.1.0
 */
@lombok.Setter
@lombok.Getter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class User {

    private Long id;

    private String username;

    private String email;
}
