package api.LifeIsStrange.services;

import api.LifeIsStrange.models.LocalsModel;
import api.LifeIsStrange.repositories.LocalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalsService {
    @Autowired
    private LocalsRepository localsRepository;

    public LocalsModel saveLocal(LocalsModel local) {
        return localsRepository.save(local);
    }

    public Optional<LocalsModel> getLocalById(Long id) {
        return localsRepository.findById(id);
    }

    public List<LocalsModel> getAllLocals() {
        return localsRepository.findAll();
    }

    public void deleteLocal(Long id) {
        localsRepository.deleteById(id);
    }
}
