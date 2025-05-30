package com.jwt.jwt.ResREq;


import lombok.*;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {


    private String token ;
    private String username ;
    
}
