package com.oww.OhWoonWanBackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oww.OhWoonWanBackend.common.type.BoardType;
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
public class BoardOf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_of_id")
    private Long id;

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

    @OneToMany(mappedBy = "boardOf", cascade = CascadeType.REMOVE)
    private List<CommentOf> commentOfList;

    @OneToMany(mappedBy = "boardOf", cascade = CascadeType.REMOVE)
    private List<LikeOf> likeOfList;

    @OneToMany(mappedBy = "boardOf", cascade = CascadeType.REMOVE)
    private List<Photo> photoList;
}
