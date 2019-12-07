package ICAT.backend.dao.repository;

import ICAT.backend.pojo.CatImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CatImageRepository extends JpaRepository<CatImage,String> {

}
