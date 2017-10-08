package com.newsstories.story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stories")
public class StoryController {

    private StoryRepository storyRepository;

    public StoryController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @GetMapping("/")
    public Page<Story> list(Pageable pageable) {
        return storyRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Story get(@PathVariable Long id) {
        return storyRepository.findOne(id);
    }

}
