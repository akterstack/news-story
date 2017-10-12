package com.newsstories.story;

import com.newsstories.author.Author;
import com.newsstories.author.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Date;

@RestController
@RequestMapping("/api/stories")
public class StoryController {

    private StoryRepository storyRepository;
    private AuthorRepository authorRepository;

    public StoryController(StoryRepository storyRepository, AuthorRepository authorRepository) {
        this.storyRepository = storyRepository;
        this.authorRepository = authorRepository;
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
        if (story.getPublishedDate() == null) {
            story.setPublishedDate(new Date());
        }
        return storyRepository.save(story);
    }

}
