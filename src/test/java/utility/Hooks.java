package utility;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        new BrowserDriver(); // Initializes if needed

    }

    @After
    public void tearDown() {
        BrowserDriver.close(); // Always try to close
    }
}
