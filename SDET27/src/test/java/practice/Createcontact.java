package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Createcontact {
	@Test(retryAnalyzer = com.crm.autodesk.genericUtility.RetryAnalyserImpl.class)
	public void Createcontact() {
		Reporter.log("custmer create successfuly",true);
		Assert.fail();
	}
	

}
