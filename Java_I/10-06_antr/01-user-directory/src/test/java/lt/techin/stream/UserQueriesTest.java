package lt.techin.stream;

import lt.techin.testing.PipelineCheck;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(10)
class UserQueriesTest {
    private static List<User> ages(int... ages) {
        var users = new ArrayList<User>();
        for (int i = 0; i < ages.length; i++) users.add(new User("User" + i, ages[i]));
        return users;
    }

    private static User user(String name, int age, String city, boolean active, String... interests) {
        return new User(name, age, city, active, List.of(interests));
    }

    @Test void activeUsersKeepObjectsOrderAndRepetitions() {
        User a = user("Z", 17, "Vilnius", true), b = user("A", 50, "Kaunas", false);
        User c = user("C", 20, "Kaunas", true);
        assertEquals(List.of(a, c, a), UserQueries.activeUsers(List.of(a, b, c, a)));
        assertEquals(List.of(), UserQueries.activeUsers(List.of(b)));
    }

    @Test void olderThanIsStrictAndUsesItsArgument() {
        var users = ages(0, 17, 18, 25, 26, 25);
        assertEquals(List.of(users.get(4)), UserQueries.usersOlderThan(users, 25));
        assertEquals(users.subList(2, 6), UserQueries.usersOlderThan(users, 17));
        assertEquals(List.of(), UserQueries.usersOlderThan(users, 26));
        assertEquals(users.subList(1, 6), UserQueries.usersOlderThan(users, 0));
    }

    @Test void projectedAgesKeepOrderAndDuplicates() {
        assertEquals(List.of(18, 20), UserQueries.getAgeFromUsers(ages(18, 20)));
        assertEquals(List.of(40, 0, 40, 18), UserQueries.getAgeFromUsers(ages(40, 0, 40, 18)));
    }

    @Test void countExcludes25() {
        assertEquals(1L, UserQueries.countUsersOlderThan25(ages(18, 20, 21, 22, 23, 24, 25, 26)));
        assertEquals(2L, UserQueries.countUsersOlderThan25(ages(25, 26, 50, 24)));
        assertEquals(0L, UserQueries.countUsersOlderThan25(ages(0, 25, 25)));
    }

    @Test void adultNamesInclude18AndKeepRepeatedNames() {
        var users = List.of(new User("A", 17), new User("B", 18), new User("C", 25),
            new User("D", 26), new User("B", 30));
        assertEquals(List.of("B", "C", "D", "B"), UserQueries.adultNames(users));
        assertEquals(List.of(), UserQueries.adultNames(ages(0, 17)));
        assertEquals(List.of("Inactive"), UserQueries.adultNames(List.of(new User("Inactive", 18))));
    }

    @Test void uppercaseNamesPreserveRepetitionsAndUseRootLocale() {
        assertEquals(List.of("THIS", "IS", "JAVA", "8"), UserQueries.uppercaseNames(List.of(
            new User("This", 20), new User("is", 20), new User("java", 20), new User("8", 20))));
        Locale previous = Locale.getDefault();
        try {
            Locale.setDefault(Locale.forLanguageTag("tr"));
            assertEquals(List.of("I", "JAVA", "JAVA"), UserQueries.uppercaseNames(List.of(
                new User("i", 20), new User("Java", 20), new User("Java", 20))));
        } finally {
            Locale.setDefault(previous);
        }
    }

    @Test void distinctAgesKeepFirstOccurrenceRatherThanSortedOrder() {
        assertEquals(List.of(30, 18, 20), UserQueries.getDistinctAges(ages(30, 18, 30, 20, 18)));
        assertEquals(List.of(18, 20, 21, 22, 23, 24, 25, 26),
            UserQueries.getDistinctAges(ages(18, 20, 20, 21, 22, 22, 23, 24, 25, 26)));
    }

