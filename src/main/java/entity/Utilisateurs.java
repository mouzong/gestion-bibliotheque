package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID user_id;
    private String email;
    private String phone_number;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private LocalDate date_creation;
    private LocalDate date_edition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abonement_id_fk",
            referencedColumnName = "user_id")
    private Abonnements abonnements;
}
