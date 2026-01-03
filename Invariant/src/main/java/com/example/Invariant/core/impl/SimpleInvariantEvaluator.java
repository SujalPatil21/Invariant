package com.example.Invariant.core.impl;

import com.example.Invariant.core.Invariant;
import com.example.Invariant.core.InvariantContext;
import com.example.Invariant.core.InvariantEvaluator;
import com.example.Invariant.core.InvariantResult;

import java.util.ArrayList;
import java.util.List;

public class SimpleInvariantEvaluator implements InvariantEvaluator {

    @Override
    public List<InvariantResult> evaluateAll(
            List<Invariant> invariants,
            InvariantContext context
    ) {

        List<InvariantResult> results = new ArrayList<>();

        for (Invariant invariant : invariants) {

            InvariantResult result = new InvariantResult();
            result.setInvariantId(invariant.getId());
            result.setEvaluatedAt(System.currentTimeMillis());

            Object value = context.getData().get("amount");

            // Case 1: missing key
            if (value == null) {
                result.setSatisfied(false);
                result.setFailureReason("required key 'amount' missing");
                results.add(result);
                continue;
            }

            // Case 2: wrong type
            if (!(value instanceof Integer)) {
                result.setSatisfied(false);
                result.setFailureReason("invalid type for key 'amount'");
                results.add(result);
                continue;
            }

            int amount = (Integer) value;

            // Invariant-specific rules
            switch (invariant.getId()) {

                case "amount-positive":
                    if (amount > 0) {
                        result.setSatisfied(true);
                    } else {
                        result.setSatisfied(false);
                        result.setFailureReason("amount must be greater than 0");
                    }
                    break;

                case "amount-less-than-100":
                    if (amount < 100) {
                        result.setSatisfied(true);
                    } else {
                        result.setSatisfied(false);
                        result.setFailureReason("amount must be less than 100");
                    }
                    break;

                default:
                    result.setSatisfied(false);
                    result.setFailureReason("unknown invariant");
            }

            results.add(result);
        }

        return results;
    }
}
