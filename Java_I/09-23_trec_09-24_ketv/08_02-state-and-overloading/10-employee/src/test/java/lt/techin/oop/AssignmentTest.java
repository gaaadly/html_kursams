package lt.techin.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import static lt.techin.testing.Contract.*;
@Timeout(5)
class AssignmentTest {
    @Test void identityAndRepresentation(){Employee e=new Employee(7,"Ada","Lovelace",101);assertEquals(7,e.getID());assertEquals("Ada",e.getFirstName());assertEquals("Lovelace",e.getLastName());assertEquals("Ada Lovelace",e.getName());assertEquals("Employee[id=7,name=Ada Lovelace,salary=101]",e.toString());}
    @Test void salaryChanges(){Employee e=new Employee(1,"A","B",101);assertEquals(1212,e.getAnnualSalary());assertEquals(111,e.raiseSalary(10));assertEquals(122,e.raiseSalary(10));assertEquals(122,e.getSalary());assertEquals(122,e.raiseSalary(0));e.setSalary(200);assertEquals(2400,e.getAnnualSalary());assertEquals(200,e.getSalary());}
    @Test void zeroAndSeparation() throws Exception {Employee a=new Employee(1,"A","B",0),b=new Employee(2,"C","D",50);assertEquals(0,a.raiseSalary(20));a.setSalary(900);assertEquals(50,b.getSalary());fields(Employee.class,"id","firstName","lastName","salary");assertEquals("",output(()->b.toString()));}

}
