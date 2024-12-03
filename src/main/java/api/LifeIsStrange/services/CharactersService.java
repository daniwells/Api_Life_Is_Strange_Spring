package api.LifeIsStrange.services;

import api.LifeIsStrange.models.CharactersModel;
import api.LifeIsStrange.repositories.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Paginação
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// Ordenação
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class CharactersService {
    @Autowired
    private CharactersRepository charactersRepository;

    public CharactersModel saveCharacter(CharactersModel character) {
        return charactersRepository.save(character);
    }    

    public Optional<CharactersModel> getCharacterById(Long id) {
        return charactersRepository.findById(id);
    }

    public List<CharactersModel> getAllCharacters() {
        return charactersRepository.findAll();
    }


    public List<CharactersModel> getAllCharacters(Boolean sortBy) {
        if (sortBy) {
            return charactersRepository.findAll(Sort.by(Sort.Direction.ASC, "age"));
        } else {
            return charactersRepository.findAll();
        }
    }
    
    public Page<CharactersModel> getCharactersPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return charactersRepository.findAll(pageable);
    }

    public void deleteCharacter(Long id) {
        charactersRepository.deleteById(id);
    }
}
