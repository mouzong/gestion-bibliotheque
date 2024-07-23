package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "role")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID role_id;
    private String nom_role;
    private String description;
}
