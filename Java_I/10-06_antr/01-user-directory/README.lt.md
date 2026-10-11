# 01 · Naudotojų katalogas

**Tema:** filter, map, distinct, sorted, skip, limit, matching, Optional, mapToInt, joining, flatMap

Užbaikite 24 statinius `UserQueries.java` metodus. Tai viena užduotis apie naudotojų katalogą: pradėkite nuo paprastų užklausų, tada pereikite prie kelių operacijų grandinių. Metodai grąžina duomenis; konsolės programos kurti nereikia.

`User` ir `SampleData` pateiktos užbaigtos. Visas konstruktorius yra `new User(name, age, city, active, interests)`. Duomenis skaito `getName()`, `getAge()`, `getCity()`, `isActive()` ir `getInterests()`. Trumpasis `new User(name, age)` naudoja tuščią miestą, `false` aktyvumą ir tuščią pomėgių sąrašą. Modelis kopijuoja pomėgių sąrašą; jo keisti nereikia.

Visi sąrašai, naudotojai, eilutės ir parametrai yra ne `null`, sąrašuose nėra `null` elementų. Vardai netušti, amžius ir amžiaus parametrai neneigiami. `offset`, `size` ir `limit` yra neneigiami. Pomėgių sąrašai gali būti tušti, o pomėgių eilutėse gali būti tarpų, tabuliacijos, pasikartojimų ar tuščių reikšmių. Nenumatykite papildomo netinkamų įvesčių tikrinimo.

Pradinė tvarka reiškia sąrašo eiliškumą. Jei nenurodyta kitaip, išlaikykite pasikartojimus. Sąrašo rezultatas yra tuščias, kai nelieka elementų. Sąrašo keičiamumas nevertinamas. Grąžindami naudotojus naudokite pradinius objektus. Nekeiskite įvesties sąrašų ar objektų ir kiekvienai užklausai kurkite naują srautą.

`filter` palieka sąlygą atitinkančius elementus, `map` vieną elementą paverčia viena reikšme, o `toList()` užbaigia grandinę ir surenka rezultatus. Pavyzdžiuose naudokite šį katalogą:

```java
List<User> users = SampleData.users();
```

`users.get(index)` komentaruose žymi tą patį katalogo objektą, o ne pažodinę išvestį. Katalogo įrašai pateikti `SampleData.java` tokia tvarka:

- `0`: `Zoe`, `30`, `Vilnius`, `true`, `["Java", "Hiking", "Java"]`
- `1`: `Ana`, `17`, `Kaunas`, `true`, `["Music", "Java"]`
- `2`: `Bob`, `18`, `Vilnius`, `false`, `["Gaming"]`
- `3`: `Zoe`, `40`, `Kaunas`, `true`, `[]`
- `4`: `Ana`, `20`, `Vilnius`, `true`, `[" java ", "MUSIC", ""]`
- `5`: `Cara`, `18`, `Vilnius`, `true`, `["Hiking", "Java"]`
- `6`: `Dan`, `25`, `Klaipeda`, `false`, `["Cooking"]`
- `7`: `Eve`, `26`, `Vilnius`, `true`, `["JAVA", "Cycling"]`

Keiskite tik `src/main/java/lt/techin/stream/UserQueries.java`.

## Reikalavimai

Kiekviename metode tiesiogiai grąžinkite vienos srauto grandinės rezultatą. Nenaudokite ciklų, `forEach`, papildomų perėjimo per sąrašą metodų ar išorinės keičiamos būsenos. Sąrašo grandinę užbaikite `toList()` arba `collect(Collectors.toList())`. Toliau prie kiekvieno metodo nurodytos privalomos operacijos turi būti jo grąžinamoje grandinėje. Galite naudoti lambda išraiškas arba metodų nuorodas.

## Naudotojų duomenys ir atranka

### 1. activeUsers

`List<User> activeUsers(List<User> users)`

Grąžinkite tik aktyvius naudotojus pradine tvarka. Išlaikykite pasikartojimus ir tuos pačius naudotojų objektus.

Naudokite: `stream`, `filter`.

```java
UserQueries.activeUsers(users); // [users.get(0), users.get(1), users.get(3), users.get(4), users.get(5), users.get(7)]
```

### 2. usersOlderThan

`List<User> usersOlderThan(List<User> users, int age)`

