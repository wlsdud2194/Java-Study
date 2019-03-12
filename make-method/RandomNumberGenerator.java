package dgsw.y2.c2.n15;

import java.util.Arrays;
import java.util.Random;

/**
 * @author LeeJin
 *
 */
public class RandomNumberGenerator 
{
	private int minimumValue = 0;
	
	private int maximumValue = 100;
	
	private int countOfRandomValues = 5;
	
	/**
	 * 난수 발생 범위의 최소값을 지정한다.
	 * 
	 * @param value
	 */
	public void setMinimum(int value) {
		this.minimumValue = value;
	}
	
	/**
	 * 난수 발생 범위의 최대값을 지정한다.
	 * 
	 * @param value
	 */
	public void setMaximum(int value) {
		this.maximumValue = value;
	}
	
	
	/**
	 * 난수를 몇 개 생성해야할지 지정한다
	 * 
	 * @param number 생성한 난수의 개수
	 */
	public void setCountOfRandomValues(int number) {
		this.countOfRandomValues = number;
	}
	
	/**
	 * 난수를 발생시킨다
	 * 
	 * @return 발생시킨 난수 배열
	 */
	public int[] generateRandomValue() {
		Random random = new Random();
		int[] result = 
				new int[this.countOfRandomValues];
		
		for(int i = 0; i<countOfRandomValues; i++) {
			result[i] = random.nextInt(this.maximumValue) + this.minimumValue;
		}
		
		return result;
	}
	
	/**
	 * 주어진 정수 배열을 출력한다
	 * 
	 * @param numbers 정수 배열
	 */
	public static void printValues(int[] numbers) {
		System.out.println(Arrays.toString(numbers));
	}
	
	public static void main(String[] args) {
		RandomNumberGenerator generator = new RandomNumberGenerator();
		
		generator.setMinimum(-5);
		generator.setMaximum(5);
		generator.setCountOfRandomValues(5);
		
		int[] numbers = generator.generateRandomValue();
		
		RandomNumberGenerator.printValues(numbers);
	}
}
