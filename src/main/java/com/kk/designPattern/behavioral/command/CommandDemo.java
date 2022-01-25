package com.kk.designPattern.behavioral.command;

import java.util.Arrays;
import java.util.List;

public class CommandDemo {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		
		List<BankAccountCommand> bankAccountCommandList = Arrays.asList(
				new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, 300),
				new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, 100),
				new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, 1700),
				new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, 300)
		);
		
		System.out.println(bankAccount.toString());
		for (BankAccountCommand bankAccountCommand : bankAccountCommandList) {
			bankAccountCommand.call();
			System.out.println(bankAccount.toString());
		}
		
		// undo should control that call method works
		for (int i=bankAccountCommandList.size() -1 ; i>=0; i--) {
			bankAccountCommandList.get(i).undo();
			System.out.println(bankAccount.toString());
		}
	}
}

class BankAccount{
	
	private int balance;
	private int overdraftLimit = -500;
	
	public void deposit(int amount) {
		balance += amount;
//		System.out.println("Deposited : " + amount + ", balance is: " + balance);
	}
	
	public boolean withdraw(int amount) {
		if(balance - amount >= overdraftLimit) {
			balance -= amount;
			return true;
//			System.out.println("Withdrew : " + amount + ", balance is: " + balance);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Balance is: " + balance;
	}
}

interface Command{
	void call();
	void undo();
}

class BankAccountCommand implements Command{
	private BankAccount bankAccount;
	private Action action;
	private int amount;
	private boolean succeeded;
	
	public BankAccountCommand(BankAccount bankAccount, Action action, int amount) {
		super();
		this.bankAccount = bankAccount;
		this.action = action;
		this.amount = amount;
	}

	@Override
	public void call() {
		if(action == Action.DEPOSIT) {
			bankAccount.deposit(amount);
		} else if (action == Action.WITHDRAW) {
			this.succeeded = bankAccount.withdraw(amount);
		}
	}
	
	@Override
	public void undo() {
		if(action == Action.DEPOSIT) {
			bankAccount.withdraw(amount);
		} else if (action == Action.WITHDRAW) {
			if(succeeded) {
				bankAccount.deposit(amount);
			}
		}
	}

	public enum Action{
		DEPOSIT, WITHDRAW
	}
}
