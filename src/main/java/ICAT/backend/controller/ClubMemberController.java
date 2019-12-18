package ICAT.backend.controller;

import ICAT.backend.pojo.ClubMember;
import ICAT.backend.service.ClubMemberService;
import ICAT.common.controller.CURDController;
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
public class ClubMemberController extends CURDController<ClubMember,String,ClubMemberService> {

}
