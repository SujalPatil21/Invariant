package com.example.Invariant.controller;

import com.example.Invariant.core.Invariant;
import com.example.Invariant.core.InvariantContext;
import com.example.Invariant.core.InvariantResult;
import com.example.Invariant.core.impl.SimpleInvariantEvaluator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class InvariantController {

    public final SimpleInvariantEvaluator evaluator = new SimpleInvariantEvaluator();

    @PostMapping("/invariant/evaluate")
    public InvariantResult evaluate(@RequestBody Map<String , Object> data){

        InvariantContext context = new InvariantContext();
        context.setData(data);

        Invariant invariant = new Invariant();
        invariant.setId("amount-positive");
        invariant.setDescription("amount should be greater than zero");

        return evaluator.evaluate(invariant,context);
    }
}
