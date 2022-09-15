package com.oww.OhWoonWanBackend.dto.common;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ResponseListDto {

    private Long totalCount;
    private int pageSize;
    private int page;
}
