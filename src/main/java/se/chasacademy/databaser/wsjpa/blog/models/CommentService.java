package se.chasacademy.databaser.wsjpa.blog.models;
import org.springframework.stereotype.Service;
import se.chasacademy.databaser.wsjpa.blog.repositories.CommentRepository;
import se.chasacademy.databaser.wsjpa.blog.repositories.PostRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    public Comment addCommentToPost(Long postId, String title, String commentText) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + postId));
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setTitle(title);
        comment.setComment(commentText);
        return commentRepository.save(comment);
    }
}
