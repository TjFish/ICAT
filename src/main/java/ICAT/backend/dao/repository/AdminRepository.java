package ICAT.backend.dao.repository;

import ICAT.backend.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    public Admin getAdminByAdminIdAndPassword(String adminId, String password);

}
