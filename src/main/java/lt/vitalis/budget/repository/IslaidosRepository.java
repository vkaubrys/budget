package lt.vitalis.budget.repository;

import lt.vitalis.budget.repository.model.Islaidos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IslaidosRepository extends CrudRepository<Islaidos, Integer> {

//    @Query(
//            value = "SELECT * FROM islaidos WHERE pavadinimas LIKE :name",
//            nativeQuery = true
//    )
//
//    List<Islaidos> getIslaidosByNameLike(String name);

}
