package com.ATM_Interface.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ATM_Interface.Beans.BalanceBean;
import com.ATM_Interface.Beans.DepositWithdrawBean;
import com.ATM_Interface.Beans.TransferBean;
import com.ATM_Interface.Controller.Login;

public class AmountDb {
	
	public String insertAmount(DepositWithdrawBean deposit)
	{
		String s=null;
		boolean isAccount=false;
		MyDb db=new MyDb();
		Connection con=db.getCon();
		try {
			double balance=0.00;
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select balance from atm.amount where accountNumber='"+Login.accountNumber+"'");
			if (rs.next()) {
			    balance = rs.getDouble("balance");
			    isAccount=true;
			}
			if(isAccount) {
			stmt.executeUpdate("update atm.amount set balance='"+(balance+deposit.getAmount())+"' where accountNumber='"+Login.accountNumber+"'");
			stmt.executeUpdate("insert into atm.transactionhistory (accountNumber,amount,actionPerformed) values ('"+Login.accountNumber+"','"+deposit.getAmount()+"','Deposited')");
			s="Deposit Successful";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String withdrawAmount(DepositWithdrawBean withdraw)
	{
		String s=null;
		boolean isAccount=false;
		MyDb db=new MyDb();
		Connection con=db.getCon();
		try {
			double balance=0.00;
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select balance from atm.amount where accountNumber='"+Login.accountNumber+"'");
			if (rs.next()) {
			    balance = rs.getDouble("balance");
			    isAccount=true;
			}
			if(!isAccount)
			{
				s="Incorrect Account Number";
			}else if(withdraw.getAmount()<0)
			{
				s="Invalid Amount entered";
			}else if(balance>=withdraw.getAmount()){
			stmt.executeUpdate("update atm.amount set balance='"+(balance-withdraw.getAmount())+"' where accountNumber='"+Login.accountNumber+"'");
			stmt.executeUpdate("insert into atm.transactionhistory (accountNumber,amount,actionPerformed) values ('"+Login.accountNumber+"','"+withdraw.getAmount()+"','Withdrawn')");
			s="Withdraw Successful";
			}
			else{
				s="Insufficient Balance";
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}
	
	public String checkBalance(BalanceBean bb)
	{
		String str=null;
		boolean cred=false;
		double balance=0.00;
		
		MyDb db=new MyDb();
		Connection con=db.getCon();
		
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select atm.amount.balance from atm.register join atm.amount on atm.register.accountNumber = atm.amount.accountNumber where atm.register.pin='"+bb.getPin()+"' and atm.register.accountNumber='"+Login.accountNumber+"'");
			if (rs.next()) {
			    balance = rs.getDouble("balance");
			    cred=true; 
			}
			if(!cred)
			str="Incorrect Pin entered";
			else 
			str="Balance: "+balance;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public String transfer(TransferBean tb)
	{
		String s1=null;
		boolean isAccount1=false,isAccount2=false;
		double balance=0.00,balance1=0.00;
		MyDb db=new MyDb();
		Connection con=db.getCon();
		try {
			String otherAccountHolder = null;
			String otherAccountHolder1 = null;
			String Transfered = "Transfered";
			String Received = "Received";

			Statement stmt1 = con.createStatement();
			Statement stmt2 = con.createStatement();
			Statement stmt3 = con.createStatement();
			Statement stmt4 = con.createStatement();

			ResultSet rs = stmt1.executeQuery("select balance from atm.amount where accountNumber='" + tb.getTranferAccount() + "'");
			if (rs!=null && rs.next()) {
			    balance = rs.getDouble("balance");
			    isAccount1=true;
			}

			ResultSet rs1 = stmt2.executeQuery("select balance from atm.amount where accountNumber='" + Login.accountNumber + "'");
			if (rs1!=null && rs1.next()) {
			    balance1 = rs1.getDouble("balance");
			    isAccount2=true;
			}
			
			if(isAccount2 && isAccount1)
			{
			if(balance1>tb.getTransferAmount()){
			ResultSet othersAccountName = stmt3.executeQuery("select userName from atm.register where accountNumber='" + tb.getTranferAccount() + "'");
			if (othersAccountName.next()) {
			    otherAccountHolder = othersAccountName.getString("userName");
			}

			ResultSet othersAccountName1 = stmt4.executeQuery("select userName from atm.register where accountNumber='" + Login.accountNumber + "'");
			if (othersAccountName1.next()) {
			    otherAccountHolder1 = othersAccountName1.getString("userName");
			}

			stmt1.executeUpdate("update atm.amount set balance='" + (balance + tb.getTransferAmount()) + "'where accountNumber='" + tb.getTranferAccount() + "'");
			stmt2.executeUpdate("insert into atm.transactionHistory(accountNumber,othersAccount,accountHolderName,amount,actionPerformed) values ('" + tb.getTranferAccount() + "','" + Login.accountNumber + "','" + otherAccountHolder1 + "','" + tb.getTransferAmount() + "','" + Received + "')");
			stmt3.executeUpdate("update atm.amount set balance='" + (balance1 - tb.getTransferAmount()) + "' where accountNumber='" + Login.accountNumber + "'");
			stmt4.executeUpdate("insert into atm.transactionhistory(accountNumber,othersAccount,accountHolderName,amount,actionPerformed) values('" + Login.accountNumber + "','" + tb.getTranferAccount() + "','" + otherAccountHolder + "','" + tb.getTransferAmount() + "','" + Transfered + "')");

			
			rs.close();
			rs1.close();
			stmt1.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
			s1="Transfer Successful";
			}
			else
			{
				s1="Insufficient Balance";
			}
			}else {
				s1="Incorrect Account Number";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s1;
		
	}

}
