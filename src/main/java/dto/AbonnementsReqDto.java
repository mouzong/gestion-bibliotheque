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
public class AbonnementsReqDto {

    private LocalDate date_abonnement;
    private LocalDate date_expiration;
    private String type_abonnement;
    private double cout_abonnement;
    private String etat_abonnement;

    public Abonnements toAbonnements(){
        return Abonnements.builder()
                .date_abonnement(date_abonnement)
                .date_expiration(date_expiration)
                .cout_abonnement(cout_abonnement)
                .etat_abonnement(etat_abonnement)
                .type_abonnement(type_abonnement)
                .build();
    }
}
