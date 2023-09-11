package lt.vitalis.budget.repository;

import lt.vitalis.budget.repository.model.Pajamos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PajamosRepository extends CrudRepository<Pajamos, Integer> {

    @Query(
            value = "select * from pajamos where data between :startDate and :endDate",
            nativeQuery = true
    )

    List<Pajamos> getPajamosBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

}
