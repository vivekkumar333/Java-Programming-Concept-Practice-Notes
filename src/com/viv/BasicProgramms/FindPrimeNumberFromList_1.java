package com.viv.BasicProgramms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindPrimeNumberFromList_1 {
	public static void main(String []ar) {
		//findTheListOf_PrimeNumber();		// Find List of Prime Number
		
		findTheListOf_PrimeNumberFrom_Array(); 	// Find Array of Prime Number from Integer array
	}

	
	public static void findTheListOf_PrimeNumberFrom_Array() {
		
		int numbers[] = new int[] {1,2,6,8,10,5,55,11,57};
		
		int primeNumbers[] = new int[numbers.length];
		
		int primeIndex=0; 
		
		for(int i=0; i < numbers.length; i++) {
			boolean primeFlag=true;
			if(numbers[i] <= 1) continue;
			if(numbers[i] == 2){
				primeNumbers[primeIndex]=numbers[i];
				primeIndex++;
				continue;
			}
			if(numbers[i] %2==0) continue;
					
			for(int j=3; j<= Math.sqrt(numbers[i]); j+=2) {
				if(numbers[i] % j==0) {
					primeFlag=false;
					break;
				} 
			}
			if(primeFlag) {
				primeNumbers[primeIndex]=numbers[i];
				primeIndex++;	
			}
			
		}
	
		System.out.println("Print all the prime number: ");
		primeIndex=0;
		while(primeIndex < primeNumbers.length) {
			System.out.println(primeNumbers[primeIndex]);
			primeIndex++;
		}
		
	}
	
	
	public static void findTheListOf_PrimeNumber() {
		
		List<Integer> numberList = Arrays.asList(1,2,6,8,10,5,55,11,57);
		
		List<Integer> primeList= numberList.stream().filter(num->{
			if(num <= 1) return false;
			if(num == 2) return true;
			if(num % 2==0) return false;
					
			for(int i=3; i<= Math.sqrt(num); i+=2) {
				if(num % i==0) return false;
			}
			return true;
		}).collect(Collectors.toList());
		
		primeList.forEach(System.out::println);
	}
}
