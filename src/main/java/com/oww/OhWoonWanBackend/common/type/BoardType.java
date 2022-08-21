package com.oww.OhWoonWanBackend.common.type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BoardType {
    
    OWW("오운완 게시판"),
    MS("식단공유 게시판");

    private String value;
}
