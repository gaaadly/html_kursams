# 03 · Saugus teksto palyginimas

**Tema:** Trumpasis jungimas ir String.equals

Užbaikite pateiktą `sameText` metodą. Grąžinkite `true` tik tada, kai `first` nėra `null` ir jo teksto turinys sutampa su `second`. Naudokite `&&`, kad `first` esant `null`, `.equals()` nebūtų kviečiamas. Teksto turiniui lyginti nenaudokite `==`.

## Pradinis kodas

Redaguokite tik `sameText` metodo turinį faile `TextComparison.java`. Testai šį metodą kviečia tiesiogiai; konsolės programos nereikia.

## Reikalavimai

- Naudokite `first != null && first.equals(second)`. Leidžiamas lygiavertis formatavimas su skliaustais.

## Pavyzdžiai

```java
sameText(new String("Java"), new String("Java")) -> true
sameText("Java", "java") -> false
sameText(null, "Java") -> false
```
