# 04 · Different Types of Input

**Topic:** Typed input

Ask for a project name, source line count, execution time in milliseconds and compilation status, in that order. Print each prompt before its read and print all four results after reading. Preserve spaces in the project name. Numbers are in −1000…1000, decimals use a dot, and compilation status is true or false. Invalid numeric text may throw NumberFormatException; no recovery is needed.

Use straight-line local declarations and expression statements, without branches or loops. End each output line with println.

## Requirements

- Use String projectName, int sourceLines, double executionTimeMillis and boolean compilationSuccessful. Read with nextLine and parse with Integer.parseInt, Double.parseDouble and Boolean.parseBoolean. Boolean.parseBoolean converts the input text true/false to a boolean value.

Typed values: `HelloWorld`, `11`, `4.2`, `true`.

```console
Give project name:
HelloWorld
Give source line count:
11
Give execution time in milliseconds:
4.2
Is compilation successful:
true
Project name: HelloWorld
Source line count: 11
Execution time (ms): 4.2
Compilation successful: true
```
