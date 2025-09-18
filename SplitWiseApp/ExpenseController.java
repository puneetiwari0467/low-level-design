package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.List;

public class ExpenseController {
	
	SplitFactory splitFactory;
	
	BalanceSheetController balanceSheetController;
	
	public ExpenseController() {
		this.splitFactory=new SplitFactory();
		this.balanceSheetController=new BalanceSheetController();
	}
	
	Expense createExpense(Integer expenseId,String desc,double amount,User paidBy,SplitType splitType,List<Split>splits) {
		
		Expense expense=new Expense(expenseId, desc, amount, paidBy, splitType, splits);
		SplitValidator splitValidator=splitFactory.getSplitValidator(splitType);
		if(splitValidator.validateRequest(splits, amount)) {
			balanceSheetController.updateBalanceSheet(amount,paidBy,splits);
			return expense;
		}else {
			//fail creating this expense 
			return null;
		}
	}
}
