package backend.controller;

import backend.pojo.ClubMember;
import backend.service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 20:36 2019/11/27
 */
@RestController
@RequestMapping(value = "/ClubMember", produces = "application/json;charset=utf-8")
public class ClubMemberController {
    @Autowired
    ClubMemberService clubMemberService;
    @GetMapping(value = "/")
    public List<ClubMember> getAllClubMember(){
        return clubMemberService.queryAllClubMember();
    }
    @GetMapping(value = "/{studentId}")
    public Optional<ClubMember> getClubMemberById(@PathVariable("studentId") String Id){
        return clubMemberService.queryClubMemberById(Id);
    }
    @PostMapping(value = "/")
    public void addClubMember(ClubMember clubMember)
    {
        clubMemberService.addClubMember(clubMember);
    }
    @DeleteMapping(value = "/{studentId}")
    public void deleteClubMember(@PathVariable("studentId") String Id)
    {
        clubMemberService.deleteClubMemberById(Id);
    }
    @PutMapping(value = "/")
    public void putClubMember(ClubMember clubMember)
    {
        clubMemberService.updateClubMember(clubMember);
    }
}
