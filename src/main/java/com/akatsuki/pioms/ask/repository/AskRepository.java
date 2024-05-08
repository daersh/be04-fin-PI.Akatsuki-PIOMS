package com.akatsuki.pioms.ask.repository;

import com.akatsuki.pioms.ask.entity.AskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskRepository extends JpaRepository<AskEntity, Integer> {
    @Query("SELECT a FROM AskEntity a WHERE a.askStatus = '답변대기'")
    List<AskEntity> findAllByStatusWaitingForReply();

    List<AskEntity> findByFranchiseOwner_FranchiseOwnerCode(Integer franchiseOwnerCode);
}