Grąžinkite naudotojus, vyresnius už age, pradine tvarka. Naudotojas, kurio amžius lygus argumentui, neįtraukiamas. Išlaikykite tuos pačius objektus ir pasikartojimus.

Naudokite: `stream`, `filter`.

```java
UserQueries.usersOlderThan(users, 25); // [users.get(0), users.get(3), users.get(7)]
```

### 3. getAgeFromUsers

`List<Integer> getAgeFromUsers(List<User> users)`

Grąžinkite visų naudotojų amžių pradine tvarka, įskaitant pasikartojimus. map vieną naudotoją paverčia viena Integer reikšme.

Naudokite: `stream`, `map`.

```java
UserQueries.getAgeFromUsers(users); // [30, 17, 18, 40, 20, 18, 25, 26]
```

### 4. countUsersOlderThan25

`long countUsersOlderThan25(List<User> users)`

Suskaičiuokite naudotojus, vyresnius nei 25 metų. 25 metų naudotojas neįtraukiamas. count grąžina long; tuščiam sąrašui grąžinkite 0.

Naudokite: `stream`, `filter`, `count`.

```java
UserQueries.countUsersOlderThan25(users); // 3
```

### 5. adultNames

`List<String> adultNames(List<User> users)`

Grąžinkite 18 metų ir vyresnių naudotojų vardus. Išlaikykite pradinę tvarką ir pasikartojančius vardus. Pirmiausia atrinkite naudotojus, tada paverskite juos vardais.

Naudokite: `stream`, `filter`, `map`.

```java
UserQueries.adultNames(users); // [Zoe, Bob, Zoe, Ana, Cara, Dan, Eve]
```

### 6. uppercaseNames

`List<String> uppercaseNames(List<User> users)`

Grąžinkite visus vardus didžiosiomis raidėmis, naudodami toUpperCase(Locale.ROOT). Išlaikykite tvarką ir pasikartojimus. Locale.ROOT užtikrina, kad rezultatas nepriklausytų nuo kompiuterio kalbos nustatymų.

Naudokite: `stream`, `map`.

```java
UserQueries.uppercaseNames(users); // [ZOE, ANA, BOB, ZOE, ANA, CARA, DAN, EVE]
```

## Skirtingos reikšmės, rikiavimas ir sąrašo dalys

### 7. getDistinctAges

`List<Integer> getDistinctAges(List<User> users)`

Grąžinkite kiekvieną amžių vieną kartą, pirmojo pasirodymo tvarka. Nerikiuokite. Šalinkite pasikartojančias amžiaus reikšmes, o ne User objektus.

Naudokite: `stream`, `map`, `distinct`.

```java
UserQueries.getDistinctAges(users); // [30, 17, 18, 40, 20, 25, 26]
```

### 8. sortByAge

`List<User> sortByAge(List<User> users)`

Grąžinkite tuos pačius naudotojus didėjančia amžiaus tvarka. Vienodo amžiaus naudotojai išlaiko pradinę tvarką; čia nenaudokite vardo kaip papildomo rikiavimo kriterijaus. Naudokite amžiaus komparatorių, pavyzdžiui, Comparator.comparingInt(User::getAge). Nekeiskite pradinio sąrašo.

Naudokite: `stream`, `sorted`.

```java
UserQueries.sortByAge(users); // [users.get(1), users.get(2), users.get(5), users.get(4), users.get(6), users.get(7), users.get(0), users.get(3)]
```

### 9. getLimitedUserList

`List<User> getLimitedUserList(List<User> users, int limit)`

Grąžinkite ne daugiau kaip limit naudotojų iš sąrašo pradžios. Išlaikykite tvarką, pasikartojimus ir tuos pačius objektus. Nulis reiškia tuščią sąrašą; per didelė riba leidžia grąžinti visus naudotojus.

Naudokite: `stream`, `limit`.

```java
UserQueries.getLimitedUserList(users, 2); // [users.get(0), users.get(1)]
```

### 10. userWindow

`List<User> userWindow(List<User> users, int offset, int size)`

Praleiskite offset naudotojų pradine tvarka, tada grąžinkite ne daugiau kaip size naudotojų. Išlaikykite tuos pačius objektus ir pasikartojimus; nerikiuokite. offset 0 reiškia sąrašo pradžią, offset pasiekus ar viršijus sąrašo dydį grąžinamas tuščias sąrašas. size 0 taip pat reiškia tuščią sąrašą.

