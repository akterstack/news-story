package com.newsstories.story;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
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
            story.setPublishedDate(Date.from(Instant.now()));
        }
        return storyRepository.save(story);
    }

}
