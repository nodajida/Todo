package com.sparta.memo.entity;

import com.sparta.memo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class Memo {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt; // 작성일
    private LocalDateTime updatedAt; // 수정일

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.createdAt = LocalDateTime.now(); // 작성일을 현재 시간으로 설정
        this.updatedAt = this.createdAt;      // 수정일은 작성일과 동일하게 설정
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.updatedAt = LocalDateTime.now(); // 수정일을 현재 시간으로 업데이트
    }
}