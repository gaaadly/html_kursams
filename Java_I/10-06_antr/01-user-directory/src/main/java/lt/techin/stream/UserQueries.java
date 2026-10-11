package lt.techin.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

/** Queries for a users directory. @author JaroslavGr */
public class UserQueries {

    /** Return only active users in encounter order. Keep repetitions and the original user objects. */
    public static List<User> activeUsers(List<User> users) {
        // TODO: activeUsers. See README.
        return users.stream()
                .filter(user -> user.isActive())
                .toList();
    }

    /** Return users strictly older than age, in encounter order. A user whose age equals the argument is excluded. Keep original objects and repetitions. */
    public static List<User> usersOlderThan(List<User> users, int age) {
        // TODO: usersOlderThan. See README.
        return users.stream()
                .filter(user -> user.getAge() > age)
                .toList();
    }

    /** Return every user age in encounter order, including repeated ages. map transforms one user into one Integer. */
    public static List<Integer> getAgeFromUsers(List<User> users) {
        // TODO: getAgeFromUsers. See README.
        return users.stream()
                .map(user -> user.getAge())
                .toList();
    }

    /** Count users strictly older than 25. A 25-year-old is excluded. count returns long; empty input returns 0. */
    public static long countUsersOlderThan25(List<User> users) {
        // TODO: countUsersOlderThan25. See README.
        return users.stream()
                .filter(user -> user.getAge() > 25)
                .count();
    }

    /** Return names of users aged 18 or older. Keep encounter order and repeated names. Select users before mapping them to names. */
    public static List<String> adultNames(List<User> users) {
        // TODO: adultNames. See README.
        return users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(user -> user.getName())
                .toList();
    }

    /** Return every name in uppercase with toUpperCase(Locale.ROOT). Keep order and duplicate names. Locale.ROOT prevents the computer language settings from changing the result. */
    public static List<String> uppercaseNames(List<User> users) {
        // TODO: uppercaseNames. See README.
        return users.stream()
                .map(user -> user.getName().toUpperCase(Locale.ROOT))
                .toList();
    }

    /** Return each age once, in the order of its first occurrence. Do not sort. Deduplicate the projected age values, rather than User objects. */
    public static List<Integer> getDistinctAges(List<User> users) {
        // TODO: getDistinctAges. See README.
        return users.stream()
                .map(user -> user.getAge())
                .distinct()
                .toList();
    }

    /** Return the same users in ascending age order. Equal ages keep encounter order; do not use name as a tie-breaker here. Use an age comparator, for example Comparator.comparingInt(User::getAge). Leave the source list unchanged. */
    public static List<User> sortByAge(List<User> users) {
        // TODO: sortByAge. See README.
        return users.stream()
                .sorted(Comparator.comparingInt(user -> user.getAge()))
                .toList();
    }

    /** Return at most limit users from the beginning of the list. Preserve order, repetitions and original objects. Zero returns an empty list; an oversized limit returns all users. */
    public static List<User> getLimitedUserList(List<User> users, int limit) {
        // TODO: getLimitedUserList. See README.
        return users.stream()
                .limit(limit)
                .toList();
    }

    /** Skip offset users in encounter order, then return at most size users. Preserve original objects and repetitions; do not sort. Offset 0 starts at the beginning, offset at or beyond the list size returns an empty list, and size 0 returns an empty list. */
    public static List<User> userWindow(List<User> users, int offset, int size) {
        // TODO: userWindow. See README.
        return users.stream()
                .skip(offset)
                .limit(size)
                .toList();
    }

    /** Return whether at least one user has exactly age years. Empty input returns false. */
    public static boolean anyMatch(List<User> users, int age) {
        // TODO: anyMatch. See README.
        return users.stream()
                .anyMatch(user -> user.getAge() == age);
    }

    /** Return whether every user is aged 18 or older. Empty input returns true: no user breaks the condition. */
    public static boolean allAdults(List<User> users) {
        // TODO: allAdults. See README.
        return users.stream()
                .allMatch(user -> user.getAge() >= 18);
    }

    /** Return whether no user has exactly age years. Empty input returns true. */
    public static boolean noneMatch(List<User> users, int age) {
        // TODO: noneMatch. See README.
        return users.stream()
                .noneMatch(user -> user.getAge() == age);
    }

