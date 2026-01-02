package com.example.Invariant.core.impl;

import com.example.Invariant.core.Invariant;
import com.example.Invariant.core.InvariantContext;
import com.example.Invariant.core.InvariantEvaluator;
import com.example.Invariant.core.InvariantResult;
import org.springframework.web.bind.annotation.PostMapping;


public class SimpleInvariantEvaluator implements InvariantEvaluator {


    @Override
    public InvariantResult evaluate(Invariant invariant, InvariantContext context) {

        Object value = context.getData().get("amount");

        boolean satisfied;
        String failureReason = null;

        if (value instanceof Integer && (Integer) value > 0) {
            satisfied = true;
        } else {
            satisfied = false;
            failureReason = "amount must be greater than 0";
        }

        InvariantResult result = new InvariantResult();
        result.setInvariantId(invariant.getId());
        result.setSatisfied(satisfied);
        result.setFailureReason(failureReason);
        result.setEvaluatedAt(System.currentTimeMillis());

        return result;
    }
}
