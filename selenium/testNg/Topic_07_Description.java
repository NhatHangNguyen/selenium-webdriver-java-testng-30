package testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Description {

    @BeforeClass
    public void init(){
        System.out.println("Pre-condition for below testcase");
    }

    @Test(description = "JIRA#4526 - Add new users and Search")
    // Hiện thị ở trang Log/ Report HTML
    public void Priority_01_SearchWithDate(){
    }

    @Test
    public void Priority_02_SearchWithBilling(){
    }

    @Test
    public void Priority_03_SearchWithProduct(){
    }

    @AfterClass(alwaysRun = true)
    public void after(){
        System.out.println("Post-condition for above testcase");
    }
}
