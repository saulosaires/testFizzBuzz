package com.serviceflow.service;



public class FizzBuzzServiceImpl implements IFizzBuzzService {

	 private int FIZZ_DIVISOR=3;
	 private int BUZZ_DIVISOR=5;
	 
	 
	 
	 
	/* (non-Javadoc)
	 * @see com.serviceflow.service.IFizzBuzzService#isFizz(int)
	 */
	@Override
	public boolean isFizz(int num) {
		
		return num%FIZZ_DIVISOR==0?true:false;
	}
	
	/* (non-Javadoc)
	 * @see com.serviceflow.service.IFizzBuzzService#isBuzz(int)
	 */
	@Override
	public boolean isBuzz(int num) {
		
		return num%BUZZ_DIVISOR==0?true:false;
	}
	
}
