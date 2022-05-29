package de.buggxs.mygarage.car.brand.controller;

import de.buggxs.mygarage.car.brand.Brand;
import de.buggxs.mygarage.car.brand.service.BrandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RequestMapping(name = "/api/v1/brand")
public class BrandApiController {

    private final BrandService brandService;

    @GetMapping
    public List<Brand> showAllBrands() {
        return brandService.getAllBrands();
    }

}
