package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "abonnement")
public class Abonnements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID abonnement_id;
    private LocalDate date_abonnement;
    private LocalDate date_expiration;
    private String type_abonnement;
    private double cout_abonnement;
    private String etat_abonnement;

    @OneToOne(mappedBy = "abonnements")
    private Utilisateurs utilisateurs;
}
