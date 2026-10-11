# 03 · Integer and Double Input

**Topic:** Numeric input

Ask for a source line count and an execution time in milliseconds, each in −1000…1000. Print each prompt before reading its line, then print both parsed values. Decimal input uses a dot; 3.140 is printed as the value 3.14. Invalid numeric text may stop the program with NumberFormatException; do not add recovery logic.

Use straight-line local declarations and expression statements, without branches or loops. End each output line with println.

## Requirements

- Use nextLine, Integer.parseInt and Double.parseDouble; store the values in int sourceLines and double executionTimeMillis.

Typed values: `8`, `3.140`.

```console
Give source line count:
8
Give execution time in milliseconds:
3.140
Source line count: 8
Execution time (ms): 3.14
```
