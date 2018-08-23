package top.cmoon.micoservice.blog.blogservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "visit_count")
    private Long visitCount;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_deleted")
    private Integer isDeleted;

    @Column(name = "is_disabled")
    private Integer isDisabled;

}
