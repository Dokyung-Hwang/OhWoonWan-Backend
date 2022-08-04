package com.oww.OhWoonWanBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    private String photoName;

    private String photoPath;

    private String photoSize;

    @ManyToOne
    @JoinColumn(name = "board_of_id")
    private BoardOf boardOf;
}
