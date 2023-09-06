package lt.vitalis.budget.service;

import lt.vitalis.budget.repository.IslaidosRepository;
import lt.vitalis.budget.repository.model.Islaidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslaidosService {

    @Autowired
    private IslaidosRepository islaidosRepository;

    public void save(Islaidos islaidos) {
        islaidosRepository.save(islaidos);
    }

    public  List<Islaidos> getAll() {
        return (List<Islaidos>) islaidosRepository.findAll();
    }
}
