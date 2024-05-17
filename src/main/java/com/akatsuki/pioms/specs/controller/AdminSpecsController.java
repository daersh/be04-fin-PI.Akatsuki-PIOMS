package com.akatsuki.pioms.specs.controller;

import com.akatsuki.pioms.specs.aggregate.ResponseSpecs;
import com.akatsuki.pioms.specs.dto.SpecsDTO;
import com.akatsuki.pioms.specs.service.SpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminSpecsController {
    private final SpecsService specsService;
    @Autowired
    public AdminSpecsController(SpecsService specsService) {
        this.specsService = specsService;
    }

    @GetMapping("/{adminCode}/specs")
    public ResponseEntity<List<ResponseSpecs>> getSpecsList(@PathVariable int adminCode){
        List<SpecsDTO> specsDTOS = specsService.getSpecsListByAdminCode(adminCode);

        if (specsDTOS.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        List<ResponseSpecs> responseSpecs = new ArrayList<>();
        specsDTOS.forEach( specsDTO -> {
            responseSpecs.add(new ResponseSpecs(specsDTO));
        });
        return ResponseEntity.ok(responseSpecs);
    }

    @GetMapping("/{adminCode}/specs/{specsCode}")
    public ResponseEntity<ResponseSpecs> getSpecs(@PathVariable int adminCode,@PathVariable int specsCode){
        SpecsDTO specsDTO = specsService.getSpecsByAdminCode(adminCode,specsCode);
        return ResponseEntity.ok(new ResponseSpecs(specsDTO));
    }
}
