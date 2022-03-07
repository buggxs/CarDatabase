package de.format.CarIdent.permission;

import de.format.CarIdent.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
