package lt.vitalis.budget.service;

import lt.vitalis.budget.repository.PajamosRepository;
import lt.vitalis.budget.repository.model.Pajamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Pajamos getPajamosById(int id) {
        return pajamosRepository.findById(id).orElse(new Pajamos());
    }

    public List<Pajamos> getPajamosBetweenDates(LocalDateTime startDate, LocalDateTime endDate){
        List<Pajamos> list = pajamosRepository.getPajamosBetweenDates(startDate, endDate);
        return list;
    }

    public double countPajamosMax(List<Pajamos> pajamuSarasas) {
        return pajamuSarasas.stream().mapToDouble(Pajamos::getSuma).sum();
    }
}
