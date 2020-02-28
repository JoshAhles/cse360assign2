/** 
 * Name: Joshua Ahles
 * Class ID: 162
 * Assignment 2
 * This assignment is designed to give you practice with using a version control system.
*/


package CSE360assign2;

public class SimpleList {
   
   private int list[];
   private int count;
   private int size;

   //Create an array to hold 10 integers and set count to 0.
   public SimpleList() {
       this.count = 0;
       list = new int[10];
       this.size = 10;
   }

   
   //Add the parameter to the list at the beginning (index = 0). Increment the count as needed.
   public void add(int num) {
       if (count == 0) {
           list[count] = num;
           count++;
       } else if (count < size) {
           for (int indexLocation = count; indexLocation >= 0; indexLocation--) {
               list[indexLocation + 1] = list[indexLocation];
           }
           
           list[0] = num;
           count++;
           
       } else {
    	   
    	   int newLength = size + (size/2);
    	   int[] newList = new int [newLength];
    	   newList[0] = num;
    	   
           for (int indexLocation = count; indexLocation >= 0; indexLocation++) {
               newList[indexLocation + 1] = list[indexLocation];
           }
           
           list = newList;
           size = newLength;
           
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
           
           if ((count>1) && (size - count > size / 4))
           {
        	   decreaseSize();
           }
       } 
    	   
       
   }
   
   
   //The append method should append the parameter to the end of the list.  
   //If the list was full, then increase the size by 50% so there will be room.  
   public void append(int num) {
	   if (count == 0) {
		   list[0] = num;
		   
	   }
	   else {
		   if (count < size) {
			   list[count] = num;
			   
		   }
		   else {
			   
			   	int newLength = size + (size/2);
				int[] newList = new int[newLength];
				for (int indexLocation = 0; indexLocation < count; indexLocation++) {
					newList[indexLocation] = list[indexLocation];
				}
				newList[count] = num;
				list = newList;
				size = newLength;
			}
		}
	
	   count++;
   }
   
   
   //Return the first element in the list.  If there are no elements n the list, then return -1.
   public int first() {
	   if (count > 0) {
		   return list[0];
		   
	   }
	   else {
		   return -1;
	   }
   }
   
   //Return the last element in the list.  If there are no elements n the list, then return -1.
   public int last() {
	   if (count > 0) {
		   return list[count-1];
		   
	   }
	   else {
		   return -1;
	   }
   }
   
   
   //Return the current number of possible locations in the list
   public int size() {
	   return size;
   }
	   

   private void decreaseSize() {
	// TODO Auto-generated method stub
	   int newLength;
	   int[] newList;
	   
	   newLength = size - size / 4;
	   newList = new int[newLength];
	   
	   for(int indexLocation = 0; indexLocation < count; indexLocation++) {
		   newList[indexLocation] = list[indexLocation];
	   }
	   
	   list = newList;
	   size = newLength;
	
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