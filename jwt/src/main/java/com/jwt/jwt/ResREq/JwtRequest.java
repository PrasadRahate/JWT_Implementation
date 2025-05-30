package com.jwt.jwt.ResREq;


import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtRequest {

    String username ;
    String password ;
}
