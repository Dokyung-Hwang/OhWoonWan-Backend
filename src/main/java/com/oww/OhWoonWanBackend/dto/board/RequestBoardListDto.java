package com.oww.OhWoonWanBackend.dto.board;

import com.oww.OhWoonWanBackend.dto.common.RequestListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBoardListDto extends RequestListDto {

    private String boardType;
}
