package lt.vitalis.budget.service;

import lt.vitalis.budget.repository.PajamosRepository;
import lt.vitalis.budget.repository.model.Pajamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PajamosService {

    @Autowired
    private PajamosRepository pajamosRepository;

    public void save(Pajamos pajamos) {
        pajamosRepository.save(pajamos);
    }

    public List<Pajamos> getAll() {
        return (List<Pajamos>) pajamosRepository.findAll();
    }
}
