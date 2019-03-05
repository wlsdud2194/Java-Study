package java_task;

import java.util.ArrayList;

// Todo 클래스 선언
class Todo {
	static int listId = 0;
	
	int id=0;
	String body = "";
	boolean done = false;
	
	static int getId() {
		listId++;
		return listId;
	}
}

// todoAction을 상속받음
public class todoList extends todoAction{
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Todo> todoList = new ArrayList<>();	
		System.out.println("일정관리앱 투두리스트");
		
		//입력 루프
		appLoop: while(true) {
			System.out.printf("1.일정보기  2.일정 생성  3.수행 완료 설정  4.완료된 일정 삭제  5.종료하기\n> ");
			String userInput = sc.nextLine();
			
			 switch(userInput) {
			 	case "1":
					getTodos(todoList);
					break;
					
				case "2":
					createTodo(todoList);
					break;
					
				case "3":
					completeTodo(todoList);
					break;
					
				case "4":
					deleteTodos(todoList);
					break;
					
				case "5":
					System.out.print("앱을 종료합니다");
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					break appLoop;
					
				default: 
					System.out.println("잘못 입력하셨습니다.\n");
			}
		}
	}

	
}