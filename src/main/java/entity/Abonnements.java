package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "abonnement")
public class Abonnements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID abonnementId;
    private LocalDate date_abonnement;
    private LocalDate date_expiration;
    private String type_abonnement;
    private double cout_abonnement;
    private String etat_abonnement;

    @OneToOne(mappedBy = "abonnements")
    private List<Utilisateurs> utilisateurs = new ArrayList<>();

    public void addUser(Utilisateurs user) {
        if (this.utilisateurs.contains(user)) {
            utilisateurs.add(user);
            user.setAbonnements(this);
        }

    }

    public void removeUser(Utilisateurs user) {
        if (this.utilisateurs.contains(user)) {
            utilisateurs.add(user);
            user.setAbonnements(null);

        }
    }
}