    @Test void ageSortingReturnsOriginalObjects() {
        User homer = new User("Homer", 50), bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2), lisa = new User("Lisa", 8);
        var users = new ArrayList<>(List.of(homer, bart, maggie, lisa));
        assertEquals(List.of(maggie, lisa, bart, homer), UserQueries.sortByAge(users));
        assertEquals(List.of(homer, bart, maggie, lisa), users);
    }

    @Test void equalAgesKeepEncounterOrderWithoutNameTieBreaker() {
        User z = new User("Z", 20), a = new User("A", 20), child = new User("B", 18);
        assertEquals(List.of(child, z, a, z), UserQueries.sortByAge(List.of(z, a, child, z)));
    }

    @Test void limitUsesOriginalObjectsAndSupportsZeroAndOversizedValues() {
        var users = ages(18, 20, 21, 22, 23);
        assertEquals(users.subList(0, 2), UserQueries.getLimitedUserList(users, 2));
        assertEquals(List.of(), UserQueries.getLimitedUserList(users, 0));
        assertEquals(users, UserQueries.getLimitedUserList(users, 99));
        User repeated = users.get(0);
        assertEquals(List.of(repeated, repeated), UserQueries.getLimitedUserList(List.of(repeated, repeated, users.get(1)), 2));
    }

    @Test void userWindowSkipsBeforeLimitingWithoutSorting() {
        var users = ages(40, 10, 30, 20, 5);
        assertEquals(users.subList(2, 5), UserQueries.userWindow(users, 2, 3));
        assertEquals(users.subList(1, 3), UserQueries.userWindow(users, 1, 2));
        assertEquals(users, UserQueries.userWindow(users, 0, 99));
        assertEquals(List.of(), UserQueries.userWindow(users, 5, 2));
        assertEquals(List.of(), UserQueries.userWindow(users, 99, 2));
        assertEquals(List.of(), UserQueries.userWindow(users, 0, 0));
        User a = users.get(0);
        assertEquals(List.of(a, a), UserQueries.userWindow(List.of(users.get(1), a, a), 1, 2));
    }

    @Test void anyMatchChecksExactAge() {
        assertTrue(UserQueries.anyMatch(ages(10, 20, 30), 20));
        assertFalse(UserQueries.anyMatch(ages(10, 20, 30), 19));
        assertTrue(UserQueries.anyMatch(ages(0, 18), 0));
    }

    @Test void allAdultsIncludes18ButRejects17() {
        assertTrue(UserQueries.allAdults(ages(18, 30)));
        assertFalse(UserQueries.allAdults(ages(30, 17)));
        assertFalse(UserQueries.allAdults(ages(0)));
    }

    @Test void noneMatchChecksExactAgeInBothDirections() {
        assertTrue(UserQueries.noneMatch(ages(10, 20, 30), 40));
        assertFalse(UserQueries.noneMatch(ages(10, 20, 30), 20));
        assertFalse(UserQueries.noneMatch(ages(0), 0));
    }

    @Test void nameSearchUsesEqualsCaseAndFirstOccurrence() {
        User homer = new User(new String("Homer"), 50), other = new User("Homer", 20);
        User bart = new User("Bart", 12);
        assertSame(homer, UserQueries.findByName(List.of(bart, homer, other), new String("Homer")).orElseThrow());
        assertSame(other, UserQueries.findByName(List.of(other, homer), "Homer").orElseThrow());
        assertEquals(Optional.empty(), UserQueries.findByName(List.of(homer), "homer"));
        assertEquals(Optional.empty(), UserQueries.findByName(List.of(homer), "Lisa"));
    }

    @Test void firstAdultFollowsEncounterOrderRatherThanAgeOrder() {
        User child = new User("Child", 17), older = new User("Older", 50), adult = new User("Adult", 18);
        assertSame(older, UserQueries.firstAdult(List.of(child, older, adult)).orElseThrow());
        assertSame(adult, UserQueries.firstAdult(List.of(child, adult, older)).orElseThrow());
        assertEquals(Optional.empty(), UserQueries.firstAdult(List.of(child)));
    }

    @Test void oldestReturnsActualMaximumAndAllowsTies() {
        User a = new User("A", 50), b = new User("B", 12), c = new User("C", 50);
        assertSame(a, UserQueries.findOldest(List.of(b, a)).orElseThrow());
        assertSame(b, UserQueries.findOldest(List.of(b)).orElseThrow());
        User result = UserQueries.findOldest(List.of(b, a, c)).orElseThrow();
        assertTrue(result == a || result == c, "Return one of the original tied oldest users.");
    }

    @Test void sumAgeUsesAllAgesIncludingZeroAndDuplicates() {
        assertEquals(72, UserQueries.sumAge(List.of(new User("Homer", 50), new User("Bart", 12),
            new User("Maggie", 2), new User("Lisa", 8))));
        assertEquals(37, UserQueries.sumAge(ages(18, 19)));
        assertEquals(40, UserQueries.sumAge(ages(20, 0, 20)));
    }

    @Test void averageKeepsFractionalPart() {
        assertEquals(20.0, UserQueries.getAverageAge(ages(10, 20, 30)), 1e-9);
        assertEquals(18.5, UserQueries.getAverageAge(ages(18, 19)), 1e-9);
        assertEquals(10.0, UserQueries.getAverageAge(ages(20, 0, 20, 0)), 1e-9);
        assertEquals(0.0, UserQueries.getAverageAge(ages(0)), 1e-9);
    }

    @Test void namesJoinWithExactlyCommaAndSpace() {
        assertEquals("Homer, Maggie, Bart", UserQueries.separateNamesByComma(List.of(
            new User("Homer", 50), new User("Maggie", 2), new User("Bart", 12))));
        assertEquals("Solo", UserQueries.separateNamesByComma(List.of(new User("Solo", 20))));
        assertEquals("A, A, B", UserQueries.separateNamesByComma(List.of(
            new User("A", 20), new User("A", 30), new User("B", 40))));
    }

    @Test void interestsFlattenBothLevelsInOrderAndKeepDuplicates() {
        var users = List.of(user("A", 20, "V", true, "Java", "Music"), user("B", 20, "K", false),
            user("C", 18, "V", false, "Music", "Cycling"));
        assertEquals(List.of("Java", "Music", "Music", "Cycling"), UserQueries.allInterests(users));
        assertEquals(List.of(" Z ", "", "z", " Z "), UserQueries.allInterests(List.of(
            user("A", 17, "", false, " Z ", ""), user("B", 90, "", true, "z", " Z "))));
        assertEquals(List.of(), UserQueries.allInterests(ages(18, 20)));
    }

    @Test void uniqueInterestsKeepExactValuesAndFirstOccurrence() {
        assertEquals(List.of("Z", "A", "B"), UserQueries.uniqueInterests(List.of(
            user("A", 20, "V", true, "Z", "A", "Z"), user("B", 30, "K", true, "A", "B"))));
        assertEquals(List.of("Java", "JAVA", " Java ", "", " "), UserQueries.uniqueInterests(List.of(
            user("A", 18, "", false, "Java", "JAVA", " Java ", "", " "),
            user("B", 30, "", true, "JAVA", "", "Java"))));
        assertEquals(List.of(), UserQueries.uniqueInterests(ages(20)));
    }

    @Test void cityReportSelectsBeforeFlatteningAndNormalizesBeforeDistinct() {
        var users = List.of(
            user("A", 17, "Vilnius", true, " Java ", "", "SPRING", "java", "  ", " stream ", "Spring"),
            user("B", 50, "Vilnius", false, "InactiveOnly"),
            user("C", 30, "Kaunas", true, "WrongCity"),
            user("D", 18, "Vilnius", true, " Spring ", "\t"));
        assertEquals(List.of("java", "spring", "stream"), UserQueries.activeInterestsInCity(users, "Vilnius"));
        assertEquals(List.of("wrongcity"), UserQueries.activeInterestsInCity(users, "Kaunas"));
        assertEquals(List.of(), UserQueries.activeInterestsInCity(users, "vilnius"));
        assertEquals(List.of(), UserQueries.activeInterestsInCity(users, "Missing"));
        assertEquals(List.of(), UserQueries.activeInterestsInCity(List.of(user("Blank", 20, "V", true, "", "\t", "  ")), "V"));
    }

    @Test void cityReportUsesRootLocaleForLowercase() {
        Locale previous = Locale.getDefault();
        try {
            Locale.setDefault(Locale.forLanguageTag("tr"));
            assertEquals(List.of("i"), UserQueries.activeInterestsInCity(List.of(
                user("A", 18, "V", true, " I ", "i")), "V"));
        } finally {
            Locale.setDefault(previous);
        }
    }

    @Test void selectedNamesFilterDeduplicateSortThenLimit() {
        var users = List.of(new User("Zoe", 30), new User("Ana", 17), new User("Bob", 18),
            new User("Zoe", 40), new User("Ana", 20), new User("Cara", 18));
        assertEquals(List.of("Ana", "Bob", "Cara"), UserQueries.selectedNames(users, 18, 3));
        assertEquals(List.of("Zoe"), UserQueries.selectedNames(users, 35, 10));
        assertEquals(List.of("Ana", "Bob", "Cara", "Zoe"), UserQueries.selectedNames(users, 18, 10));
        assertEquals(List.of(), UserQueries.selectedNames(users, 41, 10));
        assertEquals(List.of(), UserQueries.selectedNames(users, 18, 0));
    }

    @Test void duplicatesCannotUseUpNameLimitAndNamesAreCaseSensitive() {
        assertEquals(List.of("A", "B"), UserQueries.selectedNames(List.of(new User("A", 20),
            new User("A", 30), new User("B", 20), new User("C", 20)), 20, 2));
        assertEquals(List.of("A", "B", "a"), UserQueries.selectedNames(List.of(
            new User("a", 20), new User("B", 20), new User("A", 20)), 20, 10));
        assertEquals(List.of("Baby"), UserQueries.selectedNames(List.of(new User("Baby", 0)), 0, 1));
    }

    @Test void ageWindowCountsSortedUniqueAgesRatherThanUsers() {
        var users = ages(5, 1, 5, 3, 2, 1, 4);
        assertEquals(List.of(2, 3, 4), UserQueries.uniqueAgeWindow(users, 1, 3));
        assertEquals(List.of(1, 2), UserQueries.uniqueAgeWindow(users, 0, 2));
        assertEquals(List.of(4, 5), UserQueries.uniqueAgeWindow(users, 3, 10));
        assertEquals(List.of(), UserQueries.uniqueAgeWindow(users, 0, 0));
        assertEquals(List.of(), UserQueries.uniqueAgeWindow(users, 5, 2));
        assertEquals(List.of(), UserQueries.uniqueAgeWindow(users, 99, 2));
        assertEquals(List.of(), UserQueries.uniqueAgeWindow(ages(1, 1), 1, 2));
        assertEquals(List.of(0, 2), UserQueries.uniqueAgeWindow(ages(2, 0, 2), 0, 99));
    }

    @Test void sharedDirectoryExamplesAgreeWithTheBrief() {
        var users = SampleData.users();
        assertEquals(List.of(users.get(0), users.get(1), users.get(3), users.get(4), users.get(5), users.get(7)), UserQueries.activeUsers(users));
        assertEquals(List.of(users.get(0), users.get(3), users.get(7)), UserQueries.usersOlderThan(users, 25));
        assertEquals(List.of(30, 17, 18, 40, 20, 18, 25, 26), UserQueries.getAgeFromUsers(users));
        assertEquals(3L, UserQueries.countUsersOlderThan25(users));
        assertEquals(List.of("Zoe", "Bob", "Zoe", "Ana", "Cara", "Dan", "Eve"), UserQueries.adultNames(users));
        assertEquals(List.of("ZOE", "ANA", "BOB", "ZOE", "ANA", "CARA", "DAN", "EVE"), UserQueries.uppercaseNames(users));
        assertEquals(List.of(30, 17, 18, 40, 20, 25, 26), UserQueries.getDistinctAges(users));
        assertEquals(List.of(users.get(1), users.get(2), users.get(5), users.get(4), users.get(6), users.get(7), users.get(0), users.get(3)), UserQueries.sortByAge(users));
        assertEquals(users.subList(0, 2), UserQueries.getLimitedUserList(users, 2));
        assertEquals(users.subList(2, 5), UserQueries.userWindow(users, 2, 3));
        assertTrue(UserQueries.anyMatch(users, 18));
        assertFalse(UserQueries.allAdults(users));
        assertFalse(UserQueries.noneMatch(users, 40));
        assertSame(users.get(0), UserQueries.findByName(users, "Zoe").orElseThrow());
        assertEquals(Optional.empty(), UserQueries.findByName(users, "zoe"));
        assertSame(users.get(0), UserQueries.firstAdult(users).orElseThrow());
        assertSame(users.get(3), UserQueries.findOldest(users).orElseThrow());
        assertEquals(194, UserQueries.sumAge(users));
        assertEquals(24.25, UserQueries.getAverageAge(users), 1e-9);
        assertEquals("Zoe, Ana, Bob, Zoe, Ana, Cara, Dan, Eve", UserQueries.separateNamesByComma(users));
        assertEquals(List.of("cycling", "hiking", "java", "music"), UserQueries.activeInterestsInCity(users, "Vilnius"));
        assertEquals(List.of("Ana", "Bob", "Cara"), UserQueries.selectedNames(users, 18, 3));
        assertEquals(List.of(18, 20, 25), UserQueries.uniqueAgeWindow(users, 1, 3));
    }

    @Test void everyQueryCanBeCalledAgainWithoutChangingItsSource() {
        var users = new ArrayList<>(SampleData.users());
        var before = List.copyOf(users);
        var interests = users.stream().map(user -> List.copyOf(user.getInterests())).toList();
        for (int round = 0; round < 2; round++) {
            UserQueries.activeUsers(users);
            UserQueries.usersOlderThan(users, 25);
            UserQueries.getAgeFromUsers(users);
            UserQueries.countUsersOlderThan25(users);
            UserQueries.adultNames(users);
            UserQueries.uppercaseNames(users);
            UserQueries.getDistinctAges(users);
            UserQueries.sortByAge(users);
            UserQueries.getLimitedUserList(users, 2);
            UserQueries.userWindow(users, 1, 3);
            UserQueries.anyMatch(users, 18);
            UserQueries.allAdults(users);
            UserQueries.noneMatch(users, 40);
            UserQueries.findByName(users, "Zoe");
            UserQueries.firstAdult(users);
            UserQueries.findOldest(users);
            UserQueries.sumAge(users);
            UserQueries.getAverageAge(users);
            UserQueries.separateNamesByComma(users);
            UserQueries.allInterests(users);
            UserQueries.uniqueInterests(users);
            UserQueries.activeInterestsInCity(users, "Vilnius");
            UserQueries.selectedNames(users, 18, 3);
            UserQueries.uniqueAgeWindow(users, 1, 3);
            assertEquals(before, users, "Queries must leave the input directory in its original order.");
            assertEquals(interests, users.stream().map(User::getInterests).toList(), "Leave nested interest lists unchanged.");
        }
    }

    @TestFactory Stream<DynamicTest> emptyDirectoryHasDefinedResults() {
        List<User> empty = List.of();
        return Stream.of(
            DynamicTest.dynamicTest("activeUsers empty", () -> assertEquals(List.of(), UserQueries.activeUsers(empty))),
            DynamicTest.dynamicTest("usersOlderThan empty", () -> assertEquals(List.of(), UserQueries.usersOlderThan(empty, 25))),
            DynamicTest.dynamicTest("getAgeFromUsers empty", () -> assertEquals(List.of(), UserQueries.getAgeFromUsers(empty))),
            DynamicTest.dynamicTest("countUsersOlderThan25 empty", () -> assertEquals(0L, UserQueries.countUsersOlderThan25(empty))),
            DynamicTest.dynamicTest("adultNames empty", () -> assertEquals(List.of(), UserQueries.adultNames(empty))),
            DynamicTest.dynamicTest("uppercaseNames empty", () -> assertEquals(List.of(), UserQueries.uppercaseNames(empty))),
            DynamicTest.dynamicTest("getDistinctAges empty", () -> assertEquals(List.of(), UserQueries.getDistinctAges(empty))),
            DynamicTest.dynamicTest("sortByAge empty", () -> assertEquals(List.of(), UserQueries.sortByAge(empty))),
            DynamicTest.dynamicTest("getLimitedUserList empty", () -> assertEquals(List.of(), UserQueries.getLimitedUserList(empty, 2))),
            DynamicTest.dynamicTest("userWindow empty", () -> assertEquals(List.of(), UserQueries.userWindow(empty, 2, 3))),
            DynamicTest.dynamicTest("anyMatch empty", () -> assertFalse(UserQueries.anyMatch(empty, 18))),
            DynamicTest.dynamicTest("allAdults empty", () -> assertTrue(UserQueries.allAdults(empty))),
            DynamicTest.dynamicTest("noneMatch empty", () -> assertTrue(UserQueries.noneMatch(empty, 18))),
            DynamicTest.dynamicTest("findByName empty", () -> assertEquals(Optional.empty(), UserQueries.findByName(empty, "A"))),
            DynamicTest.dynamicTest("firstAdult empty", () -> assertEquals(Optional.empty(), UserQueries.firstAdult(empty))),
            DynamicTest.dynamicTest("findOldest empty", () -> assertEquals(Optional.empty(), UserQueries.findOldest(empty))),
            DynamicTest.dynamicTest("sumAge empty", () -> assertEquals(0, UserQueries.sumAge(empty))),
            DynamicTest.dynamicTest("getAverageAge empty", () -> assertEquals(0.0, UserQueries.getAverageAge(empty), 1e-9)),
            DynamicTest.dynamicTest("separateNamesByComma empty", () -> assertEquals("", UserQueries.separateNamesByComma(empty))),
            DynamicTest.dynamicTest("allInterests empty", () -> assertEquals(List.of(), UserQueries.allInterests(empty))),
            DynamicTest.dynamicTest("uniqueInterests empty", () -> assertEquals(List.of(), UserQueries.uniqueInterests(empty))),
            DynamicTest.dynamicTest("activeInterestsInCity empty", () -> assertEquals(List.of(), UserQueries.activeInterestsInCity(empty, "V"))),
            DynamicTest.dynamicTest("selectedNames empty", () -> assertEquals(List.of(), UserQueries.selectedNames(empty, 18, 3))),
            DynamicTest.dynamicTest("uniqueAgeWindow empty", () -> assertEquals(List.of(), UserQueries.uniqueAgeWindow(empty, 1, 3)))
        );
    }

    @TestFactory Stream<DynamicTest> eachMethodUsesItsRequiredStreamOperations() {
        String[][] requirements = {
            {"activeUsers", "stream", "filter"}, {"usersOlderThan", "stream", "filter"},
            {"getAgeFromUsers", "stream", "map"}, {"countUsersOlderThan25", "stream", "filter", "count"},
            {"adultNames", "stream", "filter", "map"}, {"uppercaseNames", "stream", "map"},
            {"getDistinctAges", "stream", "map", "distinct"}, {"sortByAge", "stream", "sorted"},
            {"getLimitedUserList", "stream", "limit"}, {"userWindow", "stream", "skip", "limit"},
            {"anyMatch", "stream", "anyMatch"}, {"allAdults", "stream", "allMatch"},
            {"noneMatch", "stream", "noneMatch"}, {"findByName", "stream", "filter", "findFirst"},
            {"firstAdult", "stream", "filter", "findFirst"}, {"findOldest", "stream", "max"},
            {"sumAge", "stream", "mapToInt", "sum"}, {"getAverageAge", "stream", "mapToInt", "average"},
            {"separateNamesByComma", "stream", "map", "collect", "joining"},
            {"allInterests", "stream", "flatMap"}, {"uniqueInterests", "stream", "flatMap", "distinct"},
            {"activeInterestsInCity", "stream", "filter", "flatMap", "map", "distinct", "sorted"},
            {"selectedNames", "stream", "filter", "map", "distinct", "sorted", "limit"},
            {"uniqueAgeWindow", "stream", "map", "distinct", "sorted", "skip", "limit"}
        };
        return Stream.of(requirements).map(row -> DynamicTest.dynamicTest(row[0] + " pipeline", () ->
            PipelineCheck.check("UserQueries", row[0], java.util.Arrays.copyOfRange(row, 1, row.length))));
    }
}
