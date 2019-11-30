package backend.service;

import backend.pojo.Adoption;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:18 2019/11/30
 */
@Service
public interface AdoptionService {
    public void addAdoption(Adoption adoption);

    public void deleteAdoptionById(String id);

    public void updateAdoption(Adoption adoption);

    public Optional<Adoption> queryAdoptionById(String id);

    public List<Adoption> queryAllAdoption();

    public boolean existsById(String id);
}
