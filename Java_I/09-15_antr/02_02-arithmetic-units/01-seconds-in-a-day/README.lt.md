# 01 · Sekundės per dieną

**Tema:** Konstantos ir aritmetika

Paprašykite sveikojo dienų skaičiaus intervale 0…1000000 ir išveskite sekundžių skaičių. Diena turi 24 valandas, valanda – 60 minučių, minutė – 60 sekundžių. Skaičiuokite su long, kad dideli rezultatai išliktų teisingi.

Naudokite nuoseklius lokalių kintamųjų deklaravimo ir išraiškų sakinius be šakų ar ciklų. Kiekvieną išvedimo eilutę užbaikite println.

## Reikalavimai

- Su nextLine ir Integer.parseInt perskaitykite int days. Deklaruokite ir naudokite final long HOURS_PER_DAY = 24L, final int MINUTES_PER_HOUR = 60 ir final int SECONDS_PER_MINUTE = 60. Rezultatą saugokite long seconds.

Įvedamos reikšmės: `30000`.

```console
How many days would you like to convert to seconds?
30000
2592000000
```
