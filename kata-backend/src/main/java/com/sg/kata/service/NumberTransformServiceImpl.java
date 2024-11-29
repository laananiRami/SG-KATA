package com.sg.kata.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NumberTransformServiceImpl implements NumberTransformService {
     
    //private final List<TransformRule> rules;
    private final List<TransformRule> divisibilityRules;
    private final List<TransformRule> containsRules;

    public NumberTransformServiceImpl() {

        divisibilityRules = List.of(
            new TransformRule("FOO", num -> num % 3 == 0),
            new TransformRule("BAR", num -> num % 5 == 0)
        );

        // Règles de contenance (appliquées pour chaque occurrence)
        containsRules = List.of(
            new TransformRule("FOO", this::containsThree),
            new TransformRule("BAR", this::containsFive),
            new TransformRule("QUIX", this::containsSeven)
        );
    }

    @Override
    public String transform(int number) {
        if (number < 0 || number > 100) {
            throw new IllegalArgumentException("Le nombre doit être entre 0 et 100");
        }
        
        StringBuilder result = new StringBuilder();

        // Appliquer d'abord les règles de divisibilité
        divisibilityRules.stream()
            .filter(rule -> rule.condition().test(number))
            .map(TransformRule::result)
            .forEach(result::append);

        // Ensuite appliquer les règles de contenance pour chaque chiffre
        String numberStr = String.valueOf(number);
        for (char digit : numberStr.toCharArray()) {
            for (TransformRule rule : containsRules) {
                if (rule.condition().test(Character.getNumericValue(digit))) {
                    result.append(rule.result());
                }
            }
        }

        return result.length() > 0 ? result.toString() : String.valueOf(number);
    }

    private boolean containsThree(int digit) {
        return digit == 3;
    }

    private boolean containsFive(int digit) {
        return digit == 5;
    }

    private boolean containsSeven(int digit) {
        return digit == 7;
    }
}