Naudokite: `stream`, `skip`, `limit`.

```java
UserQueries.userWindow(users, 2, 3); // [users.get(2), users.get(3), users.get(4)]
```

## Sąlygų tikrinimas ir naudotojų paieška

`Optional<User>` žymi naudotoją, kurio gali nebūti. Grąžinkite galutinės operacijos sukurtą `Optional`; nekeiskite jo į `null` ar išgalvotą naudotoją. `isPresent()` tikrina, ar reikšmė yra. Pavyzdžiuose `orElseThrow()` naudojamas tik tada, kai žinome, kad tinkamas naudotojas yra.

### 11. anyMatch

`boolean anyMatch(List<User> users, int age)`

Grąžinkite, ar bent vienam naudotojui yra tiksliai age metų. Tuščiam sąrašui grąžinkite false.

Naudokite: `stream`, `anyMatch`.

```java
UserQueries.anyMatch(users, 18); // true
```

### 12. allAdults

`boolean allAdults(List<User> users)`

Grąžinkite, ar visiems naudotojams yra bent 18 metų. Tuščiam sąrašui grąžinkite true: nėra naudotojo, kuris neatitiktų sąlygos.

Naudokite: `stream`, `allMatch`.

```java
UserQueries.allAdults(users); // false
```

### 13. noneMatch

`boolean noneMatch(List<User> users, int age)`

Grąžinkite, ar nėra nė vieno naudotojo, kuriam būtų tiksliai age metų. Tuščiam sąrašui grąžinkite true.

Naudokite: `stream`, `noneMatch`.

```java
UserQueries.noneMatch(users, 40); // false
```

### 14. findByName

`Optional<User> findByName(List<User> users, String name)`

Grąžinkite pirmą naudotoją nurodytu vardu pradine tvarka. Lyginkite naudodami equals, skirdami didžiąsias ir mažąsias raides. Nerikiuokite. Jei tinkamo vardo nėra, grąžinkite Optional.empty(). Grąžinkite pradinį naudotojo objektą.

Naudokite: `stream`, `filter`, `findFirst`.

```java
UserQueries.findByName(users, "Zoe").orElseThrow() == users.get(0); // true
UserQueries.findByName(users, "zoe"); // Optional.empty
```

### 15. firstAdult

`Optional<User> firstAdult(List<User> users)`

Grąžinkite pirmą bent 18 metų naudotoją pradine tvarka, išlaikydami tą patį objektą. Nerikiuokite. Tuščiam sąrašui arba nesant pilnamečio grąžinkite Optional.empty().

Naudokite: `stream`, `filter`, `findFirst`.

```java
UserQueries.firstAdult(users).orElseThrow() == users.get(0); // true
```

### 16. findOldest

`Optional<User> findOldest(List<User> users)`

Naudokite max su amžiaus komparatoriumi ir grąžinkite pradinį didžiausio amžiaus naudotoją. Jei keli naudotojai vienodai vyriausi, tinka bet kuris. Tuščiam sąrašui grąžinkite Optional.empty().

Naudokite: `stream`, `max`.

```java
UserQueries.findOldest(users).orElseThrow() == users.get(3); // true
```

## Naudotojų ataskaitos

### 17. sumAge

`int sumAge(List<User> users)`

Naudodami mapToInt paverskite naudotojus primityviomis amžiaus reikšmėmis ir grąžinkite jų sumą. Tuščiam sąrašui grąžinkite 0. Galite laikyti, kad suma telpa į int.

Naudokite: `stream`, `mapToInt`, `sum`.

```java
UserQueries.sumAge(users); // 194
```

### 18. getAverageAge

`double getAverageAge(List<User> users)`

Grąžinkite visų amžių aritmetinį vidurkį, išlaikydami trupmeninę dalį. Naudokite mapToInt ir average; tuščiam srautui naudokite orElse(0.0).

Naudokite: `stream`, `mapToInt`, `average`.

```java
UserQueries.getAverageAge(users); // 24.25
```

### 19. separateNamesByComma

`String separateNamesByComma(List<User> users)`

Grąžinkite visus vardus, sujungtus tiksliai ", " (kableliu ir vienu tarpu), pradine tvarka. Išlaikykite pasikartojančius vardus ir nepridėkite skirtuko pradžioje ar pabaigoje. Tuščiam sąrašui grąžinkite "". Collectors.joining surenka eilučių srautą į vieną eilutę.

