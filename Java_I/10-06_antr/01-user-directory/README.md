# 01 · Users directory

**Topic:** filter, map, distinct, sorted, skip, limit, matching, Optional, mapToInt, joining, flatMap

Complete the 24 static methods in `UserQueries.java`. This is one assignment about a users directory: start with simple queries, then build pipelines with several operations. Methods return data; no console application is needed.

`User` and `SampleData` are complete. The full constructor is `new User(name, age, city, active, interests)`. Read data with `getName()`, `getAge()`, `getCity()`, `isActive()` and `getInterests()`. The short `new User(name, age)` uses an empty city, `false` active status and an empty interest list. The model copies the interest list; it needs no changes.

All lists, users, strings and arguments are non-null, and lists contain no null elements. Names are nonempty; ages and age arguments are nonnegative. All offset, size and limit arguments are nonnegative. Interest lists may be empty; interest strings may contain spaces, tabs, duplicates or blank values. No additional invalid-input handling is required.

Encounter order means the list's original order. Unless stated otherwise, keep repetitions. A list result is empty when no elements remain. Result-list mutability is not assessed. Return original objects when returning users. Leave input lists and objects unchanged, and create a fresh stream for each query.

filter keeps matching elements, map transforms one element into one value, and toList() finishes the pipeline by collecting results. Use this directory for the examples:

```java
List<User> users = SampleData.users();
```

`users.get(index)` in comments denotes the actual directory object, rather than literal printed output. `SampleData.java` contains these entries in this order:

- `0`: `Zoe`, `30`, `Vilnius`, `true`, `["Java", "Hiking", "Java"]`
- `1`: `Ana`, `17`, `Kaunas`, `true`, `["Music", "Java"]`
- `2`: `Bob`, `18`, `Vilnius`, `false`, `["Gaming"]`
- `3`: `Zoe`, `40`, `Kaunas`, `true`, `[]`
- `4`: `Ana`, `20`, `Vilnius`, `true`, `[" java ", "MUSIC", ""]`
- `5`: `Cara`, `18`, `Vilnius`, `true`, `["Hiking", "Java"]`
- `6`: `Dan`, `25`, `Klaipeda`, `false`, `["Cooking"]`
- `7`: `Eve`, `26`, `Vilnius`, `true`, `["JAVA", "Cycling"]`

Edit only `src/main/java/lt/techin/stream/UserQueries.java`.

## Requirements

Return one stream pipeline directly from each method. Do not use loops, `forEach`, traversal helpers or external mutable state. Finish list pipelines with `toList()` or `collect(Collectors.toList())`. The operations listed below each method must appear in its returned pipeline. Lambdas and method references are both allowed.

## Read and select users

### 1. activeUsers

`List<User> activeUsers(List<User> users)`

Return only active users in encounter order. Keep repetitions and the original user objects.

Use: `stream`, `filter`.

```java
UserQueries.activeUsers(users); // [users.get(0), users.get(1), users.get(3), users.get(4), users.get(5), users.get(7)]
```

### 2. usersOlderThan

`List<User> usersOlderThan(List<User> users, int age)`

Return users strictly older than age, in encounter order. A user whose age equals the argument is excluded. Keep original objects and repetitions.

Use: `stream`, `filter`.

```java
UserQueries.usersOlderThan(users, 25); // [users.get(0), users.get(3), users.get(7)]
```

### 3. getAgeFromUsers

`List<Integer> getAgeFromUsers(List<User> users)`

Return every user age in encounter order, including repeated ages. map transforms one user into one Integer.

Use: `stream`, `map`.

```java
UserQueries.getAgeFromUsers(users); // [30, 17, 18, 40, 20, 18, 25, 26]
```

### 4. countUsersOlderThan25

`long countUsersOlderThan25(List<User> users)`

Count users strictly older than 25. A 25-year-old is excluded. count returns long; empty input returns 0.

Use: `stream`, `filter`, `count`.

```java
UserQueries.countUsersOlderThan25(users); // 3
```

### 5. adultNames

`List<String> adultNames(List<User> users)`

Return names of users aged 18 or older. Keep encounter order and repeated names. Select users before mapping them to names.

Use: `stream`, `filter`, `map`.

```java
UserQueries.adultNames(users); // [Zoe, Bob, Zoe, Ana, Cara, Dan, Eve]
```

