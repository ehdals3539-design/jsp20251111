package com.saeyan.controlle;

import com.saeyan.controlle.Action.Action;
import com.saeyan.controlle.Action.FruitControltAction;
import com.saeyan.controlle.Action.FruitHomeAction;
import com.saeyan.controlle.Action.FruitItemAction;
import com.saeyan.controlle.Action.FruitJoinAction;
import com.saeyan.controlle.Action.FruitJoinFormAction;
import com.saeyan.controlle.Action.FruitNDPAction;
import com.saeyan.controlle.Action.FruitPDPAction;
import com.saeyan.controlle.Action.FruitRequestAction;
import com.saeyan.controlle.Action.FruitFindIdAction;
import com.saeyan.controlle.Action.FruitFindIdFormAction;
import com.saeyan.controlle.Action.FruitFindPwAction;
import com.saeyan.controlle.Action.FruitFindPwFormAction;
import com.saeyan.controlle.Action.FruitIdCheckAction;
import com.saeyan.controlle.Action.FruitUDPAction;
import com.saeyan.controlle.Action.FruitUpdateAction;
import com.saeyan.controlle.Action.FruitloginAction;


public class ActionFactory{

private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("fruit_home")) {
			action = new FruitHomeAction();
			
		}else if (command.equals("fruit_login")) {
			action=new FruitloginAction();
			
		}else if (command.equals("fruit_Request")) {
			action=new FruitRequestAction();
			
		}else if (command.equals("fruit_Control")) {
			action=new FruitControltAction();
			
		}else if (command.equals("fruit_Item")) {
			action=new FruitItemAction();
			
		}else if (command.equals("fruit_Join")) {
		    // 회원가입 화면 표시
		    action = new FruitJoinFormAction();

		}else if (command.equals("fruit_join_action")) {
		    // 회원가입 처리
		    action = new FruitJoinAction();
		

		}else if (command.equals("fruit_PDP")) {
			action=new FruitPDPAction();
			
		}else if (command.equals("fruit_NDP")) {
			action=new FruitNDPAction();
			
		}else if (command.equals("fruit_UDP")) {
			action=new FruitUDPAction();
		}else if(command.equals("fruit_edit")) {
		}else if (command.equals("fruit_update")) {
			action = new FruitUpdateAction();
		}else if (command.equals("fruit_find_id_form")) {
			action = new FruitFindIdFormAction();
		}else if (command.equals("fruit_find_id_action")) {
			action = new FruitFindIdAction();
		}else if (command.equals("fruit_find_pw_form")) {
			action = new FruitFindPwFormAction();
		}else if (command.equals("fruit_find_pw_action")) {
			action = new FruitFindPwAction();
		}else if (command.equals("fruit_id_check")) {
			action = new FruitIdCheckAction();
		} 
		


		
		return action;
	}
}
