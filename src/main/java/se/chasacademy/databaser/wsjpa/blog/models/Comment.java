package se.chasacademy.databaser.wsjpa.blog.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "comment")
public class Comment {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
@ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
@Column(name = "flag", nullable = false)
    private boolean flag = false;
@Column(name = "title", length = 64, nullable = false)
    private String title;
@Column(name = "comment", nullable = false, columnDefinition = "text")
    private String comment_text;
@Column(name = "comment_date", insertable = false, updatable = false)
    private LocalDateTime commentDate;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }
}