### 6. uppercaseNames

`List<String> uppercaseNames(List<User> users)`

Return every name in uppercase with toUpperCase(Locale.ROOT). Keep order and duplicate names. Locale.ROOT prevents the computer language settings from changing the result.

Use: `stream`, `map`.

```java
UserQueries.uppercaseNames(users); // [ZOE, ANA, BOB, ZOE, ANA, CARA, DAN, EVE]
```

## Unique values, ordering and windows

### 7. getDistinctAges

`List<Integer> getDistinctAges(List<User> users)`

Return each age once, in the order of its first occurrence. Do not sort. Deduplicate the projected age values, rather than User objects.

Use: `stream`, `map`, `distinct`.

```java
UserQueries.getDistinctAges(users); // [30, 17, 18, 40, 20, 25, 26]
```

### 8. sortByAge

`List<User> sortByAge(List<User> users)`

Return the same users in ascending age order. Equal ages keep encounter order; do not use name as a tie-breaker here. Use an age comparator, for example Comparator.comparingInt(User::getAge). Leave the source list unchanged.

Use: `stream`, `sorted`.

```java
UserQueries.sortByAge(users); // [users.get(1), users.get(2), users.get(5), users.get(4), users.get(6), users.get(7), users.get(0), users.get(3)]
```

### 9. getLimitedUserList

`List<User> getLimitedUserList(List<User> users, int limit)`

Return at most limit users from the beginning of the list. Preserve order, repetitions and original objects. Zero returns an empty list; an oversized limit returns all users.

Use: `stream`, `limit`.

```java
UserQueries.getLimitedUserList(users, 2); // [users.get(0), users.get(1)]
```

### 10. userWindow

`List<User> userWindow(List<User> users, int offset, int size)`

Skip offset users in encounter order, then return at most size users. Preserve original objects and repetitions; do not sort. Offset 0 starts at the beginning, offset at or beyond the list size returns an empty list, and size 0 returns an empty list.

Use: `stream`, `skip`, `limit`.

```java
UserQueries.userWindow(users, 2, 3); // [users.get(2), users.get(3), users.get(4)]
```

## Check conditions and find users

`Optional<User>` represents a user that may be absent. Return the Optional produced by the terminal operation; do not replace it with null or an invented user. `isPresent()` checks for a value. Examples call `orElseThrow()` only when a matching user is known to exist.

### 11. anyMatch

`boolean anyMatch(List<User> users, int age)`

Return whether at least one user has exactly age years. Empty input returns false.

Use: `stream`, `anyMatch`.

```java
UserQueries.anyMatch(users, 18); // true
```

### 12. allAdults

`boolean allAdults(List<User> users)`

Return whether every user is aged 18 or older. Empty input returns true: no user breaks the condition.

Use: `stream`, `allMatch`.

```java
UserQueries.allAdults(users); // false
```

### 13. noneMatch

`boolean noneMatch(List<User> users, int age)`

Return whether no user has exactly age years. Empty input returns true.

Use: `stream`, `noneMatch`.

```java
UserQueries.noneMatch(users, 40); // false
```

### 14. findByName

`Optional<User> findByName(List<User> users, String name)`

Return the first user with exactly the given name, in encounter order. Compare using equals, case-sensitively. Do not sort. If no name matches, return Optional.empty(). Return an original user object.

Use: `stream`, `filter`, `findFirst`.

```java
UserQueries.findByName(users, "Zoe").orElseThrow() == users.get(0); // true
UserQueries.findByName(users, "zoe"); // Optional.empty
```

### 15. firstAdult

`Optional<User> firstAdult(List<User> users)`

Return the first user aged at least 18 in encounter order, using the original object. Do not sort. Empty input or no adult returns Optional.empty().

Use: `stream`, `filter`, `findFirst`.

```java
UserQueries.firstAdult(users).orElseThrow() == users.get(0); // true
```

### 16. findOldest

`Optional<User> findOldest(List<User> users)`

Use max with an age comparator to return an original user with the greatest age. Any tied oldest user is allowed. Empty input returns Optional.empty().

Use: `stream`, `max`.

```java
UserQueries.findOldest(users).orElseThrow() == users.get(3); // true
```

## Directory reports

### 17. sumAge

