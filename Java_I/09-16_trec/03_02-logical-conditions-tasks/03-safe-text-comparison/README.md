# 03 · Safe Text Comparison

**Topic:** Short-circuiting and String.equals

Complete the supplied `sameText` method. Return `true` only when `first` is not `null` and has the same text content as `second`. Use `&&` so the `.equals()` call is skipped when `first` is `null`. Do not use `==` to compare text content.

## Starting point

Edit only the body of `sameText` in `TextComparison.java`. The tests call this method directly; no console program is needed.

## Requirements

- Use `first != null && first.equals(second)`. Equivalent parenthesized formatting is allowed.

## Examples

```java
sameText(new String("Java"), new String("Java")) -> true
sameText("Java", "java") -> false
sameText(null, "Java") -> false
```
