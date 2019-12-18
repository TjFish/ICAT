package ICAT.backend.service.impl;

import ICAT.backend.pojo.ClubMember;
import ICAT.backend.dao.repository.ClubMemberRepository;
import ICAT.backend.service.ClubMemberService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author: OY
 * @date: 17:06 2019/11/27
 */
@Transactional
@Service
@CacheConfig(cacheNames = "ClubMember")
public class ClubMemberServiceImpl extends CURDServiceImpl<ClubMember,String,ClubMemberRepository> implements ClubMemberService {

}
