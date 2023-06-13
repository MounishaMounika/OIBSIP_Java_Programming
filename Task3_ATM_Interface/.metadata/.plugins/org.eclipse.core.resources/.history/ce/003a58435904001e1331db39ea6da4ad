package com.ATM_Interface.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ATM_Interface.Beans.TransactionHistoryBean;

public class TransactionHistoryDb {
	
	public ArrayList<TransactionHistoryBean> transactionHistory(TransactionHistoryBean thb)
	{
		MyDb db=new MyDb();
		Connection con=db.getCon();
		ArrayList<TransactionHistoryBean> historyList = new ArrayList<TransactionHistoryBean>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from atm.transactionhistory where accountNumber='"+thb.getAccountNumber()+"'");
			while (rs.next()) {
				TransactionHistoryBean thb1 = new TransactionHistoryBean();
			    thb1.setAccountNumber(rs.getLong("accountNumber"));
			    thb1.setOthersAccount(rs.getLong("othersAccount"));
			    thb1.setAccountHolderName(rs.getString("accountHolderName"));
			    thb1.setAmount(rs.getDouble("amount"));
			    thb1.setActionPerformed(rs.getString("actionPerformed"));
			    historyList.add(thb1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyList;
	}

}
