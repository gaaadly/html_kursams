# 04 · Number Stream Report

**Topic:** Sentinel loop and accumulators

Repeatedly print `Give a number:` and read whole numbers until `0`. Do not include the zero. Then print the number count, sum, average, negative count, maximum, positive-number average, even count, and odd count in the shown order. If no average or maximum can be calculated, print the shown text instead.

## Requirements

- Use a `while` loop and an unlabeled `break`. Calculate the report while reading; do not store all inputs.

Values entered after prompts are typed by the user.

```console
Give a number:
5
Give a number:
2
Give a number:
-3
Give a number:
0
Numbers: 3
Sum: 4
Average: 1.3333333333333333
Negative: 1
Maximum: 5
Positive average: 3.5
Even: 1
Odd: 2
```

```console
Give a number:
0
Numbers: 0
Sum: 0
Average: cannot calculate
Negative: 0
Maximum: no numbers
Positive average: cannot calculate
Even: 0
Odd: 0
```
