package ICAT.backend.service.impl;

import ICAT.backend.dao.mapper.PostcardMapper;
import ICAT.backend.pojo.Postcard;
import ICAT.backend.service.PostcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostcardServiceImpl implements PostcardService {
    @Autowired
    PostcardMapper postcardMapper;

    @Override
    public List<Postcard> getAllPostcards(){
        return postcardMapper.getAllPostcards();
    }

    @Override
    public Postcard getPostcardById(String id){
        return postcardMapper.getPostcardById(id);
    }

    @Override
    public int updatePostcard(Postcard postcard){
        return postcardMapper.updatePostcard(postcard);
    }

    @Override
    public int deletePostcard(String id){
        return postcardMapper.deletePostcard(id);
    }

    @Override
    public List<Integer> getYears(){
        return postcardMapper.getYears();
    }

    @Override
    public List<Postcard> getPostcardByYear(Integer year){
        return postcardMapper.getPostcardByYear(year);
    }


}
