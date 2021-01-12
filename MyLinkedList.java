public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
 }
 public int size() {
   return this.size;
 }
 public boolean add(String value) {
   Node another = new Node(value);
   if (size == 0) {
     start = another;
     end = another;
   } else {
     another.setPrev(end);
     end.setNext(another);
     end = another;
   }
   size++;
   return true;
}
 public void add(int index, String value) {
   if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node another = new Node(value);
   if (size == 0) {
     start = another;
     end = another;
   } else if (index == 0) {
     start.setPrev(another);
     another.setNext(start);
     start = another;
   } else if (index == size) {
     another.setPrev(end);
     end.setNext(another);
     end = another;
   } else {
     Node current = start;
     for (int i = 0; i < size; i++) {
       if (i == index) {
         current.getPrev().setNext(another);
         another.setPrev(current.getPrev());
         current.setPrev(another);
         another.setNext(current);
       }
       current = current.getNext();
     }
   }
   size++;
 }
 public String get(int index) {
   if (index < 0 || index >= size) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node ans = start;
   int i = 0;
   while (i != index) {
       ans = ans.getNext();
       i++;
   }
   return ans.getData();
 }
 public String set(int index, String value) {
   if (index < 0 || index >= size) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node another = new Node(value);
   Node replaced = new Node(get(index));
   if (index == 0) {
     start.getNext().setPrev(another);
     another.setNext(start.getNext());
     start = another;
   } else if (index == size - 1) {
     end.getPrev().setNext(another);
     another.setPrev(end.getPrev());
     end = another;
   } else {
     Node current = start;
     for (int i = 0; i < size; i++) {
       if (i == index) {
         current.getPrev().setNext(another);
         another.setPrev(current.getPrev());
         current.getNext().setPrev(another);
         another.setNext(current.getNext());
       }
       current = current.getNext();
     }
   }
   return (replaced.getData());
 }
 public String toString() {
   if (size == 0) {
     return ("[]");
   }
   Node addition = start;
   String ans = ("[" + addition.getData());
   while (addition.getNext() != null) {
     addition = addition.getNext();
     ans += (", " + addition.getData());
   }
   return (ans + "]");
 }
 public String toStringReversed() {
   if (size == 0) {
     return ("[]");
   }
   Node addition = end;
   String ans = ("[" + addition.getData());
   while (addition.getPrev() != null) {
     addition = addition.getPrev();
     ans += (", " + addition.getData());
   }
   return (ans + "]");
 }
 public String remove(int index) {
   if (index < 0 || index >= size) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node removed = new Node(get(index));
   if (size == 1) {
     start = null;
     end = null;
   } else if (index == 0) {
     start = start.getNext();
     start.setPrev(null);
   } else if (index == size - 1) {
     end = end.getPrev();
     end.setNext(null);
   } else {
     Node current = start;
     for (int i = 0; i < size; i++) {
       if (i == index) {
         current.getPrev().setNext(current.getNext());
         current.getNext().setPrev(current.getPrev());
       }
       current = current.getNext();
     }
   }
   size--;
   return (removed.getData());
 }
 /*
*@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
*@postcondition: The size of other is reduced to 0.
*@postcondition: The size of this is now the combined sizes of both original lists
*/
public void extend(MyLinkedList other){
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    this.end = other.end;
    other.size = 0;
}

 //Any helper method that returns a Node object MUST BE PRIVATE!
}
