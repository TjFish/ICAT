package backend.service;

import backend.pojo.ApplyToAdopt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:36 2019/11/30
 */
@Service
public interface ApplyToAdoptService {
    public void addApplyToAdopt(ApplyToAdopt application);

    public void deleteApplyToAdoptById(String id);

    public void updateApplyToAdopt(ApplyToAdopt application);

    public Optional<ApplyToAdopt> queryApplyToAdoptById(String id);

    public List<ApplyToAdopt> queryAllApplyToAdopt();

    public boolean existsById(String id);
}
