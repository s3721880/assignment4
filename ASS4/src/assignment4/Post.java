package assignment4;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Post {
	private  int postID ;
	private  String postTitle;
	private  String postBody;
	private  String [] postTags;
	private  String [] postTypes = {"Very Difficult", "Difficult", "Easy"};
	private  String [] PostEmergency = {"Immediately Needed", "Highly Needed", "Ordinary"};
	private  ArrayList <String> postComments = new ArrayList<>();
	// string of to test body
	private  String string300 = "A character can be any letter, number, punctuation, special character, or space. Each of these characters takes up one byte of space in a computer's memory. Some Unicode characters,"
			+ "																														 like emojis and some letters in non-Latin alphabets, "
			+ "                                     take up two bytes of space and therefore count as two characters. Use our character counter tool below for an accurate count of your characters.";
	//scanner
	 Scanner scanner = new Scanner(System.in);
	 Post(int PostID) {
		postID = PostID;
	}
	
	
	public  boolean addPost()
	{	
		// boolean if creation of post successful or not
		boolean PostTF = true;

		// database location
		String DatabasePath = "C:/Users/Kuro/Desktop/DataBase/";	
		System.out.println("Enter Post Title");
		String text = ".txt";;
		
		postTitle = scanner.nextLine();
		//Create Post.txt file
			// destination String for file creation
			String Destination = DatabasePath + "Post" + Integer.toString(postID) + text;
			// create file
			 Create(Destination);
			 
					// check if post title between 10 and 250 characters
			 			// boolean to see if it meets standards
			 			boolean posthead = true;
			 if((postTitle.length() >= 10) && (postTitle.length() <= 250) ) {
							//check if the first 5 letters of the post title is not number or special characters
							for(int i = 0; i< 4; i++) {
								if( Character.isLetter(postTitle.charAt(i)) == false && Character.isWhitespace(postTitle.charAt(i)) == false ) {
									System.out.println("First 5 Characters of a post is special character or a number");
									posthead = false;
									PostTF = false;
								}
							}
							
							if (posthead = true) {
							// writing title to the destination 
							Write(Destination, "Title: "+postTitle );
							// new line
							Write(Destination, "\n" );
							}
							
							
							//Tags //
							// Printing out difficulty choices
							System.out.println("Enter Difficulty of Post");
							for (int i = 0 ; i < postTypes.length ; i++) {
								System.out.println(postTypes[i]);
							}
							
							String Difficulty = scanner.nextLine();
							
							// add difficulty of post
							if( Difficulty.equals("Easy")) {		
								// Print out urgency choices
								System.out.println("Enter Urgency of Post");
								for (int i = 0 ; i < PostEmergency.length ; i++) {
									System.out.println(PostEmergency[i]);
								}
									//initialize post tag array to size 3 size its easy post
									postTags = new String[3];
									//add difficulty to the first tag
									postTags[0] = "Easy";
									// write post tag to the txt file:
									Write(Destination ,"Post Tags: ");
									Write(Destination , postTags[0]);
									// for loop to add tags to list and to write to the file
									for( int i=1 ; i< postTags.length ; i++) {
										// adding the rest of the tags
										String TagName = scanner.nextLine();
										System.out.println("enter Tag ( 'None' to Skip and 'Stop'  to stop adding):");
										if( TagName.equals("Immediately Needed") || TagName.equals("Highly Needed")  ) {
											System.out.println("Invalid Tag for Easy Difficulty post");
											PostTF = false;
										}
										else if (TagName.equals("None")) {
											//skip does nothing
										}
										else if(TagName.equals("Stop")) {
											break;
										}
										else {
											postTags[i] = TagName;
											Write(Destination ,postTags[i]);
										}
									}
									
									// new line
									Write(Destination, "\n" );
									
										// writing body // 
									System.out.println("Enter Post Body");
									postBody = scanner.nextLine();
									if(postBody.equals("string300")) {
										Write(Destination, string300 );
									}
									else if( postBody.length() < 250) {
										System.out.println("Body size less than 250 characters");
										PostTF = false;
									}
									else {
										Write(Destination , postBody);
									}

							}
							else if(Difficulty.equals("Very Difficult") || Difficulty.equals("Difficult") ) {
								// Print out urgency choices
								System.out.println("Enter Urgency of Post");
								for (int i = 0 ; i < PostEmergency.length ; i++) {
									System.out.println(PostEmergency[i]);
								}
								//initialize post tag array to size 5 
								postTags = new String[5];
								//add difficulty to the first tag
								postTags[0] = Difficulty;
								// write post tag to the txt file:
								Write(Destination ,"Post Tags: ");
								Write(Destination , postTags[0]);
								// adding the rest of the tags
								for( int i=1 ; i< postTags.length ; i++) {
									String TagName = scanner.nextLine();
									System.out.println("enter Tag ( 'None' to Skip and 'Stop'  to stop adding):");
									if( TagName.equals("Ordinary")) {
										System.out.println("Invalid Tag for Easy Difficulty post");
										PostTF = false;
									}
									else if (TagName.equals("None")) {
										//skip does nothing
									}
									else if(TagName.equals("Stop")) {
										break;
									}
									else {
										postTags[i] = TagName;
										Write(Destination ,postTags[i]);
									}
								}
								
								// new line
								Write(Destination, "\n" );

									// writing body // 
								System.out.println("Enter Post Body");
								postBody = scanner.nextLine();
								if(postBody.equals("string300")) {
									Write(Destination, string300 );
								}
								else if( postBody.length() < 300 ) {
									System.out.println("Body size less than 300 characters");
									PostTF = false;
								}
								else {
									Write(Destination, postBody );
								}
								
							}
							
							else {
								System.out.println("Wrong Difficulty Entered");
								// writing body // 
							System.out.println("Enter Post Body");
							postBody = scanner.nextLine();
							if(postBody.equals("string300")) {
								Write(Destination, string300 );
							}
							else if( postBody.length() < 300 ) {
								System.out.println("Body size less than 300 characters");
								PostTF = false;
							}
							else {
								Write(Destination, postBody );
							}
							}
							
						}
			else {
			// error post title being too small or too large
			System.out.println("Post Title Size outside of 300 characters or smaller than 10 characters");
				PostTF = false;
				}
						
		return PostTF;
	}	
	
	public boolean addComment( ) {
		
		String DatabasePath = "C:/Users/Kuro/Desktop/DataBase/";	
		String text = ".txt";;
		//Create Post.txt file
		// destination String for file creation
		String Destination = DatabasePath + "Comment" + Integer.toString(postID) + text;
		Create(Destination);
		int  capacity = 0;
					// set capacity of post comment array based on tags
				for(int i = 0 ; i < postTags.length ; i++ ) {
						if(postTags[i].equals("Easy") || postTags[i].equals("Ordinary") ) {
							// if easy or ordinary set comment size to 3
							capacity = 3;
					}
					else {
							// else set to 5
						capacity = 5;
						}
					}
			postComments.ensureCapacity(capacity);
					String Comment;
					int count = 0;
					// printing postComment size for debugging
					System.out.println(postComments.size());
		  for ( int i = 0 ; i <  capacity; i ++) {
						System.out.println("Enter Comment " + count+1 + " : (type 'leave' to stop adding comments)");
						Comment = scanner.nextLine();
						int wordcount = 0;
						// type leave to stop adding comments
						if (Comment.equals("leave")) {
							break;
						}
						// else to add string to postComments Array
						else {
							// trim white spaces in the front and back of the string
							Comment = Comment.trim();
							
							// check if string has at least 4 words and max of 10
								
									// if string is empty word count = 0
									if(Comment.isEmpty()) {
										wordcount = 0;
										System.out.println("Comment word size not within 4 and 10 words");
										break;
									}
									// check if first letter is capital or not
									else if(!Character.isUpperCase(Comment.charAt(0))) {
										System.out.println("First Letter Not Capital in the comment");
										return false;
									}
									else {
										wordcount = Comment.split("\\s+").length;
										
										if( wordcount >= 4 && wordcount <= 10) {	
											//add comment to the array index
											postComments.add(Comment);
											// write to text file
											Write(Destination,Comment);
											// new line
											Write(Destination, "\n" );
										}
										else {
											System.out.println("Comment word size not within 4 and 10 words");
										}
										
									}
					}
				count++;				
				}
	return true;
 } 
	
	
	//writing to file method
	static void Write( String Destination, String Input ) {
		try {
		      FileWriter myWriter = new FileWriter(Destination , true);
		      BufferedWriter bw = new BufferedWriter(myWriter);
		      bw.write(Input + "\n");
		      bw.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 }

	// creating file method
	static void Create(String Desintation) {
		try {
		      File myObj = new File(Desintation);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	

	public void Menu() {
		System.out.println("Press the following Number");
		System.out.println("1. Create New Post");
		System.out.println("2. Add New Comment");
		System.out.println("3. Show Post ID");
		System.out.println("4. Exit");
	}
	
	
	public void PrintID() {
		System.out.println(postID);
	}
	
	}
	
