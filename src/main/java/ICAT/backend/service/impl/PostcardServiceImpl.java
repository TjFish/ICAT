package ICAT.backend.service.impl;

import ICAT.backend.dao.mapper.PostcardMapper;
import ICAT.backend.dao.repository.PostcardRepository;
import ICAT.backend.pojo.Postcard;
import ICAT.backend.service.PostcardService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public List<Postcard> getPostcardByYear(String year){
        return postcardMapper.getPostcardByYear(year);
    }


}
