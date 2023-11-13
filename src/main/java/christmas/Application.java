package christmas;

import java.util.HashMap;

import input.InputView;
import output.OutputView;

public class Application {
	private static int date;
	private static HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();

    public static void main(String[] args) {
    	
    	InputView input = new InputView();
    	date = input.getdate();
    	inputMenu = input.getInputMenu();
    	
    	int totalOrderAmount = totalOrderAmount();
    	boolean applyEvent = applyEvent(totalOrderAmount);
    	
    	OutputView output = new OutputView(date, inputMenu, totalOrderAmount, applyEvent);
    	output.view();
    	
    }
    
    private static int totalOrderAmount(){
    	int amount = 0;
    	for(Menu menu : inputMenu.keySet()) {
    		amount = amount + menu.price() * inputMenu.get(menu);
    	}
    	return amount;
    }
    
    private static boolean applyEvent(int totalOrderAmount){
    	if (totalOrderAmount < 10000 ) {
    		return false;
    	}
    	return true;
    }
    
    
}