    /** Return the first user with exactly the given name, in encounter order. Compare using equals, case-sensitively. Do not sort. If no name matches, return Optional.empty(). Return an original user object. */
    public static Optional<User> findByName(List<User> users, String name) {
        // TODO: findByName. See README.
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

    /** Return the first user aged at least 18 in encounter order, using the original object. Do not sort. Empty input or no adult returns Optional.empty(). */
    public static Optional<User> firstAdult(List<User> users) {
        // TODO: firstAdult. See README.
        return users.stream()
                .filter(user -> user.getAge() >= 18)
                .findFirst();
    }

    /** Use max with an age comparator to return an original user with the greatest age. Any tied oldest user is allowed. Empty input returns Optional.empty(). */
    public static Optional<User> findOldest(List<User> users) {
        // TODO: findOldest. See README.
        return users.stream()
                .max(Comparator.comparingInt(user -> user.getAge()));
    }

    /** Convert users to primitive ages with mapToInt and return their sum. Empty input returns 0. Assume the sum fits in int. */
    public static int sumAge(List<User> users) {
        // TODO: sumAge. See README.
        return users.stream()
                .mapToInt(user -> user.getAge())
                .sum();
    }

    /** Return the arithmetic mean of all ages, keeping the fractional part. Use mapToInt and average; use orElse(0.0) for an empty stream. */
    public static double getAverageAge(List<User> users) {
        // TODO: getAverageAge. See README.
        return users.stream()
                .mapToInt(user -> user.getAge())
                .average()
                .orElse(0.0);
    }

    /** Return all names joined with exactly ", " (comma and one space), in encounter order. Keep repeated names and add no leading or trailing delimiter. Empty input returns "". Collectors.joining collects a stream of strings into one string. */
    public static String separateNamesByComma(List<User> users) {
        // TODO: separateNamesByComma. See README.
        return users.stream()
                .map(user -> user.getName())
                .collect(Collectors.joining(", "));
    }

    /** Flatten every user interest list into one list. Keep user order and order inside each interest list. Preserve spelling, spaces, case, blank values and repetitions. An empty interest list contributes no values. */
    public static List<String> allInterests(List<User> users) {
        // TODO: allInterests. See README.
        return users.stream()
                .flatMap(user -> user.getInterests().stream())
                .toList();
    }

    /** Return every interest once in first-encounter order across users and their interest lists. Compare exact strings: "Java", "JAVA" and " Java " differ. Do not normalize, remove blanks or sort. */
    public static List<String> uniqueInterests(List<User> users) {
        // TODO: uniqueInterests. See README.
        return users.stream()
                .flatMap(user -> user.getInterests().stream())
                .distinct()
                .toList();
    }

    /** Select active users whose city equals city, case-sensitively. Flatten their interests. Trim each interest with trim(), convert to lowercase with Locale.ROOT, and remove empty results. Return distinct normalized interests sorted in natural String order. Normalize before deduplicating. Age is irrelevant to this query. */
    public static List<String> activeInterestsInCity(List<User> users, String city) {
        // TODO: activeInterestsInCity. See README.
        return users.stream()
                .filter(user -> user.isActive())
                .filter(user -> user.getCity().equals(city))
                .flatMap(user -> user.getInterests().stream())
                .map(interest -> interest.trim().toLowerCase(Locale.ROOT))
                .filter(interest -> !interest.isEmpty())
                .distinct()
                .sorted()
                .toList();
    }

    /** Select users aged minimumAge or older, regardless of city or active status. Return their unchanged names once each, sorted in natural String order, then take at most limit names. Comparisons are case-sensitive. Duplicate names must not use up the limit. No matches or limit 0 returns an empty list. */
    public static List<String> selectedNames(List<User> users, int minimumAge, int limit) {
        // TODO: selectedNames. See README.
        return users.stream()
                .filter(user -> user.getAge() >= minimumAge)
                .map(user -> user.getName())
                .distinct()
                .sorted()
                .limit(limit)
                .toList();
    }

    /** Return a window of sorted unique ages. First obtain ages, remove duplicates and sort ascending. Then skip offset results and take at most size results. Offset counts sorted unique ages, not original users. Offset at or beyond the number of unique ages, size 0, or empty input returns an empty list. */
    public static List<Integer> uniqueAgeWindow(List<User> users, int offset, int size) {
        // TODO: uniqueAgeWindow. See README.
        return users.stream()
                .map(user -> user.getAge())
                .distinct()
                .sorted()
                .skip(offset)
                .limit(size)
                .toList();
    }
}
