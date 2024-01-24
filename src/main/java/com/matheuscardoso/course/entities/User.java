package com.matheuscardoso.course.entities;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
