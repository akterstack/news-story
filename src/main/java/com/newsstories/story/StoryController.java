package com.newsstories.story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/stories")
public class StoryController {

    private StoryService storyService;
    private StoryRepository storyRepository;

    public StoryController(StoryService storyService, StoryRepository storyRepository) {
        this.storyService = storyService;
        this.storyRepository = storyRepository;
    }

    @GetMapping
    public Page<Story> list(Pageable pageable) {
        return storyRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Story get(@PathVariable Long id) {
        return storyRepository.findOne(id);
    }

    @PostMapping
    @Transactional
    public Story createStory(@RequestBody Story story) {
        return storyService.save(story);
    }

}
