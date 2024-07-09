package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationBodyDto {
    private String username; //*	string email
    private String password; //	string
    private String firstName;//	string
    private String lastName; //	string
}
