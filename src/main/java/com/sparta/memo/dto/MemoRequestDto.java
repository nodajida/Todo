package com.sparta.memo.dto;

import com.sparta.memo.entity.Memo;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class MemoRequestDto {
    private String username;
    private String contents;


    private final Map<Long, Memo> memoList = new HashMap<>();
    @PostMapping("/memos")
    public com.sparta.memo.dto.MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // Memo Max ID Check
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        // DB 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        com.sparta.memo.dto.MemoResponseDto memoResponseDto = new com.sparta.memo.dto.MemoResponseDto(memo);

        return memoResponseDto;
    }

    @GetMapping("/memos")
    public List<com.sparta.memo.dto.MemoResponseDto> getMemos() {
        // Map To List
        Object MemoResponseDto;
        List<com.sparta.memo.dto.MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();

        return responseList;
    }
}