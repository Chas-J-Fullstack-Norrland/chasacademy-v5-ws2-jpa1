package se.chasacademy.databaser.wsjpa.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.chasacademy.databaser.wsjpa.blog.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByPublishDateDesc();

    @Query("SELECT p FROM Post p WHERE p.postId NOT IN (SELECT c.post.postId FROM Comment c WHERE c.flag = true)")
    List<Post> findAllSafePosts();

}
