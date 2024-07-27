package repository;

import entity.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Utilisateursrepository  extends JpaRepository<Utilisateurs, UUID> {
}
