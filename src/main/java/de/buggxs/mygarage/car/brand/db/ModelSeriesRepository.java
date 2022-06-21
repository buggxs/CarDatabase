package de.buggxs.mygarage.car.brand.db;

import de.buggxs.mygarage.car.brand.ModelSeries;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelSeriesRepository extends PagingAndSortingRepository<ModelSeries, Long> {
}