Naudokite: `stream`, `map`, `collect`, `joining`.

```java
UserQueries.separateNamesByComma(users); // "Zoe, Ana, Bob, Zoe, Ana, Cara, Dan, Eve"
```

## Pomėgiai ir sudėtinės grandinės

`map(User::getInterests)` sukurtų `Stream<List<String>>`: po vieną sąrašą kiekvienam naudotojui. `flatMap` gauna kiekvieno naudotojo pomėgių srautą ir sujungia jų elementus į vieną `Stream<String>`. Paskutinėms trims užklausoms operacijų tvarką pasirinkite pagal aprašytą rezultatą.

### 20. allInterests

`List<String> allInterests(List<User> users)`

Išskleiskite visų naudotojų pomėgių sąrašus į vieną sąrašą. Išlaikykite naudotojų tvarką ir tvarką kiekvieno pomėgių sąrašo viduje. Nekeiskite rašybos, tarpų, raidžių dydžio, tuščių reikšmių ar pasikartojimų. Tuščias pomėgių sąrašas neprideda reikšmių.

Naudokite: `stream`, `flatMap`.

```java
UserQueries.allInterests(List.of(
    new User("A", 20, "Vilnius", true, List.of("Java", "Music")),
    new User("B", 30, "Kaunas", true, List.of()),
    new User("C", 18, "Vilnius", false, List.of("Music", "Cycling"))));
// [Java, Music, Music, Cycling]
```

### 21. uniqueInterests

`List<String> uniqueInterests(List<User> users)`

Grąžinkite kiekvieną pomėgį vieną kartą, pirmojo pasirodymo tvarka per naudotojų ir jų pomėgių sąrašus. Lyginkite tikslias eilutes: "Java", "JAVA" ir " Java " skiriasi. Nenormalizuokite, nešalinkite tuščių reikšmių ir nerikiuokite.

Naudokite: `stream`, `flatMap`, `distinct`.

```java
UserQueries.uniqueInterests(List.of(
    new User("A", 20, "Vilnius", true, List.of("Z", "A", "Z")),
    new User("B", 30, "Kaunas", true, List.of("A", "B"))));
// [Z, A, B]
```

### 22. activeInterestsInCity

`List<String> activeInterestsInCity(List<User> users, String city)`

Atrinkite aktyvius naudotojus, kurių miestas lygus city, skirdami didžiąsias ir mažąsias raides. Išskleiskite jų pomėgius. Kiekvieną pomėgį apdorokite trim(), paverskite mažosiomis raidėmis su Locale.ROOT ir pašalinkite tuščius rezultatus. Grąžinkite skirtingus normalizuotus pomėgius natūralia String tvarka. Normalizuokite prieš šalindami pasikartojimus. Amžius šiai užklausai nesvarbus.

Naudokite: `stream`, `filter`, `flatMap`, `map`, `distinct`, `sorted`.

```java
UserQueries.activeInterestsInCity(users, "Vilnius"); // [cycling, hiking, java, music]
UserQueries.activeInterestsInCity(users, "vilnius"); // []
```

### 23. selectedNames

`List<String> selectedNames(List<User> users, int minimumAge, int limit)`

Atrinkite minimumAge metų ir vyresnius naudotojus, nepriklausomai nuo miesto ar aktyvumo. Grąžinkite nepakeistus jų vardus po vieną kartą, natūralia String tvarka, tada paimkite ne daugiau kaip limit vardų. Skirkite didžiąsias ir mažąsias raides. Pasikartojantys vardai neturi užimti riboto rezultato vietų. Jei nėra tinkamų naudotojų arba limit yra 0, grąžinkite tuščią sąrašą.

Naudokite: `stream`, `filter`, `map`, `distinct`, `sorted`, `limit`.

```java
UserQueries.selectedNames(users, 18, 3); // [Ana, Bob, Cara]
UserQueries.selectedNames(users, 35, 10); // [Zoe]
```

### 24. uniqueAgeWindow

`List<Integer> uniqueAgeWindow(List<User> users, int offset, int size)`

