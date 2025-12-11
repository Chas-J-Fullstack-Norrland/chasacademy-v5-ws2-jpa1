package se.chasacademy.databaser.wsjpa.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.wsjpa.blog.models.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostPostId(Long postId);

    List<Comment> findByPostPostIdAndFlagTrue(Long postId);

}
