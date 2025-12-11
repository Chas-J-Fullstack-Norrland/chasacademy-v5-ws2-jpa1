package se.chasacademy.databaser.wsjpa.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.chasacademy.databaser.wsjpa.blog.models.Post;
import se.chasacademy.databaser.wsjpa.blog.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {
	private PostRepository postRepository;

	public BlogApplication(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        //Create posts
        Post bootupPost = new Post("Bootup complete","System has booted up","System");
        System.out.println(bootupPost.getPostId());
        postRepository.save(bootupPost);


		for (Post current : postRepository.findAll()) {
			System.out.println("title: "+current.getTitle()+" published at: "+current.getPublishDate());
		}

		Optional<Post> firstPost = postRepository.findById(1L);
		if (firstPost.isPresent()) {
			Post first = firstPost.get();
			System.out.println("title: " + first.getTitle() + " published at: " + first.getPublishDate());
		}






	}
}
