# 02 · Find the Number of Years

**Topic:** Division, remainder and constants

Ask for whole minutes in 0…10000000000 and print full years and remaining full days. Assume a 24-hour day and a 365-day year. Discard minutes shorter than a full day. Keep the words years and days unchanged even for 1.

Use straight-line local declarations and expression statements, without branches or loops. End each output line with println.

## Requirements

- Use long minutes = Long.parseLong(scanner.nextLine()) for input. Long.parseLong is the long counterpart of Integer.parseInt. Declare and use final long MINUTES_PER_DAY and final long DAYS_PER_YEAR, and calculate with long arithmetic.

Typed values: `1000000000`.

```console
Enter the number of minutes:
1000000000
1000000000 minutes is approximately 1902 years and 214 days
```
