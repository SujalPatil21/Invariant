package com.example.Invariant.core;

public class InvariantResult {

    private String invariantId;
    private boolean satisfied;
    private String failureReason;
    private long evaluatedAt;

    public String getInvariantId() {
        return invariantId;
    }

    public boolean isSatisfied() {
        return satisfied;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public long getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setInvariantId(String invariantId) {
        this.invariantId = invariantId;
    }

    public void setSatisfied(boolean satisfied) {
        this.satisfied = satisfied;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public void setEvaluatedAt(long evaulatedAt) {
        this.evaluatedAt = evaulatedAt;
    }
}
