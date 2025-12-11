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
    private String comment;
@Column(name = "comment_date", insertable = false, updatable = false)
    private LocalDateTime commentDate;
}
