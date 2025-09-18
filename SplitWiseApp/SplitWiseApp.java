package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SplitWiseApp {
	

	
	public static void main(String[]args) {
		UserController userController=new UserController();
		GroupController groupController=new GroupController();
		BalanceSheetController balanceSheetController=new BalanceSheetController();
		
		User user1=new User(1,"Puneet");
		User user2=new User(2,"Tricker");
		User user3=new User(3,"Sanchit");
		User user4=new User(4,"Umesh");
		userController.addUser(user1);
		userController.addUser(user2);
		userController.addUser(user3);
		userController.addUser(user4);
		
		ExpenseController expenseController=new ExpenseController();
		
		List<Split>splits=new ArrayList<>();
		Split split1=new Split(user1,1000.0,null);
		Split split2=new Split(user2,1000.0,null);
		Split split3=new Split(user3,1000.0,null);
		Split split4=new Split(user4,1000.0,null);
		splits.addAll(Arrays.asList(split1, split2, split3, split4));
		expenseController.createExpense(1, "Kitchen", 4000, user1, SplitType.EQUAL, splits);
		
		List<Split>splitss=new ArrayList<>();
		Split split11=new Split(user1,500.0,null);
		Split split21=new Split(user2,500.0,null);
		Split split31=new Split(user3,500.0,null);
		Split split41=new Split(user4,500.0,null);
		splitss.addAll(Arrays.asList(split11, split21, split31, split41));
		expenseController.createExpense(1, "Kitchen", 2000, user3, SplitType.EQUAL, splitss);
		
		for(User user:userController.getUsers()) {
			System.out.println(user.getName());
			for(Map.Entry<User,Balance> mp:user.getBalanceSheet().getFriendVsBalance().entrySet()) {
				System.out.println(mp.getKey().getName()+"->"+mp.getValue());
			}
		}
	}
}
