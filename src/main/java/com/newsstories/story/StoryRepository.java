package com.newsstories.story;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends PagingAndSortingRepository<Story, Long> {
}
