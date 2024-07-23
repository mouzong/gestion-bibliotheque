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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emprunt")
public class Emprunts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emprunt_id;
    private LocalDate date_emprunt;
    private LocalDate date_retour;
    private Boolean est_retourner;
    private LocalDate date_creation;
    private LocalDate date_edition;
}
