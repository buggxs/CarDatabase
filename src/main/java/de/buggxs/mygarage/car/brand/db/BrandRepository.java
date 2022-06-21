package de.buggxs.mygarage.car.brand.db;

import de.buggxs.mygarage.car.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query(value = "SELECT * FROM brands WHERE name LIKE %:name%", nativeQuery = true)
    List<Brand> findBrandByName(@Param("name") String name);

}
