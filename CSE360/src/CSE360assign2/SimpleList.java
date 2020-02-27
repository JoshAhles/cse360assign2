/** 
 * Name: Joshua Ahles
 * Class ID: 162
 * Assignment 1
 * Class demonstrating a Simple List using methods to manipulate it
*/


package CSE360assign2;

public class SimpleList {
   
   private int list[];
   private int count;

   //Create an array to hold 10 integers and set count to 0.
   public SimpleList() {
       this.count = 0;
       list = new int[10];
   }

   
   //Add the parameter to the list at the beginning (index = 0). Increment the count as needed.
   public void add(int num) {
       if (count == 0) {
           list[count] = num;
           count++;
       } else if (count < 10) {
           for (int indexLocation = count; indexLocation >= 0; indexLocation--) {
               list[indexLocation + 1] = list[indexLocation];
           }
           
           list[0] = num;
           count++;
           
       } else {
    	   
           list[count - 1] = 0;
           for (int indexLocation = count; indexLocation >= 0; indexLocation--) {
               list[indexLocation + 1] = list[indexLocation];
           }
           
           list[0] = num;
           count++;
           
       }
   }
   
   //If the parameter is in the list, then remove it. 
   public void remove(int num) {
       int index = search(num);

       if (index != -1) {
           //left shift
           for (int indexLocation = index; indexLocation < count - 1; indexLocation++) {
               list[indexLocation] = list[indexLocation + 1];
           }
           //remove element
           count--;
       } 
    	   
       
   }

   //Return the number of elements stored in the list.
   public int count() {
	   
       return count;
       
   }

   //Return the location of the parameter in the list.  If the parameter is not in the list, then return -1. 
   public int search(int num) {
       int index = -1;
       for (int indexLocation = 0; indexLocation < count; indexLocation++) {
           if (list[indexLocation] == num) {
               index = indexLocation;
           }
       }
       
       return index;
   }

   //Return the list as a String.  The elements must be separated by a space.  This means there is not space after the last integer.
   public String toString() {
       String str = "";
       for (int indexLocation = 0; indexLocation < count; indexLocation++) {
           str += list[indexLocation];
           if (indexLocation != count - 1) {
               str += " ";
           }
       }
       return str;
   }

}