package ICAT.backend.controller;

import ICAT.backend.pojo.Postcard;
import ICAT.backend.service.PostcardService;
import ICAT.backend.service.SequenceService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping(value = "/postcard",  produces = "application/json;charset=utf-8")
public class PostcardController {
    @Autowired
    PostcardService postcardService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<Postcard> getAllPostcard(){
        return postcardService.getAllPostcards();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Postcard getPostcardById(@PathVariable String id){
        return postcardService.getPostcardById(id);
    }

    @PutMapping(value = "/")
    public int updatePostcard(@RequestBody Postcard postcard){
        return postcardService.updatePostcard(postcard);
    }

    @DeleteMapping(value = "/{id}")
    public int deletePostcard(@PathVariable String id){
        return postcardService.deletePostcard(id);
    }

    @GetMapping(value = "/Years")
    @ResponseBody
    public List<Integer> getYears(){
        return postcardService.getYears();
    }

    @GetMapping(value = "/OneYear")
    @ResponseBody
    public List<Postcard> getPostcardByYear(@RequestParam Integer year){
        return postcardService.getPostcardByYear(year);
    }
}
