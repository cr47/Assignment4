import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author calvin
 */
public class TestLinkedList{
   MyLinkedList[] list = new MyLinkedList[26]; // list contains 26 null references   
   
        long wordsFound = 0; 
        long wordsNotFound = 0;
        double compsFound = 0;
        double compsNotFound = 0;
        
    public static void main(String[] args) {
          TestLinkedList run = new TestLinkedList();
          run.readFile();
          run.readOliver();               
    }
    
    public TestLinkedList(){
          for(int i = 0 ; i< list.length; i++)    
                list[i] = new MyLinkedList<String>(); // each array element contains a new MyLinkedList
    }
    
       /**
     * @pre: declares a value for the start position
     * @post: this file is split line by line and the whitespace is trim back and the 
     * letters are changed to lowercase
     */
    public void readFile () {
      
       
        
        
       try {
           File file = new File("random_dictionary.txt");  // opens the file
           Scanner in = new Scanner(file); // reads the file
           
       
       		while(in.hasNext()) // splits the file
                {
                  
                    
                 String word = in.nextLine().trim().toLowerCase(); // reads next line, trims the white space, changes everything to lowercase letters
                  
                 
                 list[word.charAt(0) - 97].addFirst(word);
                                     
		}
                
                in.close();
       }
                catch (IOException e) {
                        e.printStackTrace();
                        }
    }   
    
    /**
     *@pre: creates a try catch to make sure it reads file
     * @post: will read every character with and not any special characters.
     * @output: this will read the file oliver and parse the String and will 
     * the output method from this section
     */
    public void readOliver () {
         try{             
        FileInputStream inf = new FileInputStream(new File("Oliver.txt"));
        char let;
        String str=""; //word to be processed
        int n = 0;
        while((n = inf.read())!= -1) {
            let = (char)n;
            if (Character.isLetter(let))
                str += Character.toLowerCase(let);
            if ((Character.isWhitespace(let)|| let =='-')&& !str.isEmpty()) {
                //insert word to a data structure here
               
            if ( list[(int)str.charAt(0)-97].contains(str)){
                wordsFound++; 
                compsFound += (double)list[(int)str.charAt(0)-97].count();
            } else{
              wordsNotFound++; 
            
                 compsNotFound += (double)list[(int)str.charAt(0)-97].count();
            }
               
                str="";          
            }  
           //compsFound = 0; // resets back to zero
           
          
        }
        inf.close();
        outputInfo();
       }
       
       catch (IOException e) {
           e.printStackTrace();
       }
    }    
    
   

    /**
     *@pre: empty
     * @post: none
     * @output: this section outputs the averages and the number of correct and incorrect words... 
     */
    public void outputInfo () {
        System.out.println("number of incorrect words: " + wordsNotFound);
        System.out.println("average number of incorrect comparisons: " + compsNotFound / wordsNotFound );
        System.out.println("number of corrrect words: " + wordsFound);
        System.out.println("average of correct comparisons: " + compsFound / wordsFound );
    }
}
