package game;

import java.util.Random;

public class RspGame extends Game {
	private Random random = new Random();
	
	private String userInput;
	private String computerInput;
	private String result;
	
	@Override
	protected void showGreeting() {
		System.out.println("안 내면 진다, 가위 바위 보!");
	}

	@Override
	protected void inputUserSelection() {
		System.out.println("가위 바위 보 >> ");
		userInput = scanner.next();
	}

	@Override
	protected void makeComputerSelection() {
		int value = random.nextInt(3);
		
		
		if(value == 0) {
			computerInput = "가위";
		}
		else if(value == 1) {
			computerInput = "바위";
		}
		else {
			computerInput = "보";
		}
	}

	@Override
	protected void decideResult() {
		if(userInput.equals(computerInput)) {
			result = "무승부";
		}
		else if("가위".equals(userInput)) {
			if("보".equals(computerInput)) {
				result = "승리";
			}
			else {
				result = "패배";
			}
		}
		else if("바위".equals(userInput)) {
			if("가위".equals(computerInput)) {
				result = "승리";
			}
			else {
				result = "패배";
			}
		}
		else if("보".equals(userInput)) {
			if("바위".equals(computerInput)) {
				result = "승리";
			}
			else {
				result = "패배";
			}
		}
		
	}

	@Override
	protected void showResult() {
		System.out.println("User : " + userInput + "Computer : " + computerInput);
		System.out.println("결과 : " + result);
		
	}
	

	public static void main(String[] args) {
		RspGame rsp = new RspGame();
		
		rsp.executeGame();
	}
	
}
