package ICAT.backend.dao.repository;

import ICAT.backend.pojo.ApplyToAdopt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 14:35 2019/11/30
 */
public interface ApplyToAdoptRepository extends JpaRepository<ApplyToAdopt, Integer> {
}
