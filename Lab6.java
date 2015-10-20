import java.util.Scanner;
import java.io.*;

public class Lab6{

   public static void main(String[] args){
   
      Scanner sc = new Scanner(System.in);
      
      System.out.print("How large would you like your world? >");
      int wSize = sc.nextInt();
      char [] univ = new char[wSize]; //create array of input size
      univ = generateUniverse(wSize);
      
      System.out.println(univ);
      
      boolean run= true;
      String rb = sc.nextLine();
        while (run){
          String aqs = sc.nextLine();
          
            switch (aqs){ //user inputs
               case "q":
               case "Q":
                  run = false;
                  break;
               case "s":
               case "S":
                  save(univ);
                  System.out.println(univ);
                  break;
               case "a":
               case "A":
                  runUniverse(univ);
                  System.out.println(univ);
                  break;
               default:
                  System.out.println("Try that again, matey."); //run-time error prevention
                  
            }
         }  
   }
      public static char[] generateUniverse(int wSize){ //creating the visual universe.
      
         char [] univ = new char[wSize]; 
         univ [0] = '0';
         
         for( int i = 1; i < wSize; i++){
            
            if(i % 5== 0){
               univ [i] = '^';
               
            }else if (i % 7 == 0){
               univ [i] = '0';
               
            }else{          
               univ [i] = '.';
            }
         }
      return univ;
      }
      
      public static void save(char[] univ){ //method for saving world
         File doc = new File ("univSim.txt");
         PrintWriter pw = null;
          
         try{
            pw = new PrintWriter(doc);
            for(int i = 0; i < univ.length; i++){
               pw.print(univ[i]);
            }   
             pw.println();
             int bs = 0;
             int cs = 0;
             int as = 0;
             
             for(int i = 0; i < univ.length; i++) {
               if(univ[i] == '0'){
                  bs += 1;
               }else if(univ[i] == '1'){
                  cs += 1;
               }else if(univ[i] == '2'){
                  as += 1;
               }
             }
             pw.println(bs + " babies");
             pw.println(cs + " children");
             pw.println(as + " adults");
             pw.close();
          }
          catch(IOException e)
          {
            e.printStackTrace();     
          }      
      }
      
      public static void runUniverse(char[] univ){ //method to advance to next gen
         
         int wSize = univ.length;
         
         for (int i = 0; i < wSize; i++){
            if (univ[i] == '0'){
               univ[i] = '1';
               
            }else if (univ[i] == '1'){
               univ[i] = '2';
               
            }else if (i + 1 < wSize && univ[i] == '2' && univ[i + 1] == '.'){
              univ[i] = '.';
              univ[i + 1] = '0';
              i++; 
            }else if (i + 1 < wSize && univ[i] == '2' && univ[i + 1] == '^'){
               univ[i] = '.';
               univ[i + 1] = '0';
               i++;
            }                             
         }
       }      
}
         