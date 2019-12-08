package ICAT.backend.controller;

import ICAT.backend.pojo.ClubMember;
import ICAT.backend.service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 20:36 2019/11/27
 */
@RestController
@RequestMapping(value = "/api/ClubMembers", produces = "application/json;charset=utf-8")
public class ClubMemberController {
    @Autowired
    ClubMemberService clubMemberService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<ClubMember> getAllClubMember() {
        return clubMemberService.queryAllClubMember();
    }

    @GetMapping(value = "/{studentId}")
    @ResponseBody
    public Optional<ClubMember> getClubMemberById(@PathVariable("studentId") String Id) {
        return clubMemberService.queryClubMemberById(Id);
    }

    @PostMapping(value = "/")
    public void addClubMember(@RequestBody ClubMember clubMember) {
        clubMemberService.addClubMember(clubMember);
    }


    @DeleteMapping(value = "/{studentId}")
    public void deleteClubMember(@PathVariable("studentId") String id) {
        clubMemberService.deleteClubMemberById(id);
    }

    @PutMapping(value = "/")
    public void putClubMember(@RequestBody ClubMember clubMember)
    {
        clubMemberService.updateClubMember(clubMember);
    }
}
