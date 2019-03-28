package game;

import java.util.ArrayList;
import java.util.Random;

public class LottoGame extends Game {
	private Random random = new Random();
	
	private ArrayList<Integer> userInput;
	private ArrayList<Integer> computerSelection;
	
	private int countOfMatched = 0;

	@Override
	protected void showGreeting() {
		System.out.println("로또 게임 - 로또는 인생을 바꾼다.");
		
	}

	@Override
	protected void inputUserSelection() {
		userInput = new ArrayList<Integer>();
		
		for(int i = 0; i < 3; i++) {
			userInput.add(inputEachUserSelection(i));
		}
	}
	
	// 각각의 번호 입력
	private int inputEachUserSelection(int i) {
		System.out.println((i + 1) + "번째 번호를 입력하세요.");
		return scanner.nextInt();
	}

	@Override
	protected void makeComputerSelection() {
		computerSelection = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			computerSelection.add(makeEachComputerSelection());
		}
	}
	
	// 랜덤 로또 번호 생성
	private int makeEachComputerSelection() {
		int value;
		
		while(true) {
			value = random.nextInt(10) + 1;
			
			if(!isDuplicated(value)) {
				break;
			}
		}
		
		return value;
	}
	
	// 중복체크
	private boolean isDuplicated(int value) {
		for(int item : computerSelection) {
			if(value == item) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	protected void decideResult() {
		countOfMatched = 0;
		
		for(int user : userInput) {
			for(int computer : computerSelection) {
				if(user == computer) {
					countOfMatched++;
				}
			}
		}
		
	}

	@Override
	protected void showResult() {
		System.out.println("User : " + userInput.toString());
		System.out.println("Computer : " + computerSelection.toString() + "\n");
		
		switch(countOfMatched) {
		case 3:
			System.out.println("30억 당첨");
			break;
		case 2:
			System.out.println("1억 당첨");
			break;
		case 1:
			System.out.println("1만원 당첨");
			break;
		case 0:
			System.out.println("꽝입니다.");
			break;
		}
	}
	
	
	public static void main(String[] args) {
		LottoGame lotto = new LottoGame();
		
		lotto.executeGame();
	}

}
