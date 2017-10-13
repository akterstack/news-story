package com.newsstories.story;

import com.newsstories.author.Author;
import com.newsstories.author.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;

@Service
public class StoryService {

    private StoryRepository storyRepository;
    private AuthorRepository authorRepository;

    public StoryService(StoryRepository storyRepository, AuthorRepository authorRepository) {
        this.storyRepository = storyRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Story save(Story story) {
        if (story.getPublishedDate() == null) {
            story.setPublishedDate(Date.from(Instant.now()));
        }
        Author author = authorRepository.findByFullName(story.getAuthor().getFullName());
        if (author != null) {
            story.setAuthor(author);
        }
        return storyRepository.save(story);
    }

}
