package com.akatsuki.pioms.frowner.service;

import com.akatsuki.pioms.frowner.aggregate.FranchiseOwner;
import com.akatsuki.pioms.frowner.dto.FranchiseOwnerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FranchiseOwnerService {

    // 전체 조회
    List<FranchiseOwnerDTO> findAllFranchiseOwners();

    // 상세 조회
    ResponseEntity<FranchiseOwnerDTO> findFranchiseOwnerById(int franchiseOwnerCode);

    // 오너 등록
    ResponseEntity<String> registerFranchiseOwner(FranchiseOwnerDTO franchiseOwnerDTO, int requestorAdminCode);

    // 오너 수정
    ResponseEntity<String> updateFranchiseOwner(int franchiseOwnerCode, FranchiseOwnerDTO updatedFranchiseOwnerDTO, int requestorAdminCode);

    // 오너 삭제
    ResponseEntity<String> deleteFranchiseOwner(int franchiseOwnerCode, int requestorAdminCode);

}
