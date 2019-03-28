package game;

import java.util.Scanner;

public abstract class Game {
	protected Scanner scanner = new Scanner(System.in);
	
	// 게임을 진행함
	public void executeGame() {
		while(true) {
			showGreeting();
			inputUserSelection();
			makeComputerSelection();
			decideResult();
			showResult();
		
			if(againGame()) {
				break;
			}
		}
		
		scanner.close();
	}
	
	// 인사말을 보여줌
	protected abstract void showGreeting();
	
	// 사용자의 입력을 받음
	protected abstract void inputUserSelection();
	
	// 컴퓨터의 난수를 받음
	protected abstract void makeComputerSelection();
	
	// 결과를 판정
	protected abstract void decideResult();
	
	// 결과를 보여줌
	protected abstract void showResult();
	
	// 재시작을 물어봐줌
	protected boolean againGame() {
		System.out.println("게임을 다시 하시겠습니까?(Y or N)");
		String again = scanner.next();
		
		if("Y".equals(again)) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
