package assignment4;


import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int id = 1;
		int userinput;
		
		Post post = new Post(id);
				while(true){
					
						post.Menu();
						userinput = scanner.nextInt();
						// if userinput is 1 call addpost() //
						if( userinput == 1) {
							 post = new Post(id);
							 Boolean TF = post.addPost();
							if(TF == true) {
								System.out.println("Post Created");
								id++;
							}
							else {
								System.out.println("Fail to create Post");
							}
						}
						
						// if userinput is 1 call addcomment() //
						else if (userinput == 2) {
							Boolean TF = post.addComment();
							if(TF == true) {
								System.out.println ("Comments Added");
							}
							else if(TF == false) {
								System.out.println("Comments Cannot be Added");
							}
						// check post id
						}
						else if (userinput==3) {
							post.PrintID();
						}
						
						// end program//
						else if (userinput==4) {
							System.out.println("End");
							break;
						}
						
						// Else wrong input try again//
						else {
							System.out.println("Wrong Input Try Again");
						}	
					}
	      }
}
