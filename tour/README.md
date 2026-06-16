# tour/

Exercises from the official [Kotlin Tour](https://kotlinlang.org/docs/kotlin-tour-welcome.html).

## Setup (one-time)

Install the Kotlin CLI so `.kts` scripts can run:

```
brew install kotlin
```

## Workflow

- One file per chapter under the relevant section folder: `<section>/NN-chapter-name.kts` (e.g., `beginner-kotlin-tour/01-hello-world.kts`)
- **First line of every file:** `#!/usr/bin/env kotlin` — this is what makes IntelliJ show the green run arrow (and lets the file run from the shell too)
- Write your code after the shebang. No `main()` needed — `.kts` runs top-to-bottom.
- In IntelliJ: click the green ▶ in the gutter, or right-click → Run
- **Retype the examples and exercises.** Don't paste from the browser. The typing is the practice.

## After each chapter

Write `notes/<section>/tour-NN-chapter-name.md` with 3-5 bullets:

- What surprised you
- What still feels shaky
- What you want to remember
