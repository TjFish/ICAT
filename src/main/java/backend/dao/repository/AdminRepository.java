package backend.dao.repository;

import backend.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    public Admin getAdminByAdminIdAndPassword(String adminId, String password);

}
