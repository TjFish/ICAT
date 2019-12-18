package ICAT.backend.dao.repository;

import ICAT.backend.pojo.DiseaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: OY
 * @date: 18:58 2019/11/28
 */
public interface DiseaseRecordRepository extends JpaRepository<DiseaseRecord,String> {

    @Query(nativeQuery = true, value = "select * from diseaseRecord t where t.catId = :id order by startTime")
    public List<DiseaseRecord> getAllDiseaseRecordByCatId(String id);

    @Query(nativeQuery = true, value =
            "select " +"diseaseRecord.recordId as recordId,"+
                    " diseaseRecord.diseaseName as diseaseName," +
                    " diseaseRecord.startTime as startTime," +
                    " diseaseRecord.endTime as endTime," +
                    " diseaseRecord.remark as remark," +
                    " diseaseRecord.catId as catId," +
                    " cat.catName as catName"+
            " from diseaseRecord " +
            "join cat on diseaseRecord.catID = cat.catID")
    public List<Object[]> getAllDiseaseRecordsWithCatName();
}
