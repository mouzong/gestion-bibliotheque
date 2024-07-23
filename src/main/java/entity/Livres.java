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
@Table(name = "livre")
public class Livres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID livre_id;
    private String auteur;
    private String titre;
    private LocalDate date_publication;
    private String isbn;
    private String editeur;
    private double nbre_exemplaires;
    private String cathegorie;
}
