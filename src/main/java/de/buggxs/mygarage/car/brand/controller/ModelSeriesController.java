package de.buggxs.mygarage.car.brand.controller;

import de.buggxs.mygarage.car.brand.ModelSeries;
import de.buggxs.mygarage.car.brand.ModelSeriesGeneration;
import de.buggxs.mygarage.car.brand.service.ModelSeriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/model-series")
@Slf4j
@AllArgsConstructor
public class ModelSeriesController {

    private final ModelSeriesService modelSeriesService;

    @GetMapping
    public Page<ModelSeries> showAllModelSeries(
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return modelSeriesService.showAllModelSeries(page);
    }

    @GetMapping(value = "/find")
    public Page<ModelSeries> findAllModelSeries(
            @RequestParam(value = "name", required = false) Optional<String> name,
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return modelSeriesService.findAllModelSeries(name, page);
    }

    @GetMapping(value = "/generations")
    public Page<ModelSeriesGeneration> showAllModelSeriesGenerations(
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return modelSeriesService.showAllModelSeriesGenerations(page);
    }

    @GetMapping(value = "/generations/find")
    public Page<ModelSeriesGeneration> findAllModelSeriesGenerations(
            @RequestParam(value = "name", required = false) Optional<String> name,
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return modelSeriesService.findAllModelSeriesGeneration(name, page);
    }
}
