package de.buggxs.mygarage.car.brand.db;

import de.buggxs.mygarage.car.brand.ModelSeries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelSeriesRepository extends PagingAndSortingRepository<ModelSeries, Long> {

    Page<ModelSeries> findModelSeriesByNameContainingIgnoreCase(String name, Pageable pageable);

}
