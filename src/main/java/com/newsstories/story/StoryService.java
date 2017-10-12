package com.newsstories.story;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class StoryService {

    private StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Transactional
    public Story save(Story story) {
        if (story.getPublishedDate() == null) {
            story.setPublishedDate(new Date());
        }
        return storyRepository.save(story);
    }

}
