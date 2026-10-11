# 01 · Conversions and Temperature

**Topic:** Numeric conversions

Complete the two supplied methods. TemperatureConverter.toFahrenheit receives integer Celsius in −100…100: calculate C * 9.0 / 5 + 32 and print the Fahrenheit value. ConversionReport.convert receives measurement in −1000…1000, large in −100000000000…100000000000 and a char letter. Print measurement cast to int, large cast to int, large widened to float then cast back to long, and the integer code of letter. Tests supply parameters; do not add main or input reading.

Use straight-line local declarations and expression statements, without branches or loops. End each output line with println.

## Requirements

- In ConversionReport use int truncated, int narrowed, float approximate, long recovered and int code for these steps and output. Use explicit casts for narrowing and automatic widening for large→float and char→int.

TemperatureConverter: temperatureCelsius = 1.

```console
33.8
```

ConversionReport parameters: measurement = −19.99, large = 100000000000L, letter = 'a'.

```console
Truncated: -19
Narrowed: 1215752192
Recovered: 99999997952
Code: 97
```
