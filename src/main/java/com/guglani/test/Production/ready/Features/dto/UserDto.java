package com.guglani.test.Production.ready.Features.dto;

import lombok.*;

import java.io.Serializable;





@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto  implements Serializable {


    private Long id;

    private String name;

    private String email;

    private String password;

    private Long age;


}
