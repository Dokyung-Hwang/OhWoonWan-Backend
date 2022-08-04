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
public class LikeOf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_of_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_of_id")
    private BoardOf boardOf;
}
