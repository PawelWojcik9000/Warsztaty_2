package admin;
 
import java.util.Scanner;  
import sql.DbManager;


public class Application {
	static Scanner scaner;
	public static void main(String[] args) {
		scaner = new Scanner(System.in);
		while(true){
			System.out.println("Wybierz moduł: user, excercise, group:");
			String action = scaner.nextLine();
			if(action.equals("user")){
				UserAdmin.prompt();
				
			}else if(action.equals("excercise")){
				ExcerciseAdmin.prompt();
			}else if(action.equals("group")){
				GroupAdmin.prompt();
			}else {
				System.out.println("Podałeś nieprawidłowy moduł");
			}
		}
		
	}
	public static boolean areYouSurePrompt(){
		boolean areYouSure = false;
		boolean isCorrect = false;
		while(!isCorrect){
			System.out.println("Czy na pewno chcesz usunąć rekord (T/n)?");
			if(Application.scaner.hasNextLine()){
				String action = Application.scaner.nextLine();
				if(action.equals("T")){
					isCorrect = true;
					areYouSure = true;
				}else if(action.equals("n")){
					isCorrect = true;
					areYouSure = false;
				}else{
					System.out.println("Podałeś nieprawidłową akcję. Spróbuj ponownie.");
				}
			}
		}
		return areYouSure;
	}
	public static void closeApplication(){
		DbManager.close();
		System.exit(0);
	}
}
