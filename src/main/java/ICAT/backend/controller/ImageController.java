package ICAT.backend.controller;

import ICAT.backend.pojo.Image;
import ICAT.backend.pojo.Postcard;
import ICAT.backend.service.ImageService;
import ICAT.backend.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping(value = "/api/Images", produces = "application/json;charset=utf-8")
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<Image> getAllImages(){
        return imageService.getAllImage();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Image getImageById(@PathVariable String id){
        return imageService.getImageById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public Integer updateImage(@PathVariable String id, @RequestBody Image image){
        return imageService.updateImage(image,id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Image deleteImage(@PathVariable String id){
        return imageService.deleteImage(id);
    }

    @PostMapping(value = "/uploadApplyToCatImage")
    @ResponseBody
    public Image uploadApplyToCatImage(HttpServletRequest req, @RequestParam MultipartFile file,@RequestParam String catID, @RequestParam String userAccount){
        return imageService.uploadApplyToCatImage(req,file,catID,userAccount);
    }

    @PostMapping(value = "/uploadActivityCover")
    @ResponseBody
    public Image uploadActivityCover(@RequestParam MultipartFile file, @RequestParam String activityID, HttpServletRequest req){
        return imageService.uploadActivityCover(req, file,activityID);
    }

    @PostMapping(value = "/uploadCatImage")
    @ResponseBody
    public Image uploadCatImage(@RequestParam MultipartFile file,@RequestParam String catID,@RequestParam Integer option,HttpServletRequest req)
    {
        return imageService.uploadCatImage(req,file,catID,option);
    }

    @PostMapping(value = "/uploadPostcard")
    @ResponseBody
    public Postcard uploadPostcard(HttpServletRequest req, @RequestParam MultipartFile file, @RequestParam Integer produceYear){
        return imageService.uploadPostcard(req,file,produceYear);
    }

    @PostMapping(value = "/uploadUserHead")
    @ResponseBody
    public Image uploadUserImage(HttpServletRequest req, @RequestParam MultipartFile file, @RequestParam String userID){
        return imageService.uploadUserHead(req,file,userID);
    }

    @PostMapping(value = "/uploadAdminHead")
    public Image uploadAdminHead(HttpServletRequest req,@RequestParam MultipartFile file,@RequestParam String adminID){
        return imageService.uploadAdminHead(req,file,adminID);
    }
}
