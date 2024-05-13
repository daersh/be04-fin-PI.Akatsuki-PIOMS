package com.akatsuki.pioms.frowner.controller;

import com.akatsuki.pioms.frowner.aggregate.FranchiseOwner;
import com.akatsuki.pioms.frowner.dto.FranchiseOwnerDTO;
import com.akatsuki.pioms.frowner.service.FranchiseOwnerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/franchise/owner")
public class AdminOnlyFrOwnerController {

    private final FranchiseOwnerService franchiseOwnerService;

    @Autowired
    public AdminOnlyFrOwnerController(FranchiseOwnerService franchiseOwnerService) {
        this.franchiseOwnerService = franchiseOwnerService;
    }


    // 전체 조회
    @Operation(summary = "점주 전체 조회", description = "점주 전체 목록을 조회하며, 담당 점포와 관리자도 함께 조회합니다.")
    @GetMapping("/list")
    public ResponseEntity<List<FranchiseOwnerDTO>> getOwnerListWithFranchiseAndAdmin() {
        List<FranchiseOwnerDTO> ownerList = franchiseOwnerService.findAllFranchiseOwners();
        return ResponseEntity.ok(ownerList);
    }

    // 상세조회
    @Operation(summary = "프랜차이즈 점주 상세 조회", description = "프랜차이즈 점주 상세 조회")
    @GetMapping("/detail/{franchiseOwnerCode}")
    public ResponseEntity<FranchiseOwnerDTO> getFranchiseOwnerById(@PathVariable int franchiseOwnerCode) {
        return franchiseOwnerService.findFranchiseOwnerById(franchiseOwnerCode);
    }

    @Operation(summary = "프랜차이즈 점주 등록", description = "신규 프랜차이즈 점주를 등록합니다.")
    @PostMapping("/register")
    public ResponseEntity<String> registerFranchiseOwner(
            @RequestBody FranchiseOwner franchiseOwner,
            @RequestParam int requestorAdminCode
    ) {
        return franchiseOwnerService.registerFranchiseOwner(franchiseOwner, requestorAdminCode);
    }

}
