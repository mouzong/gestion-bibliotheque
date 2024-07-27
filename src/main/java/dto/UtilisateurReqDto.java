package dto;

import entity.Utilisateurs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurReqDto {

    private String email;
    private String phone_number;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private LocalDate date_creation;
    private LocalDate date_edition;

    public Utilisateurs toUtilisateurs(){
        return Utilisateurs.builder()
                .email(email)
                .phone_number(phone_number)
                .nom(nom)
                .prenom(prenom)
                .username(username)
                .password(password)
                .date_creation(date_creation)
                .date_edition(date_edition)
                .build();
    }

}
