# Invariant

**A runtime system for enforcing invariants, detecting silent failures, and reconstructing system truth over time.**

---

## 📌 Overview

Modern backend systems fail in ways that traditional monitoring cannot detect. Services stay *green* while producing **incorrect data**, skipping critical side effects, or violating business rules silently. Logs and metrics show *activity*, not *correctness*.

**Invariant** is a runtime correctness platform designed to close this gap.

It continuously verifies system behavior against declared invariants, detects silent failures in real time, and reconstructs a **System Truth Timeline** — a precise, time-ordered account of what *actually happened* inside the system.

This is **not** a monitoring or logging tool.  
Invariant focuses on **semantic correctness**, not surface-level health.

---

## 🎯 Problem Statement

Backend systems commonly suffer from three systemic issues:

### 1. No Runtime Correctness Guarantees
- Code compiles
- Tests pass
- Services run

Yet **assumptions are never checked in production**.

### 2. Silent Failures
Failures that do not crash the system:
- Partial database writes
- Missed event publications
- Incorrect state transitions
- Business rule violations

These failures silently corrupt system behavior while dashboards remain green.

### 3. No Ground Truth Reconstruction
When something goes wrong:
- Logs are fragmented
- Events are scattered
- Causality is unclear

There is no single, authoritative timeline of truth.

---

## 🧠 Core Philosophy

Invariant is built on three principles:

- **Correctness is a first-class concern**
- **Failures must be detected, not inferred**
- **System truth must be reconstructable**

If a system cannot explain *what happened*, it cannot be trusted.

---

## 🧩 Core Pillars

### 1️⃣ Runtime Invariant Enforcement

Invariant allows defining **invariants** — conditions that must always hold true at runtime.

Examples:
- An order marked `COMPLETED` must have a successful payment
- Inventory count must never go negative
- Every emitted event must correspond to a committed state change

These invariants are evaluated **during execution**, not after failure.

---

### 2️⃣ Silent Failure Detection

Invariant detects failures where:
- Execution continues
- No exception is thrown
- Observability tools report healthy status

Detection includes:
- Missing side effects
- Partial state updates
- Event/state mismatches
- Logical inconsistencies

Failures are surfaced immediately with full context.

---

### 3️⃣ System Truth Timeline

Invariant constructs an immutable, time-ordered **System Truth Timeline** that captures:
- Events
- State transitions
- Invariant evaluations
- Violations and anomalies

This enables:
- Post-incident reconstruction
- Causal debugging
- Trustworthy audits

The timeline represents **what actually happened**, not what logs claim.

---

## 🧱 Core Components

### 🔹 Invariant Runtime
- Central execution engine
- Hooks into application lifecycle
- Evaluates invariants in real time

### 🔹 Invariant Guard
- Detects silent and partial failures
- Correlates state, events, and side effects

### 🔹 Invariant Chronicle
- Builds the System Truth Timeline
- Ensures immutability and ordering
- Enables forensic debugging

### 🔹 Invariant CLI (Supporting Project)
- Developer-facing debugging tool
- Query timelines and violations
- Local and production diagnostics

---

## 🛠️ Tech Stack

### Backend
- **Java 21**
- **Spring Boot**
- **Spring AOP** – runtime instrumentation
- **Spring Events**

### Data & Storage
- **PostgreSQL** – timeline persistence
- **MongoDB** (planned) – flexible event storage

### Messaging (Planned)
- **Apache Kafka** – event correlation and async analysis

### Tooling
- **Maven**
- **Docker**
- **Git & GitHub**

### Observability (Complementary)
- Logs & metrics used only as supporting signals
- Not relied upon for correctness

---

## 🚀 Scope (v1)

### Included
- Runtime invariant definition & evaluation
- Silent failure detection for state/event mismatches
- System Truth Timeline persistence
- Basic querying via CLI

### Deferred
- Distributed tracing integration
- Advanced causal graphs
- Cross-service invariant propagation
- Visualization UI

---

## 🧪 Use Cases

- Detecting incorrect but successful transactions
- Debugging production-only bugs
- Auditing system behavior
- Strengthening system design discussions
- Demonstrating deep backend engineering competence

---

## 🧠 Why Invariant Matters

Most projects prove you can **build software**.

Invariant proves you understand:
- System correctness
- Failure modes
- Observability limitations
- Production reality

This is the difference between *writing code* and *engineering systems*.

---

## 📍 Project Status

🟡 **Active Development**  
Currently focusing on:
- Core runtime engine
- Invariant evaluation model
- Timeline data model

---

## 👨‍💻 Author

**Sujal Patil**

[![GitHub](https://img.shields.io/badge/GitHub-SujalPatil21-blue)](https://github.com/SujalPatil21)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-SujalPatil-blue)](https://www.linkedin.com/in/sujalpatil)
[![Email](https://img.shields.io/badge/Email-sujalpatil21@gmail.com-blue)](mailto:sujalpatil21@gmail.com)

---

## 🔒 Final Note

Invariant is not a demo project.

It is a **long-term, evolving system** designed to showcase:
- Backend depth
- System-level thinking
- Engineering maturity

Everything added to this repository must strengthen **correctness, detection, or truth reconstruction**.  
Anything else does not belong.
