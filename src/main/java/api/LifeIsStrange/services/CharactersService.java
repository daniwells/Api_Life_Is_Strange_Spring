package api.LifeIsStrange.services;

import api.LifeIsStrange.models.CharactersModel;
import api.LifeIsStrange.repositories.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteCharacter(Long id) {
        charactersRepository.deleteById(id);
    }
}
