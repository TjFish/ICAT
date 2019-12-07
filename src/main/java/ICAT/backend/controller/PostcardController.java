package ICAT.backend.controller;

import ICAT.backend.pojo.Postcard;
import ICAT.backend.service.PostcardService;
import ICAT.backend.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/postcard",  produces = "application/json;charset=utf-8")
public class PostcardController {
    @Autowired
    SequenceService sequenceService;
    @Autowired
    PostcardService postcardService;

    @GetMapping(value = "/")
    public List<Postcard> getAllPostcard(){

    }
}
