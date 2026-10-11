import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PhilatelistBaseTest;

public class PhilatelistInit extends PhilatelistBaseTest {

    @Override
    protected Philatelist getPhilatelist() {
        return new PhilatelistImpl();
    }
}
