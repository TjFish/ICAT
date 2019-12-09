package ICAT.backend.controller;

import ICAT.backend.pojo.Adoption;
import ICAT.backend.service.AdoptionService;
import ICAT.common.controller.CURDController;
import org.springframework.web.bind.annotation.*;


/**
 * @author Shidan Cheng
 * @date 14:17 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/Adoptions", produces = "application/json;charset=utf-8")
public class AdoptionController extends CURDController<Adoption, String, AdoptionService> {
}
