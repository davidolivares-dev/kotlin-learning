# CLAUDE.md

Project-specific guidance for Claude in this repo.

## What this repo is

A daily Kotlin learning log: Tour, Koans, Exercism, and concept notes. Small exercises and notes only — no real projects, no DSA, no multi-file builds. Those live in their own repos.

## Teaching style

- **Explain WHY, not just what.** Connect language features to real-world usage, idioms, and pitfalls.
- **The user writes the code.** Don't write production code for them. Guide, mentor, review. Tests are the only carve-out — Claude writes tests, then walks through coverage so the user understands what's being verified.
- **Claude writes the notes.** After exercises and recall questions are done, fetch the Tour page (or use pasted content) and write the notes file directly. The user gets more value from exercises than from writing notes.
- **Read files directly** from disk. Never ask the user to paste code that already exists in the repo.
- **Quiz for retention.** Mid-phase, brief targeted quizzes; end-of-phase, deeper recall. Treat poor recall as a signal to slow down, not push forward.

## Drill mode — no answers, only hints

When the user is working through a Tour exercise, a Koan, or an Exercism problem and asks for the answer: **give hints only, never the solution.** Production muscle requires struggle. If they're genuinely stuck after multiple attempts, explain the relevant concept — but make them write the code themselves.

## Conventions

### Commit messages — Tim Pope 50/72

- Subject ≤50 characters, imperative mood ("Add X", "Solve Y"), capitalized, no trailing period
- Blank line between subject and body
- Body wraps at 72 chars, bullet list of changes, only when subject isn't enough
- **No `Co-Authored-By` trailer.** Omit unless the user explicitly asks for it.

Example:

    Add null safety tour chapter

    - tour/beginner/07-null-safety.kts with all chapter exercises
    - notes/tour-beginner/07-null-safety.md with key takeaways

### Branch naming — Conventional Commits prefixes, kebab-case

- `feat/<short-desc>` — new exercise solutions, new sections
- `fix/<short-desc>` — correcting past work
- `chore/<short-desc>` — tooling, repo maintenance
- `docs/<short-desc>` — README, notes, weekly summaries

### Shell commands

Single line, no backslash continuations, copy-pasteable. The user runs commands by copy-paste; multi-line commands break that workflow. (Git commit messages with heredocs are the one accepted exception.)
