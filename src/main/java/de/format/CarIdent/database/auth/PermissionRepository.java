package de.format.CarIdent.database.auth;

import de.format.CarIdent.model.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
