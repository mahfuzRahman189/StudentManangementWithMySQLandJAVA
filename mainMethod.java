import java.util.Scanner;

public class mainMethod {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DB connect=new DB();
		int det=1;
		do {
		System.out.println("Student Management System");
		System.out.print("Operations:\n1.Insert\n2.Read\n3.Update\n4.Delete\nPress any one option: ");
		int command=sc.nextInt();
		
		switch(command){
			case 1:
				connect.insert();
				break;
			case 2:
				connect.read();
				break;
			case 3:
				connect.update();
				break;
			case 4:
				connect.delete();
				break;
				default:
					System.out.println("Invalid input");
		}
		
		System.out.print("Press 0 to exit or any number to continue: ");
		det=sc.nextInt();
		
		if(det!=0)
		{
			connect.concoleClear();
		}
		
		}while(det!=0);
		
		System.out.println("Program ended");
		
	}
	
}
