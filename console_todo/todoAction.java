package java_task;

import java.util.ArrayList;
import java.util.Scanner;

public class todoAction {
	static Scanner sc = new Scanner(System.in);
	static String line = "\n-----------------------------------------------\n";
	
	// 일정표 생성
	public static void createTodo(ArrayList<Todo> todoList) {
		
		System.out.printf("일정을 입력해주세요.\n> ");
		String userInput = sc.nextLine();
		
		Todo newTodo = new Todo();
		newTodo.id = Todo.getId();
		newTodo.body = userInput;
		
		System.out.println("\n일정이 추가되었습니다."+line);
		todoList.add(newTodo);
	}
	
	// 일정표 확인
	public static void getTodos(ArrayList<Todo> todoList) {
		if(todoList.size()>0) {
			System.out.printf(line);
			for(Todo value : todoList) {
				String done = (value.done) ? "완료" : "아직안됨";
				System.out.println("id: "+value.id+" -- "+value.body+" -- 수행: "+done);
			}
			System.out.printf(line);
		}
		else {
			System.out.println(line+"입력된 일정이 없습니다."+line);
		}
	}
	
	// 일정 수행
	public static void completeTodo(ArrayList<Todo> todoList) {
		getTodos(todoList);
		
		System.out.printf("완료할 일정에 id를 입력해주세요.\n> ");
		String userInput = sc.nextLine();
		
		try {
			int chooseNum = Integer.parseInt(userInput);
			for(Todo value : todoList) {
				if(value.id == chooseNum) {
					value.done = !(value.done);
					System.out.println(line+"수행을 변경하였습니다."+line);
					return;
				}
			}
			System.out.println(line+"없는 id 입니다"+line);
		}
		catch(Exception err) {
			System.out.println("잘못 입력하셨습니다"+line);
		}
	}
	
	// 수행한 일정 삭제
	public static void deleteTodos(ArrayList<Todo> todoList) {
		if(todoList.size() == 0) {
			System.out.println(line+"삭제할 일정이 없습니다."+line);
		}
		
		todoList.removeIf(n->(n.done==true));
		System.out.println(line+"완료한 일정을 삭제 하였습니다!!"+line);
	}

}
