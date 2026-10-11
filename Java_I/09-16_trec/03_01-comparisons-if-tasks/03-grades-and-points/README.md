# 03 · Grades and Points

**Topic:** Ordered else-if boundaries

Ask for a whole-number score and print its grade. Scores below 0 are `impossible!`; 0-49 are `failed`; 50-59 are `1`; 60-69 are `2`; 70-79 are `3`; 80-89 are `4`; 90-100 are `5`; and scores above 100 are `incredible!`. Check the more specific high boundary before broader lower boundaries.

## Requirements

- Use one ordered `if` / `else if` / `else` chain.

Values entered after prompts are typed by the user.

```console
Give points:
49
Grade: failed
```

```console
Give points:
100
Grade: 5
```

```console
Give points:
101
Grade: incredible!
```
