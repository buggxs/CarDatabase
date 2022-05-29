package de.buggxs.mygarage.car.brand.db;

import de.buggxs.mygarage.car.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
