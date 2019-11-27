package backend.dao.repository;

import backend.pojo.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: OY
 * @date: 15:57 2019/11/27
 */
public interface ClubMemberRepository extends JpaRepository<ClubMember,String> {
}

