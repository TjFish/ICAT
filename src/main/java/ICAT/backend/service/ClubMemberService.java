package ICAT.backend.service;

import ICAT.backend.pojo.ClubMember;
import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;

/**
 * @author: OY
 * @date: 16:04 2019/11/27
 */
@Service
public interface ClubMemberService extends CURDService<ClubMember,String> {

}