Grąžinkite surikiuotų skirtingų amžių dalį. Pirmiausia gaukite amžiaus reikšmes, pašalinkite pasikartojimus ir surikiuokite didėjančia tvarka. Tada praleiskite offset rezultatų ir paimkite ne daugiau kaip size rezultatų. offset skaičiuoja surikiuotus skirtingus amžius, o ne pradinius naudotojus. Jei offset pasiekia ar viršija skirtingų amžių skaičių, size yra 0 arba įvestis tuščia, grąžinkite tuščią sąrašą.

Naudokite: `stream`, `map`, `distinct`, `sorted`, `skip`, `limit`.

```java
UserQueries.uniqueAgeWindow(users, 1, 3); // [18, 20, 25]
```

## Daugiau pavyzdžių

Kiekvienas toliau pateiktas blokas yra nepriklausomas.

```java
List<User> users = List.of(new User("A", 17), new User("B", 18),
    new User("C", 25), new User("D", 26), new User("B", 30));
UserQueries.getAgeFromUsers(users); // [17, 18, 25, 26, 30]
UserQueries.countUsersOlderThan25(users); // 2
UserQueries.adultNames(users); // [B, C, D, B]
UserQueries.getAgeFromUsers(List.of(new User("A", 18), new User("B", 20))); // [18, 20]
```

```java
UserQueries.getDistinctAges(List.of(new User("A", 30), new User("B", 18),
    new User("C", 30), new User("D", 20))); // [30, 18, 20]
User homer = new User("Homer", 50);
User bart = new User("Bart", 12);
User maggie = new User("Maggie", 2);
User lisa = new User("Lisa", 8);
UserQueries.sortByAge(List.of(homer, bart, maggie, lisa)); // [maggie, lisa, bart, homer]
```

```java
List<User> users = List.of(new User("A", 10), new User("B", 20), new User("C", 30));
UserQueries.sumAge(users); // 60
UserQueries.getAverageAge(users); // 20.0
UserQueries.getAverageAge(List.of(new User("A", 18), new User("B", 19))); // 18.5
```

```java
List<User> users = List.of(new User("Homer", 50), new User("Bart", 12),
    new User("Maggie", 2), new User("Lisa", 8));
UserQueries.anyMatch(users, 12); // true
UserQueries.noneMatch(users, 40); // true
UserQueries.allAdults(users); // false
UserQueries.findByName(users, "Homer").orElseThrow() == users.get(0); // true
UserQueries.findByName(users, "homer"); // Optional.empty
UserQueries.firstAdult(users).orElseThrow() == users.get(0); // true
UserQueries.findOldest(users).orElseThrow() == users.get(0); // true
UserQueries.allAdults(List.of()); // true
```

```java
List<User> users = List.of(new User("Homer", 50), new User("Maggie", 2), new User("Bart", 12));
UserQueries.separateNamesByComma(users); // "Homer, Maggie, Bart"
UserQueries.separateNamesByComma(List.of()); // ""
```

```java
List<User> users = List.of(new User("Zoe", 30), new User("Ana", 17),
    new User("Bob", 18), new User("Zoe", 40), new User("Ana", 20), new User("Cara", 18));
UserQueries.selectedNames(users, 18, 3); // [Ana, Bob, Cara]
UserQueries.selectedNames(users, 35, 10); // [Zoe]
```

```java
List<User> users = List.of(new User("A", 18), new User("B", 20),
    new User("C", 21), new User("D", 22), new User("E", 23));
UserQueries.getLimitedUserList(users, 2); // [users.get(0), users.get(1)]
List<User> numbered = List.of(new User("A", 1), new User("B", 2),
    new User("C", 3), new User("D", 4), new User("E", 5));
UserQueries.userWindow(numbered, 2, 99); // [numbered.get(2), numbered.get(3), numbered.get(4)]
List<User> repeatedAges = List.of(new User("A", 5), new User("B", 1),
    new User("C", 5), new User("D", 3), new User("E", 2),
    new User("F", 1), new User("G", 4));
UserQueries.uniqueAgeWindow(repeatedAges, 1, 3); // [2, 3, 4]
UserQueries.uniqueAgeWindow(repeatedAges, 0, 0); // []
```

```java
UserQueries.uppercaseNames(List.of(new User("This", 20), new User("is", 20),
    new User("java", 20), new User("8", 20))); // [THIS, IS, JAVA, 8]
UserQueries.uppercaseNames(List.of(new User("i", 20), new User("Java", 20),
    new User("Java", 20))); // [I, JAVA, JAVA]
```
