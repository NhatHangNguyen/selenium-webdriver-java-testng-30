package orders;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Order_01_Search {

    @BeforeClass(alwaysRun = true)
    public void init(){
        System.out.println("Pre-condition for below testcase");
    }

    @Test(groups = "orders")
    public void testSearchWithDate(){
    }

    @Test(groups = "orders")
    public void testSearchWithBilling(){
    }

    @Test(groups = "orders")
    public void testSearchWithProduct(){
    }

    @AfterClass(alwaysRun = true)
    public void after(){
        System.out.println("Post-condition for above testcase");
    }
}
