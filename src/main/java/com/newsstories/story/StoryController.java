package com.newsstories.story;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stories")
public class StoryController {

    @GetMapping("/")
    public List<Map> list() {
        return new ArrayList<>();
    }

}
