package de.buggxs.mygarage.car.brand.service;

import de.buggxs.mygarage.car.brand.ModelSeries;
import de.buggxs.mygarage.car.brand.ModelSeriesGeneration;
import de.buggxs.mygarage.car.brand.db.ModelSeriesGenerationRepository;
import de.buggxs.mygarage.car.brand.db.ModelSeriesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ModelSeriesService {

    private final ModelSeriesRepository modelSeriesRepository;
    private final ModelSeriesGenerationRepository modelSeriesGenerationRepository;

    public Page<ModelSeries> showAllModelSeries(Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        log.info("Showing model series page number {}", pageNumber);
        Pageable pageRequest = PageRequest.of(pageNumber, 200);
        return modelSeriesRepository.findAll(pageRequest);
    }

    public Page<ModelSeries> findAllModelSeries(Optional<String> name, Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        if (name.isPresent()) {
            log.info("Showing model series with name {} and page number {}", name.get(), pageNumber);
            Pageable pageRequest = PageRequest.of(pageNumber, 200);
            return modelSeriesRepository.findModelSeriesByNameContainingIgnoreCase(name.get(), pageRequest);
        } else {
            return showAllModelSeries(page);
        }
    }

    public Page<ModelSeriesGeneration> showAllModelSeriesGenerations(Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        log.info("Showing model series generation page number {}", pageNumber);
        Pageable pageRequest = PageRequest.of(pageNumber, 200);
        return modelSeriesGenerationRepository.findAll(pageRequest);
    }

    public Page<ModelSeriesGeneration> findAllModelSeriesGeneration(Optional<String> name, Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        if (name.isPresent()) {
            log.info("Showing model series with name {} and page number {}", name.get(), pageNumber);
            Pageable pageRequest = PageRequest.of(pageNumber, 200);
            return modelSeriesGenerationRepository.findModelSeriesGenerationByNameContainingIgnoreCase(name.get(), pageRequest);
        } else {
            return showAllModelSeriesGenerations(page);
        }
    }

}
