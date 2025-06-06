import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode circle;     // a PersonNode pointer that tracks first node
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       
   private PersonNode track;      // a PersonNode pointer to help with elimination

   public JosephusSim(String fileName) {
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         PersonNode lastNode = null;
         
         while(file.hasNextLine()){
            String line = file.nextLine();
            if(circle == null){
              circle = new PersonNode(line);
              lastNode = circle;
            }else{
                 lastNode.next = new PersonNode(line);
                 lastNode = lastNode.next;

               
              
               
            }
            size++;
            
         }
         
         // make the ring circular by attaching last node's next to front
         if(circle != null && lastNode != null){
             lastNode.next = circle;
         }
         
         // remember the last node as the one in front of the next to get eliminated
         track = lastNode;
         
         // generate, print, and save the random elimination count
         Random r = new Random();
         if(size > 0){
            eliminationCount = r.nextInt(size/2) + 1;
         
         }else{
            eliminationCount = 1;
         
         }
         
         

      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
   }
   
   public void eliminate() {
      // count to the elimination count
      
      // print who will be eliminated
      
      // eliminate the person and update "front" of the circle and size

   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return size == 1;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      
      // print the remaining survivors (watch out for infinite loop since list is circular)

      return "";
   }

}