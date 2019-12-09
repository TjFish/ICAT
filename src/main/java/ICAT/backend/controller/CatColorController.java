package ICAT.backend.controller;

import ICAT.backend.pojo.CatColor;
import ICAT.backend.service.CatColorService;
import ICAT.common.controller.CURDController;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shidan Cheng
 * @date 12:19 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/CatColors", produces = "application/json;charset=utf-8")
public class CatColorController  extends CURDController<CatColor, String, CatColorService> {
}
