package com.oww.OhWoonWanBackend.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestListDto {

    private Long lastBoardId;
    private int page = 1;
    private int pageSize = 5;
    private int start = 0;

    public int getPage() {
        page = page - 1;
        if (page < 0) {
            page = 0;
        }
        return page;
    }

    public int getStart() {
        start = (page - 1) * pageSize;
        return start;
    }
}
