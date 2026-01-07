package com.example.Invariant.controller;

import com.example.Invariant.core.Invariant;
import com.example.Invariant.core.InvariantContext;
import com.example.Invariant.core.InvariantResult;
import com.example.Invariant.core.impl.SimpleInvariantEvaluator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class InvariantController {

    private final SimpleInvariantEvaluator evaluator;

    public InvariantController(SimpleInvariantEvaluator evaluator) {

        this.evaluator = evaluator;
    }

    @PostMapping("/invariant/evaluate")
    public List<InvariantResult> evaluate(@RequestBody Map<String, Object> data) {

        // 1. Build context
        InvariantContext context = new InvariantContext();
        context.setData(data);

        // 2. Define invariants
        List<Invariant> invariants = new ArrayList<>();

        Invariant inv1 = new Invariant();
        inv1.setId("amount-positive");
        inv1.setDescription("amount should be greater than zero");
        invariants.add(inv1);

        Invariant inv2 = new Invariant();
        inv2.setId("amount-less-than-100");
        inv2.setDescription("amount should be less than 100");
        invariants.add(inv2);

        // 3. Delegate to engine
        return evaluator.evaluateAll(invariants, context);
    }
}
