package com.sparta.memo.dto;

import com.sparta.memo.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    private Long id; //메모끼리 구분 위헤서 데이터베이스에 필수로 필요한 부분
    private String username;//메모 작성한 사람 이름
    private String contents;//메모에 대한 내용

    public MemoResponseDto(Memo memo) {
    }

    public MemoResponseDto(Long id, String username, String contents) {
        this.id = id;
        this.username = username;
        this.contents = contents;
    }
}