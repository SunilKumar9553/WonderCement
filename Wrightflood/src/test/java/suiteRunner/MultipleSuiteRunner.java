package suiteRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleSuiteRunner {
	

	@Test(dataProvider = "dpMultipleSuiteFiles", threadPoolSize = 5)
	public void run_test_suite(String xmlpath) throws Exception {
		TestNG testNG = new TestNG();
		List<String> xmlSuite = new ArrayList<>();
		xmlSuite.add(xmlpath);
		System.out.println("--------------Going to run test suite--------------");
		testNG.setTestSuites(xmlSuite);
		testNG.run();
		System.out.println("--------------Test Suite Ended----------------------");
	}

	 @DataProvider(name = "dpMultipleSuiteFiles", parallel = true)
	    public Object[][] getSuites() throws Exception {
	
	        Object[][] suiteFiles = new Object[2][1];
	        suiteFiles [0][0]="src/test/resources/TestSuites/Web_SingleBrowse.xml";
	        suiteFiles [1][0]="src/test/resources/TestSuites/Android_Suite_SingleDevice.xml";
	        
	        
	        return suiteFiles;
	    }

}
