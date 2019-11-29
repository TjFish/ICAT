package backend.service.impl;

import backend.dao.repository.ClubMemberRepository;
import backend.pojo.ClubMember;
import backend.service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 17:06 2019/11/27
 */
@Transactional
@Service
@CacheConfig(cacheNames = "ClubMember")
public class ClubMemberServiceImpl implements ClubMemberService {
    @Autowired
    private ClubMemberRepository clubMemberRepository;


    /**
     * 从3.1开始，Spring引入了对Cache的支持。其使用方法和原理都类似于Spring对事务管理的支持。
     * Spring Cache是作用在方法上的，其核心思想是这样的：
     * 当我们在调用一个缓存方法时会把该方法参数和返回结果作为一个键值对存放在缓存中，
     * 等到下次利用同样的参数来调用该方法时将不再执行该方法，而是直接从缓存中获取结果进行返回。
     * 所以在使用Spring Cache的时候我们要保证我们缓存的方法对于相同的方法参数要有相同的返回结果。
     * 包含@Cacheable（增添缓存）、@CacheEvict（删除缓存）、@CachePut（更新缓存） 三种
     * 这里是配合redis使用，由redis存储缓存
     * 具体教程可以参考https://www.jianshu.com/p/970335a3f576
     *
     * 除了上述的通过Cache注解的方式，让springboot自动增加缓存，还在程序代码中可以手动的增添redis缓存
     * ps: 应该只给经常访问的对象加缓存
     */


    @Override
    @CachePut(key = "#clubMember.studentId")
    public void addClubMember(ClubMember clubMember) {
        //这里要注意，如果数据库中已有相同主键的实体，jpa会更新它，而不是抛出异常
        clubMemberRepository.save(clubMember);
    }

    @Override
    @CacheEvict(key = "#p0") // 删除缓存,#p0代表第一个参数id, #p1就代表第二个参数
    public void deleteClubMemberById(String id) {
        clubMemberRepository.deleteById(id);
    }

    @Override
    @CachePut(key = "#clubMember.studentId")
    public void updateClubMember(ClubMember clubMember) {
        clubMemberRepository.saveAndFlush(clubMember);
    }

    @Cacheable(key = "#id") //增添缓存,缓存的键名为ClubMember+ key（id）
    @Override
    public Optional<ClubMember> queryClubMemberById(String id) {
        return clubMemberRepository.findById(id);
    }


    @Override
    public List<ClubMember> queryAllClubMember() {
        return clubMemberRepository.findAll();
    }

    @Override
    public boolean exsitsById(String id) {
        return clubMemberRepository.existsById(id);
    }
}
