package com.inte.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Users {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
