package lt.vitalis.budget.repository;

import lt.vitalis.budget.repository.model.Islaidos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IslaidosRepository extends CrudRepository<Islaidos, Integer> {

    @Query(
            value = "select * from islaidos where data between :startDate and :endDate",
            nativeQuery = true
    )

    List<Islaidos> getIslaidosBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
