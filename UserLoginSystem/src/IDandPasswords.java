import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("JudyAnn","JudyAnn123");
		logininfo.put("RegineAnn","RegineAnn123");
		logininfo.put("Admin","Admin123");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}