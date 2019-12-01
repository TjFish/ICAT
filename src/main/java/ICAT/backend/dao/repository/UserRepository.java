package ICAT.backend.dao.repository;

import ICAT.backend.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "update user set password = :password where userAccount = :id", nativeQuery = true)
    public void updatePasswordById(String id, String password);

    public User getByUserAccountAndPassword(String userAccount, String password);

}
