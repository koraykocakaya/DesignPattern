package com.kk.designPattern.behavioral.state;

public class StateDemo {
	public static void main(String[] args) {
		int[] combination = new int[] {1,2,3};
		CombinationLock comLock = new CombinationLock(combination);
		
		System.out.println(comLock.status);
		comLock.enterDigit(1);
		System.out.println(comLock.status);
		comLock.enterDigit(2);
		System.out.println(comLock.status);
		comLock.enterDigit(3);
		System.out.println(comLock.status);
		
		comLock = new CombinationLock(combination);
		System.out.println(comLock.status);
		comLock.enterDigit(1);
		System.out.println(comLock.status);
		comLock.enterDigit(8);
		System.out.println(comLock.status);
		comLock.enterDigit(2);
		System.out.println(comLock.status);
	}
}

class CombinationLock
{
  private int [] combination;
  public String status;
  int iterator = 0;
  boolean failed = false;
  
  public CombinationLock(int[] combination)
  {
	  reset();
    this.combination = combination;
  }
  
  private void reset() {
	  iterator = 0;
	  status = "LOCKED";
	  failed = false;
  }

  public void enterDigit(int digit)
  {
    if("LOCKED".equals(status)) {
    	status = "";
    }
    status  += digit;
    if(digit != combination[iterator++]) {
    	failed = true;
    }
    
    if(combination.length == iterator) {
    	status = failed ? "ERROR" : "OPEN";
    }
  }
}
