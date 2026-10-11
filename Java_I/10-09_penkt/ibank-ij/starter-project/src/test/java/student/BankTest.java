package student;

import ibank.Bank;
import ibank.BaseBankTest;

public class BankTest extends BaseBankTest {
    @Override
    protected Bank createBank() {
        return new MyBank();
    }
}
