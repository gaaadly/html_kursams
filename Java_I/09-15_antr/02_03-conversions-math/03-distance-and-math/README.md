# 03 · Distance and Math Checks

**Topic:** Math methods and constants

Complete two programs. PointDistance asks for four double coordinates in −1000…1000, printing each prompt before reading. Print the distance sqrt((x2−x1)² + (y2−y1)²). MathCalculator.calculate receives value in 0…1000, integers first and second in −1000…1000, and radius in 0…1000. Print the square and square root of value, its rounded long value, the smaller and larger integer, and the circle area PI * radius². Tests supply the MathCalculator parameters; it does not read input.

Use straight-line local declarations and expression statements, without branches or loops. End each output line with println.

## Requirements

- PointDistance reads with nextLine and Double.parseDouble and uses Math.sqrt; squaring may use multiplication or Math.pow. MathCalculator must use Math.pow, Math.sqrt, Math.round, Math.min, Math.max and Math.PI. Java ^ is not exponentiation.

Typed values: `1.5`, `-3.4`, `4`, `5`.

```console
Enter x1:
1.5
Enter y1:
-3.4
Enter x2:
4
Enter y2:
5
The distance between the two points is 8.764131445842194
```

MathCalculator: value = 3.6, first = −4, second = 7, radius = 2.0.

```console
Square: 12.96
Root: 1.8973665961010275
Rounded: 4
Smaller: -4
Larger: 7
Area: 12.566370614359172
```
