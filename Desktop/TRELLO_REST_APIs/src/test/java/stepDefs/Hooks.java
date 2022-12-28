package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void before(){
        System.out.println("before=================================================================");

    }

    @After
    public void after(){
        System.out.println("after==================================================================");

    }
}