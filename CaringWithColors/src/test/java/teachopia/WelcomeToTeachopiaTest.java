package teachopia;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.teachopia.genericlib.Base;


@Listeners(com.teachopia.genericlib.ListenerImp.class)
public class WelcomeToTeachopiaTest extends Base
{
	@Test
	public void welcomeTest() throws InterruptedException 
	{
		Reporter.log("Welcome to Homescreen", true);
		
	}
}




