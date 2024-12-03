package api.LifeIsStrange.services;

// Libs
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;

// Classes
import api.LifeIsStrange.models.LocalsModel;
import api.LifeIsStrange.repositories.LocalsRepository;

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

    public Page<LocalsModel> getLocalsPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return localsRepository.findAll(pageable);
    }

    public void deleteLocal(Long id) {
        localsRepository.deleteById(id);
    }
}
