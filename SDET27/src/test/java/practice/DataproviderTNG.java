package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTNG {
	@Test(dataProvider = "getData")
	public void readDatafromDataprovider(String name,int qty) {
		System.out.println("mobile name------"+name+" qunty-----"+qty);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objectArray = new Object[3][2];
		objectArray[0][0] = "iphone";
	    objectArray[0][1] = 10;	
	    
		objectArray[1][0] = "nokia";
	    objectArray[1][1] = 20;
	    
		objectArray[2][0] = "sumsung";
	    objectArray[2][1] = 30;
	    return objectArray;
						
		
	}

}
