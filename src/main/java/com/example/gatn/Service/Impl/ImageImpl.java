package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Image;
import com.example.gatn.Repositoris.ImageRepository;
import com.example.gatn.Service.ImageService;
import org.springframework.data.domain.Page;

import java.util.List;

public class ImageImpl implements ImageService {
    private ImageRepository imageRepository;
    @Override
    public List<Image> getByIdSp(Integer idsp) {
        return imageRepository.getByIdSp(idsp);
    }
}
