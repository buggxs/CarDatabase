package de.buggxs.mygarage.car.brand.controller;

import de.buggxs.mygarage.car.brand.Brand;
import de.buggxs.mygarage.car.brand.service.BrandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1/brands")
public class BrandApiController {

    private final BrandService brandService;

    @GetMapping
    public List<Brand> showAllBrands(
            @RequestParam(value = "name", required = false) Optional<String> name
    ) {
        if (name.isPresent()) {
            return brandService.getBrandsByName(name);
        }
        return brandService.getAllBrands();
    }

}
