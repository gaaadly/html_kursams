# 01 · Įėjimo taisyklės

**Tema:** NOT, AND, OR ir grupavimas

Paprašykite įvesti amžių ir tris logines reikšmes: ar žmogus turi bilietą, yra VIP ir yra užblokuotas. Įeiti galima tik neužblokuotam žmogui, kuris yra arba pilnametis su bilietu, arba VIP. Pilnametis yra bent 18 metų. Į loginius klausimus įvedama `true` arba `false` mažosiomis raidėmis.

## Reikalavimai

- Taisyklę saugokite `boolean allowed` kintamajame, naudodami `!`, `&&`, `||` ir skliaustus.

Reikšmes po kvietimų įveda naudotojas.

```console
Give age:
17
Has ticket:
false
Is VIP:
true
Is blocked:
false
Entry allowed.
```

```console
Give age:
30
Has ticket:
true
Is VIP:
false
Is blocked:
true
Entry denied.
```
