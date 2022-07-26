package com.oww.OhWoonWanBackend.dto.board;

import com.oww.OhWoonWanBackend.common.type.BoardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class RequestRegisterBoardDto {

    private String content;
    private Long accountId;
    private String nickname;
    private BoardType boardType;
    private List<MultipartFile> imageFileList;
}
