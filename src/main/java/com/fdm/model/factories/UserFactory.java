package com.fdm.model.factories;

import com.fdm.model.Broker;
import com.fdm.model.ShareHolder;
import com.fdm.model.SysAdmin;
import com.fdm.model.User;
/**
 * Factory class contains common logic to common logic to create different type of users it instantiates a user only after determining its type
 * @author julia.kovale
 *
 */
public class UserFactory {
	
	public static final int user = 0;
	public static final int admin = 1;
	public static final int broker = 1;
	public static final int shareholder = 1;
	
	public static User createUser(int userType){ 
		if(userType==0)
			return new User();
		if(userType==1)
			return new SysAdmin();
		if (userType ==2)
			return new Broker();
		if (userType ==3)
			return new ShareHolder();
		
		return  null;
	}
	
}
