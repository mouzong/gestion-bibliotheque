package dto;

import entity.Abonnements;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AbonnementsRespDto {

    private LocalDate date_abonnement;
    private LocalDate date_expiration;
    private String type_abonnement;
    private double cout_abonnement;
    private String etat_abonnement;

    public AbonnementsRespDto fromAbonnements(Abonnements abonnements){
        return AbonnementsRespDto.builder()
                .date_abonnement(abonnements.getDate_abonnement())
                .date_expiration(abonnements.getDate_expiration())
                .type_abonnement(abonnements.getType_abonnement())
                .cout_abonnement(abonnements.getCout_abonnement())
                .etat_abonnement(abonnements.getEtat_abonnement())
                .build();
    }
}
