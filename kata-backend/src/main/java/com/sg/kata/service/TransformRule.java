package com.sg.kata.service;

import java.util.function.Predicate;

public record TransformRule(String result, Predicate<Integer> condition) {
    
}
