package dgsw.y2.c2.n15;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
	static Scanner scan = new Scanner(System.in);
	
	private int win = 0;
	
	private int draw = 0;
	
	private int lose = 0;
	
	
	/**
	 * 사용자가 입력한 값을 검증한다.
	 * 
	 * @param userInput
	 * @return true 값일때 정상적인 값 입력, false 값일때 잘못입력
	 */
	public boolean checkInput(String userInput) {
		boolean checkResult = false;
		
		switch(userInput) {
			case "가위": case "바위": case "보":
				checkResult = true;
				break;
			case "Q": case "q":
				checkResult = true;
				break;
			default:
				checkResult = false;
				break;
		}
		
		
		return checkResult;
	}
	
	/**
	 * user가 입력한 문자열을 가위,바위,보 규칙에 맞게 정수로 변경한다.
	 * 
	 * @param userInput
	 * @return integer
	 */
	public int getUserRPS(String userInput) {
		int userRPS = 0;
		
		if("가위".equals(userInput)) {
			userRPS = 1;
		}
		else if("바위".equals(userInput)) {
			userRPS = 2;
		}
		else {
			userRPS = 3;
		}
		
		return userRPS;
	}
	
	/**
	 * 컴퓨터가 낼 가위,바위,보를 난수로 받아서 반환한다.
	 * 
	 * @return integer
	 */
	public int getComputerRPS() {
		Random random = new Random();
		
		return random.nextInt(3) + 1;
	}
	
	/**
	 * 게임을 진행한다.
	 * 
	 * @return
	 */
	public String gameProgress() {
		String userInput = "";
		boolean checkResult = false;
		
		while(true) {
			System.out.print("가위, 바위, 보 중 하나를 입력해주세요 (종료: Q/q)\n> ");
			userInput = scan.nextLine();
			
			checkResult = checkInput(userInput);
			
			if(checkResult) {
				break;
			}
			else {
				System.out.println("다시 입력해주세요");
			}
		}
		
		return userInput;
	}
	
	/**
	 * 컴퓨터와 가위바위보를 하여 승패를 가린다.
	 * 
	 * @param userInput
	 */
	public void battleGame(String userInput) {
		int userRPS = getUserRPS(userInput);
		int computerRPS = getComputerRPS();
		
		if(userRPS - computerRPS == 0) {
			System.out.println("비겼습니다~~\n");
			this.draw++;
		}
		else if(Math.abs(userRPS - computerRPS) == 1) {
			if(userRPS - computerRPS == -1) {
				System.out.println("졌습니다 ㅠ\n");
				this.lose++;
			}
			else if(userRPS - computerRPS == 1) {
				System.out.println("이겼습니다 :)\n");
				this.win++;
			}
		}
		else {
			if(userRPS - computerRPS == -2) {
				System.out.println("이겼습니다 :)\n");
				this.win++;
			}
			else if(userRPS - computerRPS == 2) {
				System.out.println("졌습니다 ㅠ\n");
				this.lose++;
			}
		}
	}
	
	/**
	 * 전적을 보여준다.
	 */
	public void gameQuit() {
		System.out.printf("전적: %d승, %d패, %d무", this.win, this.lose, this.draw);
	}
	
	public static void main(String[] args) {
		RockPaperScissorsGame myGame = new RockPaperScissorsGame();
		String userInput = "";
		
		System.out.println("<가위 바위 보 게임>을 시작합니다.");
		
		while(true) {
			userInput = myGame.gameProgress();
			
			if("Q".equals(userInput) || "q".equals(userInput)) {
				break;
			}
			else {
				myGame.battleGame(userInput);
			}
		}
		
		myGame.gameQuit();
		scan.close();
	}

}