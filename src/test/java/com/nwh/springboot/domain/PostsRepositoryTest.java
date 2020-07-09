package com.nwh.springboot.domain;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void posts_load_test() {
        String title = "제목";
        String content = "본문";

       postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("nwh0526@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is(title));
        assertThat(posts.getContent(), is(content));
        // assertThat(posts.getAuthor(), is("whnam@gmail.com"));
    }

    @Test
    public void baseTimeEntity_reigster() throws Exception {
        LocalDateTime now = LocalDateTime.of(2020, 7, 10, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("hello baseTime!")
                .content("jpa auditing test ~")
                .author("nam")
                .build());

        List<Posts> all = postsRepository.findAll();

        Posts posts  = all.get(0);

        System.out.println("post entity baseTime [ " +
                "createdDate : "
                + posts.getCreatedDate() +
                " , modifiedDate : "
                + posts.getModifiedDate());

        Assertions.assertThat(posts.getCreatedDate()).isAfter(now);
        Assertions.assertThat(posts.getModifiedDate()).isAfter(now);
    }

}