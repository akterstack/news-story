package com.newsstories.author;


import com.newsstories.story.Story;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String fullName;

    @OneToMany(mappedBy = "author")
    private Collection<Story> stories;

    public Author() {}

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
