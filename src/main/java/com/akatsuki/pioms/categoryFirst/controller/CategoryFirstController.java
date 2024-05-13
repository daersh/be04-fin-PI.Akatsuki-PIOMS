package com.akatsuki.pioms.categoryFirst.controller;


import com.akatsuki.pioms.categoryFirst.aggregate.CategoryFirst;
import com.akatsuki.pioms.categoryFirst.service.CategoryFirstService;
import com.akatsuki.pioms.categoryFirst.aggregate.RequestCategoryFirstPost;
import com.akatsuki.pioms.categoryFirst.aggregate.RequestCategoryFirstUpdate;
import com.akatsuki.pioms.categoryFirst.aggregate.ResponseCategoryFirstPost;
import com.akatsuki.pioms.categoryFirst.aggregate.ResponseCategoryFirstUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category/first")
@Tag(name = "카테고리(대) 조회 컨트롤러", description = "카테고리(대) 조회")
public class CategoryFirstController {

    private final CategoryFirstService categoryFirstService;

    @Autowired
    public CategoryFirstController(CategoryFirstService categoryFirstService) {
        this.categoryFirstService = categoryFirstService;
    }

    @GetMapping("")
    @Operation(summary = "카테고리(대) 전체 조회", description = "단순 카테고리(대) 조회 기능")
    public ResponseEntity<List<CategoryFirst>> getAllCategoryFirst() {
        return ResponseEntity.ok().body(categoryFirstService.getAllCategoryFirst());
    }

    @GetMapping("/{categoryFirstCode}")
    @Operation(summary = "카테고리(대) code로 카테고리(대) 하나 조회", description = "카테고리(대)코드로 카테고리(대) 하나 조회")
    public ResponseEntity<CategoryFirst> getCategoryFirstByCode(@PathVariable int categoryFirstCode) {
        return ResponseEntity.ok().body(categoryFirstService.findCategoryFirstByCode(categoryFirstCode));
    }

    @PostMapping("/post")
    public ResponseEntity<String> postCategoryFirst(@RequestBody RequestCategoryFirstPost request/*, int requesterAdminCode*/) {
        return categoryFirstService.postCategoryFirst(request/*, int requesterAdminCode*/);

    }

    @PostMapping("/update/{categoryFirstCode}")
    @Operation(summary = "카테고리(대) code로 카테고리(대) 수정" ,description = "update_date 자동 기입")
    public ResponseEntity<ResponseCategoryFirstUpdate> updateCategoryFirst(@PathVariable int categoryFirstCode, @RequestBody RequestCategoryFirstUpdate request/*, int requesterAdminCode*/) {
        ResponseCategoryFirstUpdate response = categoryFirstService.updateCategoryFirst(categoryFirstCode, request/*, int requesterAdminCode*/);
        return ResponseEntity.ok().body(response);
    }
}