`int sumAge(List<User> users)`

Convert users to primitive ages with mapToInt and return their sum. Empty input returns 0. Assume the sum fits in int.

Use: `stream`, `mapToInt`, `sum`.

```java
UserQueries.sumAge(users); // 194
```

### 18. getAverageAge

`double getAverageAge(List<User> users)`

Return the arithmetic mean of all ages, keeping the fractional part. Use mapToInt and average; use orElse(0.0) for an empty stream.

Use: `stream`, `mapToInt`, `average`.

```java
UserQueries.getAverageAge(users); // 24.25
```

### 19. separateNamesByComma

`String separateNamesByComma(List<User> users)`

Return all names joined with exactly ", " (comma and one space), in encounter order. Keep repeated names and add no leading or trailing delimiter. Empty input returns "". Collectors.joining collects a stream of strings into one string.

Use: `stream`, `map`, `collect`, `joining`.

```java
UserQueries.separateNamesByComma(users); // "Zoe, Ana, Bob, Zoe, Ana, Cara, Dan, Eve"
```

## Interests and combined pipelines

`map(User::getInterests)` would produce `Stream<List<String>>`: one list per user. `flatMap` obtains a stream of each user's interests and joins their elements into one `Stream<String>`. For the final three queries, choose operation order from the required result.

### 20. allInterests

`List<String> allInterests(List<User> users)`

Flatten every user interest list into one list. Keep user order and order inside each interest list. Preserve spelling, spaces, case, blank values and repetitions. An empty interest list contributes no values.

Use: `stream`, `flatMap`.

```java
UserQueries.allInterests(List.of(
    new User("A", 20, "Vilnius", true, List.of("Java", "Music")),
    new User("B", 30, "Kaunas", true, List.of()),
    new User("C", 18, "Vilnius", false, List.of("Music", "Cycling"))));
// [Java, Music, Music, Cycling]
```

### 21. uniqueInterests

`List<String> uniqueInterests(List<User> users)`

Return every interest once in first-encounter order across users and their interest lists. Compare exact strings: "Java", "JAVA" and " Java " differ. Do not normalize, remove blanks or sort.

Use: `stream`, `flatMap`, `distinct`.

```java
UserQueries.uniqueInterests(List.of(
    new User("A", 20, "Vilnius", true, List.of("Z", "A", "Z")),
    new User("B", 30, "Kaunas", true, List.of("A", "B"))));
// [Z, A, B]
```

### 22. activeInterestsInCity

`List<String> activeInterestsInCity(List<User> users, String city)`

Select active users whose city equals city, case-sensitively. Flatten their interests. Trim each interest with trim(), convert to lowercase with Locale.ROOT, and remove empty results. Return distinct normalized interests sorted in natural String order. Normalize before deduplicating. Age is irrelevant to this query.

Use: `stream`, `filter`, `flatMap`, `map`, `distinct`, `sorted`.

```java
UserQueries.activeInterestsInCity(users, "Vilnius"); // [cycling, hiking, java, music]
UserQueries.activeInterestsInCity(users, "vilnius"); // []
```

### 23. selectedNames

`List<String> selectedNames(List<User> users, int minimumAge, int limit)`

Select users aged minimumAge or older, regardless of city or active status. Return their unchanged names once each, sorted in natural String order, then take at most limit names. Comparisons are case-sensitive. Duplicate names must not use up the limit. No matches or limit 0 returns an empty list.

Use: `stream`, `filter`, `map`, `distinct`, `sorted`, `limit`.

```java
UserQueries.selectedNames(users, 18, 3); // [Ana, Bob, Cara]
UserQueries.selectedNames(users, 35, 10); // [Zoe]
```

### 24. uniqueAgeWindow

`List<Integer> uniqueAgeWindow(List<User> users, int offset, int size)`

Return a window of sorted unique ages. First obtain ages, remove duplicates and sort ascending. Then skip offset results and take at most size results. Offset counts sorted unique ages, not original users. Offset at or beyond the number of unique ages, size 0, or empty input returns an empty list.

Use: `stream`, `map`, `distinct`, `sorted`, `skip`, `limit`.

```java
UserQueries.uniqueAgeWindow(users, 1, 3); // [18, 20, 25]
```

## More examples

Each block below is independent.

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
