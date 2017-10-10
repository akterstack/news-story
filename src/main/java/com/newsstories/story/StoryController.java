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

    @PostMapping("/")
    public Story createStory(@RequestBody StoryParam storyParam) {
        Author author = authorRepository.findByFullName(storyParam.getAuthor());
        if (author == null) {
            author = authorRepository.save(new Author(storyParam.getAuthor()));
        }
        Story story = new Story();
        story.setTitle(storyParam.getTitle());
        story.setBody(storyParam.getBody());
        story.setAuthor(author);
        return storyRepository.save(story);
    }

}
