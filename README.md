# kotlin-learning

A daily learning log: writing Kotlin from scratch to build production muscle, with notes from a true Kotlin beginner working through the official Tour, JetBrains' Koans, and the Exercism Kotlin track.

## Why this repo exists

I'm a backend engineer learning Kotlin from zero. The goal is to write Kotlin confidently without an LLM — and to read LLM- or coworker-generated Kotlin with judgment, not just recognition. The format is short daily drills with visible commits, because consistency matters more than session length and the green-square graph is honest accountability.

## Structure

| Directory   | What lives here                                                                       |
| ----------- | ------------------------------------------------------------------------------------- |
| `tour/`     | Kotlin Tour exercises as `.kts` scripts, one file per chapter                         |
| `koans/`    | Solved Koan snippets, copied from the browser playground                              |
| `exercism/` | Exercism Kotlin track exercises (each download brings its own Gradle setup)           |
| `notes/`    | Concept notes in my own words after a Tour chapter, a tricky Koan, or a new pattern   |

## Rules of the game

1. **15 minutes minimum, daily.** Longer is fine; skipping is not.
2. **No LLM during drill time.** Tour, Koans, and Exercism are written from scratch with only official docs as reference. The compiler is the feedback loop. (Notes-writing and post-session review are LLM-allowed.)
3. **Every session ends with a meaningful commit.** Specific message describing what was learned or solved. No fake commits, no whitespace-only commits to fake the streak.

## Getting started

Week 1 is the [Kotlin Tour](https://kotlinlang.org/docs/kotlin-tour-welcome.html) — JetBrains' free guided tour for programmers new to Kotlin.

- Read each chapter in the browser
- For each chapter, create `tour/NN-chapter-name.kts` (e.g., `tour/01-hello-world.kts`)
- **Retype the examples** in IntelliJ. Don't paste. The typing is the practice.
- Solve the end-of-chapter exercises in the same file
- After each chapter, write `notes/tour-NN-chapter-name.md` with 3-5 bullets

Once the Tour is complete, switch the daily slot to [Kotlin Koans](https://play.kotlinlang.org/koans). Exercism comes after that.
