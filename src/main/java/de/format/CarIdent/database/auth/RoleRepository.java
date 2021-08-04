package de.format.CarIdent.database.auth;

import de.format.CarIdent.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
