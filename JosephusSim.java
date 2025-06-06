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
     if(isOver()){
       return;
     }
      // count to the elimination count
      for(int i = 0; i < eliminationCount -1; i++){
         track = track.next;
      }
      
      // print who will be eliminated
      PersonNode eliminatedPerson = track.next;
      System.out.println(eliminatedPerson.name +  " is eliminated");
      
      // eliminate the person and update "front" of the circle and size
      track.next = eliminatedPerson.next;
      if(circle == eliminatedPerson){
          circle = eliminatedPerson.next;
      }
      size--;

   }
   
   
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return size == 1;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      if(isOver()){
         return circle.name + "  is the last survivor!";

      }
      
      // print the remaining survivors (watch out for infinite loop since list is circular)
      StringBuilder sb = new StringBuilder("Remained survivors: ");
      PersonNode cur = circle;
      int count = 1;
      
      if(cur != null){
        do {
            sb.append(count).append("-").append(cur.name);
            cur = cur.next;
            if (cur != circle) { 
               sb.append(", ");
            }
            count++;
         } while (cur != circle);
      }
      

      return sb.toString();
   }

}
     /* PROGRAM OUTPUT
     
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Nate, 6-Cameron, 7-Mohamed, 8-Adrian, 9-Abner, 10-Tom, 11-Egor, 12-Wissal, 13-Shunyun, 14-Percy, 15-Antonio, 16-Aziz, 17-Biruk, 18-Max, 19-Jason, 20-Riane, 21-Matthew

Continue elimination? <press enter>

Abner is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Nate, 6-Cameron, 7-Mohamed, 8-Adrian, 9-Tom, 10-Egor, 11-Wissal, 12-Shunyun, 13-Percy, 14-Antonio, 15-Aziz, 16-Biruk, 17-Max, 18-Jason, 19-Riane, 20-Matthew

Continue elimination? <press enter>

Max is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Nate, 6-Cameron, 7-Mohamed, 8-Adrian, 9-Tom, 10-Egor, 11-Wissal, 12-Shunyun, 13-Percy, 14-Antonio, 15-Aziz, 16-Biruk, 17-Jason, 18-Riane, 19-Matthew

Continue elimination? <press enter>

Cameron is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Nate, 6-Mohamed, 7-Adrian, 8-Tom, 9-Egor, 10-Wissal, 11-Shunyun, 12-Percy, 13-Antonio, 14-Aziz, 15-Biruk, 16-Jason, 17-Riane, 18-Matthew

Continue elimination? <press enter>

Aziz is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Nate, 6-Mohamed, 7-Adrian, 8-Tom, 9-Egor, 10-Wissal, 11-Shunyun, 12-Percy, 13-Antonio, 14-Biruk, 15-Jason, 16-Riane, 17-Matthew

Continue elimination? <press enter>

Nate is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Mohamed, 6-Adrian, 7-Tom, 8-Egor, 9-Wissal, 10-Shunyun, 11-Percy, 12-Antonio, 13-Biruk, 14-Jason, 15-Riane, 16-Matthew

Continue elimination? <press enter>

Biruk is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Mohamed, 6-Adrian, 7-Tom, 8-Egor, 9-Wissal, 10-Shunyun, 11-Percy, 12-Antonio, 13-Jason, 14-Riane, 15-Matthew

Continue elimination? <press enter>

Adrian is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Mohamed, 6-Tom, 7-Egor, 8-Wissal, 9-Shunyun, 10-Percy, 11-Antonio, 12-Jason, 13-Riane, 14-Matthew

Continue elimination? <press enter>

Matthew is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Mohamed, 6-Tom, 7-Egor, 8-Wissal, 9-Shunyun, 10-Percy, 11-Antonio, 12-Jason, 13-Riane

Continue elimination? <press enter>

Shunyun is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Mohamed, 6-Tom, 7-Egor, 8-Wissal, 9-Percy, 10-Antonio, 11-Jason, 12-Riane

Continue elimination? <press enter>

Mohamed is eliminated
Remained survivors: 1-Brian, 2-Delon, 3-Aryton, 4-Eli, 5-Tom, 6-Egor, 7-Wissal, 8-Percy, 9-Antonio, 10-Jason, 11-Riane

Continue elimination? <press enter>

Delon is eliminated
Remained survivors: 1-Brian, 2-Aryton, 3-Eli, 4-Tom, 5-Egor, 6-Wissal, 7-Percy, 8-Antonio, 9-Jason, 10-Riane

Continue elimination? <press enter>

Riane is eliminated
Remained survivors: 1-Brian, 2-Aryton, 3-Eli, 4-Tom, 5-Egor, 6-Wissal, 7-Percy, 8-Antonio, 9-Jason

Continue elimination? <press enter>

Jason is eliminated
Remained survivors: 1-Brian, 2-Aryton, 3-Eli, 4-Tom, 5-Egor, 6-Wissal, 7-Percy, 8-Antonio

Continue elimination? <press enter>

Brian is eliminated
Remained survivors: 1-Aryton, 2-Eli, 3-Tom, 4-Egor, 5-Wissal, 6-Percy, 7-Antonio

Continue elimination? <press enter>

Eli is eliminated
Remained survivors: 1-Aryton, 2-Tom, 3-Egor, 4-Wissal, 5-Percy, 6-Antonio

Continue elimination? <press enter>

Wissal is eliminated
Remained survivors: 1-Aryton, 2-Tom, 3-Egor, 4-Percy, 5-Antonio

Continue elimination? <press enter>

Tom is eliminated
Remained survivors: 1-Aryton, 2-Egor, 3-Percy, 4-Antonio

Continue elimination? <press enter>

Egor is eliminated
Remained survivors: 1-Aryton, 2-Percy, 3-Antonio

Continue elimination? <press enter>

Aryton is eliminated
Remained survivors: 1-Percy, 2-Antonio

Continue elimination? <press enter>

Percy is eliminated
Antonio  is the last survivor!

*/