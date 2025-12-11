package se.chasacademy.databaser.wsjpa.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.chasacademy.databaser.wsjpa.blog.models.Comment;
import se.chasacademy.databaser.wsjpa.blog.models.Post;
import se.chasacademy.databaser.wsjpa.blog.repositories.CommentRepository;
import se.chasacademy.databaser.wsjpa.blog.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {
	private PostRepository postRepository;
    private CommentRepository commentRepository;

	public BlogApplication(PostRepository postRepository,CommentRepository commentRepository) {
		this.postRepository = postRepository;
        this.commentRepository = commentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (Post current : postRepository.findAll()) {
			System.out.println("title: "+current.getTitle()+" published at: "+current.getPublishDate());
		}

		Optional<Post> firstPost = postRepository.findById(1L);
		if (firstPost.isPresent()) {
			Post first = firstPost.get();
			System.out.println("title: " + first.getTitle() + " published at: " + first.getPublishDate());
		}

        Comment newComment = new Comment();
        newComment.setTitle("Program Finished");
        newComment.setComment_text("Ran it all");
        newComment.setCommentDate(LocalDateTime.now());
        newComment.setPost(firstPost.get());

        commentRepository.save(newComment);



	}
}
