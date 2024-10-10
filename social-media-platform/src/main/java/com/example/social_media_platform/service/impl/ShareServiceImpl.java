/*
package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.model.Share;
import com.example.social_media_platform.repository.ShareRepository;
import com.example.social_media_platform.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareRepository shareRepository;

    @Override
    public List<Share> findAll() {
        return shareRepository.findAll();
    }

    @Override
    public Optional<Share> findById(Long id) {
        return shareRepository.findById(id);
    }

    @Override
    public Share save(Share share) {
        return shareRepository.save(share);
    }

    @Override
    public void deleteById(Long id) {
        shareRepository.deleteById(id);
    }
}
*/
