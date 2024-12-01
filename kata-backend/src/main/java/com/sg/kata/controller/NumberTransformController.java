package com.sg.kata.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.kata.service.NumberTransformService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Number Transformation", description = "API for FOO BAR QUIX transformations")
@CrossOrigin(origins = "http://localhost:4200")
public class NumberTransformController {

    private final Logger log = LoggerFactory.getLogger(NumberTransformController.class);
    private final NumberTransformService service;

    public NumberTransformController(NumberTransformService service) {
        this.service = service;
    }

    @Operation(summary = "Transform a number using FOO BAR QUIX string", description = "Transforms a number between 0 and 100 based on divisibility and digit rules")
    @ApiResponse(responseCode = "200", description = "Successful transformation", content = @Content(schema = @Schema(type = "string")))
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @GetMapping(value = "/transform/{number}", produces = "application/json")
    public ResponseEntity<TransformResult> transform(
            @Parameter(description = "Number to transform (0-100)") @PathVariable int number) {

        log.info("Received transformation request for number: {}", number);

        try {
            String result = service.transform(number);
            log.info("Transformed result: {}", result);
            return ResponseEntity.ok(new TransformResult(result));
        } catch (IllegalArgumentException e) {
            log.error("Validation error: {}", e.getMessage());
            return ResponseEntity.badRequest().body(new TransformResult(e.getMessage()));
        }
    }

}
