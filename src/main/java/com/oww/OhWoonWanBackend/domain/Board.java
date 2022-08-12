package com.oww.OhWoonWanBackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oww.OhWoonWanBackend.common.type.BoardType;
import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.domain.Comment;
import com.oww.OhWoonWanBackend.domain.Likes;
import com.oww.OhWoonWanBackend.domain.Photo;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "ENUM('OWW', 'MS')")
    private BoardType boardType;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Likes> likesList;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Photo> photoList;
}
