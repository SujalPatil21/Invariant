package com.example.Invariant.core;

import java.util.List;

public interface InvariantEvaluator {

    List<InvariantResult> evaluateAll(
            List<Invariant> invariants,
            InvariantContext context
    );
}
