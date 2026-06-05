# exercism/

Solutions for the [Exercism Kotlin track](https://exercism.org/tracks/kotlin) — community-mentored practice exercises with a CLI workflow.

## One-time setup

```
brew install exercism
exercism configure --token=<get-from-exercism.org/settings/api_cli>
```

## Per-exercise workflow

```
exercism download --exercise=<name> --track=kotlin
```

This creates a subdirectory under `exercism/` with the exercise's own Gradle setup, starter file, and tests. Solve, run tests locally, then submit:

```
exercism submit
```

Each downloaded exercise is self-contained — no root-level Gradle needed.

## When to start

After Tour and Koans, when you want longer-form problems and (optional) mentor review.
