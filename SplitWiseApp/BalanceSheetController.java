package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.List;

public class BalanceSheetController {
	
	void updateBalanceSheet(double amount, User paidBy, List<Split> splits) {

	    // Step 1: Update total payment of payer
	    double totalPayment = paidBy.getBalanceSheet().getTotalPayment();
	    paidBy.getBalanceSheet().setTotalPayment(totalPayment + amount);

	    // Step 2: For each split
	    for (Split split : splits) {
	        User user = split.getUser();
	        double share = split.getAmount();

	        if (!user.equals(paidBy)) {

	            // -------------------
	            // Update PaidBy’s side (GetBack from friend)
	            // -------------------
	            Balance paidByFriendBalance = paidBy.getBalanceSheet()
	                    .getFriendVsBalance()
	                    .getOrDefault(user, new Balance());

	            // Add to getBack
	            paidByFriendBalance.setGetBack(paidByFriendBalance.getGetBack() + share);

	            // Apply netting between owes and getBack
	            netBalances(paidByFriendBalance);

	            paidBy.getBalanceSheet().getFriendVsBalance().put(user, paidByFriendBalance);

	            // -------------------
	            // Update Friend’s side (Owes to PaidBy)
	            // -------------------
	            Balance friendBalance = user.getBalanceSheet()
	                    .getFriendVsBalance()
	                    .getOrDefault(paidBy, new Balance());

	            // Add to owes
	            friendBalance.setOwes(friendBalance.getOwes() + share);

	            // Apply netting between owes and getBack
	            netBalances(friendBalance);

	            user.getBalanceSheet().getFriendVsBalance().put(paidBy, friendBalance);

	            // -------------------
	            // Update totals
	            // -------------------
	            double totalOwes = user.getBalanceSheet().getTotalOwes();
	            user.getBalanceSheet().setTotalOwes(totalOwes + share);

	            double totalGetBack = paidBy.getBalanceSheet().getTotalGetBack();
	            paidBy.getBalanceSheet().setTotalGetBack(totalGetBack + share);
	        }
	    }
	}

	/**
	 * Utility method to ensure balance is always netted.
	 * Example: if owes=300 and getBack=500 → result = getBack=200, owes=0
	 */
	private void netBalances(Balance balance) {
	    double owes = balance.getOwes();
	    double getBack = balance.getGetBack();

	    if (owes > getBack) {
	        balance.setOwes(owes - getBack);
	        balance.setGetBack(0.0);
	    } else if (getBack > owes) {
	        balance.setGetBack(getBack - owes);
	        balance.setOwes(0.0);
	    } else {
	        // Equal, cancel out
	        balance.setOwes(0.0);
	        balance.setGetBack(0.0);
	    }
	}

	
	
}	
