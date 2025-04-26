package com.slimhealthy.slimhealthy_backend.application.controllers;

import com.slimhealthy.slimhealthy_backend.application.dto.MesuresDto;
import com.slimhealthy.slimhealthy_backend.application.services.MesuresService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mesures")
@RequiredArgsConstructor
public class MesuresController {
    private final MesuresService mesuresService;

    @PostMapping
    public ResponseEntity<?> createMesures(@Valid @RequestBody MesuresDto dto) {
        return ResponseEntity.ok(mesuresService.saveMesures(dto));
    }

    @PatchMapping
    public ResponseEntity<?> updateMesures(@Valid @RequestBody MesuresDto dto) {
        return ResponseEntity.ok(mesuresService.updateMesures(dto));
    }
}