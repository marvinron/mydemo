package com.maviron.spring.springdemo.service;
 
import java.util.Scanner;
 
public class LoanTimetable {
 
	public static void main(String[] args) {
		try(Scanner input = new Scanner(System.in)) {
			System.out.print(" Loan Amount: ");
			double amount = input.nextDouble();
			
			System.out.print(" Number of Years: ");
			int year = 1;
			
			System.out.print(" Annual Interest Rate: ");
			double annualInterestRate = 1;
			
			showLoanTimetable(amount, year, annualInterestRate);
		}
	}
	
	//显示分期还贷时间表
	public static void showLoanTimetable(double balance, int numberOfYears,
          double annualInterestRate) {
		double monthlyRate = annualInterestRate / 1200;
		double monthlyPayment = monthlyPayment(balance, monthlyRate, numberOfYears);
		System.out.printf("\n Monthly Payment: %.2f\n", monthlyPayment);
		System.out.printf(" Total Payment: %.2f\n\n", totalPayment(numberOfYears, 
                 monthlyPayment));
		
		System.out.println(" Payment#\tInterest\tPrincipal\tBalance");
		for (int i = 1; i <= numberOfYears * 12; i++) {
			double interest = monthlyRate * balance;
			double principal = monthlyPayment - interest;
			balance -= principal;
			System.out.printf(" %-6d%14.2f%17.2f\t%15.2f\n", i, interest, principal, 
                     balance);
		}
	}
 
	//月支付额
	public static double monthlyPayment(double amount, double rate, int year) {
		return amount * rate / (1 - 1 / Math.pow(1 + rate, year * 12));
	}
		
	//总支付额
	public static double totalPayment(int year, double monthlyPayment) {
		return monthlyPayment * 12 * year;
	}
}