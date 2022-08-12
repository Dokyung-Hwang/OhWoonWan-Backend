package com.oww.OhWoonWanBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    private String photoName;

    private String photoPath;

    private String photoSize;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
