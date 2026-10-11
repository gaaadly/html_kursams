# 01 · Konversijos ir temperatūra

**Tema:** Skaitinės konversijos

Užpildykite du pateiktus metodus. TemperatureConverter.toFahrenheit gauna sveiką Celsijaus temperatūrą intervale −100…100: apskaičiuokite C * 9.0 / 5 + 32 ir išveskite Farenheito reikšmę. ConversionReport.convert gauna measurement intervale −1000…1000, large intervale −100000000000…100000000000 ir char letter. Išveskite measurement konvertuotą į int, large konvertuotą į int, large išplatintą į float ir grąžintą į long bei sveikąjį letter kodą. Parametrus perduoda testai; main ir įvesties skaitymo nepridėkite.

Naudokite nuoseklius lokalių kintamųjų deklaravimo ir išraiškų sakinius be šakų ar ciklų. Kiekvieną išvedimo eilutę užbaikite println.

## Reikalavimai

- ConversionReport žingsniams ir išvedimui naudokite int truncated, int narrowed, float approximate, long recovered ir int code. Siaurindami aiškiai nurodykite konversiją; large→float ir char→int platinkite automatiškai.

TemperatureConverter: temperatureCelsius = 1.

```console
33.8
```

ConversionReport parametrai: measurement = −19.99, large = 100000000000L, letter = 'a'.

```console
Truncated: -19
Narrowed: 1215752192
Recovered: 99999997952
Code: 97
```
