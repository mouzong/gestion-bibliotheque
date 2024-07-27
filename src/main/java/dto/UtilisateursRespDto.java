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
public class UtilisateursRespDto {
    private String email;
    private String phone_number;
    private String  nom;
    private String prenom;
    private String username;
    private LocalDate date_creation;
    private LocalDate date_edition;

public UtilisateursRespDto fromUtilisateurs(Utilisateurs utilisateurs){
return UtilisateursRespDto.builder()
        .email(utilisateurs.getEmail())
        .phone_number(utilisateurs.getPhone_number())
        .nom(utilisateurs.getNom())
        .prenom(utilisateurs.getPrenom())
        .username(utilisateurs.getUsername())
        .date_creation(utilisateurs.getDate_creation())
        .date_edition(utilisateurs.getDate_edition())
        .build();
}
}
