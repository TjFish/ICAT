package ICAT.backend.controller;

import ICAT.backend.pojo.Postcard;
import ICAT.backend.service.PostcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api/Postcards",  produces = "application/json;charset=utf-8")
public class PostcardController {
    @Autowired
    PostcardService postcardService;

    @GetMapping(value = "")
    public List<Postcard> getAllPostcard(){
        return postcardService.getAllPostcards();
    }

    @GetMapping(value = "/{id}")
    public Postcard getPostcardById(@PathVariable String id){
        return postcardService.getPostcardById(id);
    }

    @PutMapping(value = "")
    public int updatePostcard(@RequestBody Postcard postcard){
        return postcardService.updatePostcard(postcard);
    }

    @DeleteMapping(value = "/{id}")
    public int deletePostcard(@PathVariable String id){
        return postcardService.deletePostcard(id);
    }

    @GetMapping(value = "/Years")
    public List<Integer> getYears(){
        return postcardService.getYears();
    }

    @GetMapping(value = "/OneYear")
    public List<Postcard> getPostcardByYear(@RequestParam Integer year){
        return postcardService.getPostcardByYear(year);
    }
}
