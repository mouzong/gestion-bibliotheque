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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "utilisatteur")
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String email;
    private String phone_number;
    private String  nom;
    private String prenom;
    private String username;
    private String password;
    private LocalDate date_creation;
    private LocalDate date_edition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abonnement_id_fk",
    referencedColumnName = "userId")
    private Abonnements abonnements;
}
