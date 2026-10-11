# 03 · Atstumas ir Math patikra

**Tema:** Math metodai ir konstantos

Užpildykite dvi programas. PointDistance paprašo keturių double koordinačių intervale −1000…1000, kiekvieną kvietimą išvesdamas prieš skaitymą. Išveskite atstumą sqrt((x2−x1)² + (y2−y1)²). MathCalculator.calculate gauna value intervale 0…1000, sveikuosius first ir second intervale −1000…1000 bei radius intervale 0…1000. Išveskite value kvadratą ir kvadratinę šaknį, suapvalintą long reikšmę, mažesnį bei didesnį sveikąjį ir apskritimo plotą PI * radius². MathCalculator parametrus perduoda testai; jis įvesties neskaito.

Naudokite nuoseklius lokalių kintamųjų deklaravimo ir išraiškų sakinius be šakų ar ciklų. Kiekvieną išvedimo eilutę užbaikite println.

## Reikalavimai

- PointDistance skaito su nextLine ir Double.parseDouble bei naudoja Math.sqrt; kvadratui tinka daugyba arba Math.pow. MathCalculator turi naudoti Math.pow, Math.sqrt, Math.round, Math.min, Math.max ir Math.PI. Java ^ nėra kėlimas laipsniu.

Įvedamos reikšmės: `1.5`, `-3.4`, `4`, `5`.

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
