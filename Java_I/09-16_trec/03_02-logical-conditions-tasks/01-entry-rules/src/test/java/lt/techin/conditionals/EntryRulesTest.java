package lt.techin.conditionals;

import com.sun.source.tree.Tree;
import lt.techin.testing.ConsoleCheck;
import lt.techin.testing.SourceCheck;
import org.junit.jupiter.api.Test;

class EntryRulesTest {
    private void check(int age, boolean ticket, boolean vip, boolean blocked, String result) {
        String out = ConsoleCheck.run(new String[]{"" + age, "" + ticket, "" + vip, "" + blocked},
                new String[]{"Give age:", "Has ticket:", "Is VIP:", "Is blocked:"},
                () -> EntryRules.main(new String[0]));
        ConsoleCheck.lines(out, "Give age:", "Has ticket:", "Is VIP:", "Is blocked:", result);
    }

    @Test void adultNeedsTicket() { check(18, true, false, false, "Entry allowed."); check(18, false, false, false, "Entry denied."); }
    @Test void vipIsAlternative() { check(17, false, true, false, "Entry allowed."); }
    @Test void blockingOverridesEverything() { check(30, true, true, true, "Entry denied."); }
    @Test void ageBoundary() { check(17, true, false, false, "Entry denied."); }

    @Test void usesTheCompleteReadableRule() throws Exception {
        SourceCheck.method("lt.techin.conditionals.EntryRules", "main")
                .requireKinds(Tree.Kind.LOGICAL_COMPLEMENT, Tree.Kind.CONDITIONAL_AND, Tree.Kind.CONDITIONAL_OR)
                .local("allowed", "boolean")
                .parenthesized()
                .bracedIfsAtLeast(1)
                .hasElse();
    }
}
