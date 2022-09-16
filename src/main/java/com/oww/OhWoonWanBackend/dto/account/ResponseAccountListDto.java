package com.oww.OhWoonWanBackend.dto.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;


@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class ResponseAccountListDto {

    private List<ResponseAccountDto> accountDtoList;
}
