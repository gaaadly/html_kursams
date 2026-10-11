# 04 · Skirtingų tipų įvestis

**Tema:** Skirtingų tipų įvestis

Šia tvarka paprašykite projekto pavadinimo, išeities eilučių skaičiaus, vykdymo laiko milisekundėmis ir kompiliavimo būsenos. Kiekvieną kvietimą išveskite prieš skaitymą, visus keturis rezultatus – perskaitę įvestis. Išsaugokite tarpus projekto pavadinime. Skaičiai yra intervale −1000…1000, trupmenai naudojamas taškas, kompiliavimo būsena – true arba false. Netinkamas skaitinis tekstas gali sukelti NumberFormatException; klaidų apdoroti nereikia.

Naudokite nuoseklius lokalių kintamųjų deklaravimo ir išraiškų sakinius be šakų ar ciklų. Kiekvieną išvedimo eilutę užbaikite println.

## Reikalavimai

- Naudokite String projectName, int sourceLines, double executionTimeMillis ir boolean compilationSuccessful. Skaitykite su nextLine, konvertuokite Integer.parseInt, Double.parseDouble ir Boolean.parseBoolean. Boolean.parseBoolean įvesties tekstą true/false paverčia boolean reikšme.

Įvedamos reikšmės: `HelloWorld`, `11`, `4.2`, `true`.

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
