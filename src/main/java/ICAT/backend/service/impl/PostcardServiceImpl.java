package ICAT.backend.service.impl;

import ICAT.backend.dao.repository.PostcardRepository;
import ICAT.backend.pojo.Postcard;
import ICAT.backend.service.PostcardService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostcardServiceImpl extends CURDServiceImpl<Postcard, String, PostcardRepository> implements PostcardService {
    @Autowired PostcardRepository postcardRepository;

    @Override
    public List<Postcard> getAllPostcard(){
        return postcardRepository.getAllPostcard();
    }

    @Override
    public List<Integer> getYears(){
        return postcardRepository.getYears();
    }

    @Override
    public List<Postcard> getAllImageByYear(int year){
        return postcardRepository.getAllImageByYear(year);
    }

}
