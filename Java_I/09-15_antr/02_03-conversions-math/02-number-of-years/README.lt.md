# 02 · Metų skaičius

**Tema:** Dalyba, liekana ir konstantos

Paprašykite sveikojo minučių skaičiaus intervale 0…10000000000 ir išveskite pilnus metus bei likusias pilnas dienas. Laikykite, kad diena turi 24 valandas, metai – 365 dienas. Nepilnos dienos minutes atmeskite. Žodžiai years ir days nesikeičia net kai reikšmė 1.

Naudokite nuoseklius lokalių kintamųjų deklaravimo ir išraiškų sakinius be šakų ar ciklų. Kiekvieną išvedimo eilutę užbaikite println.

## Reikalavimai

- Įvestį skaitykite long minutes = Long.parseLong(scanner.nextLine()). Long.parseLong – Integer.parseInt atitikmuo long tipui. Deklaruokite ir naudokite final long MINUTES_PER_DAY ir final long DAYS_PER_YEAR, skaičiuokite su long.

Įvedamos reikšmės: `1000000000`.

```console
Enter the number of minutes:
1000000000
1000000000 minutes is approximately 1902 years and 214 days
```
