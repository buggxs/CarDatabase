package de.format.CarIdent.database;

import de.format.CarIdent.model.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
