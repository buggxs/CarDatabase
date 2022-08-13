package de.buggxs.mygarage.car.brand.db;

import de.buggxs.mygarage.car.brand.ModelSeriesGeneration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelSeriesGenerationRepository extends PagingAndSortingRepository<ModelSeriesGeneration, Long> {

    Page<ModelSeriesGeneration> findModelSeriesGenerationByNameContainingIgnoreCase(String name, Pageable pageable);


}
