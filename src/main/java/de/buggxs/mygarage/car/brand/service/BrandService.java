package de.buggxs.mygarage.car.brand.service;

import de.buggxs.mygarage.car.brand.Brand;
import de.buggxs.mygarage.car.brand.db.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        log.info("Fetching all brands");
        return brandRepository.findAll();
    }

    public List<Brand> getBrandsByName(Optional<String> name) {
        log.info("Fetching brands containing string {}", name);
        return brandRepository.findBrandByName(name.orElse(""));
    }

}
