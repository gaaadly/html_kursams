package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void boundariesAndOrder(){MessagingService s=new MessagingService();Message empty=new Message("A",""),limit=new Message("B","x".repeat(280));s.add(empty);s.add(limit);s.add(new Message("C","x".repeat(281)));s.add(empty);assertEquals(java.util.List.of(empty,limit,empty),s.getMessages());assertSame(limit,s.getMessages().get(1));}
    @Test void copyAndIndependence() throws Exception {MessagingService s=new MessagingService();s.add(new Message("A","Hi"));s.getMessages().clear();assertEquals(1,s.getMessages().size());assertTrue(new MessagingService().getMessages().isEmpty());fields(MessagingService.class,"messages");}

}
