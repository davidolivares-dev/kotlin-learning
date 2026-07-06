# koans/

Solutions to Kotlin Koans — JetBrains' interactive practice exercises (~50 problems).

## Two ways to run them

- **IntelliJ EduTools plugin (recommended).** File → Learn and Teach → Browse Courses → "Kotlin Koans". Tests run inside the IDE, hints and theory built in. Same environment as your Tour work.
- **Browser playground** at [play.kotlinlang.org/koans](https://play.kotlinlang.org/koans). Simpler, no install, but no IDE-level tooling.

## Workflow

Whichever runtime you choose:

- Solve the Koan in EduTools or the browser
- Once tests pass, copy the solved code here, mirroring the course tree:
  `koans/<section>/<task>/<File>.kt` (e.g. `koans/introduction/hello-world/Task.kt`)
  - Section and task folders are kebab-cased (`Hello, world!` → `hello-world`)
  - Keep the course's real file name(s) — usually `Task.kt`, plus any extra
    files a multi-file task ships, with their original names
  - The `Task.kt` header carries a short comment with the task description
- The local files aren't run — they're a reference copy for grep, review, and the commit

## When to start

After completing the Kotlin Tour. Koans assume basic syntax fluency.
