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
   if (size() == 0) {
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
   if (index < 0 || index > size()) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node another = new Node(value);
   if (size() == 0) {
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
     Node temp1 = new Node(get(index - 1));
     Node temp2 = new Node(get(index));
     temp1.setNext(another);
     temp2.setPrev(another);
     another.setPrev(temp1);
     another.setNext(temp2);
   }
   size++;
 }
 public String get(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node ans = start;
   int i = 0;
   while (i != index) {
       ans = start.getNext();
       i++;
   }
   return ans.getData();
 }
 public String set(int index, String value) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node another = new Node(value);
   Node replaced = new Node(get(index));
   another.setPrev(replaced.getPrev());
   another.setNext(replaced.getNext());
   return (replaced.getData());
 }
 public String toString() {
   String ans = "[";
   Node addition = start;
   for (int i = 0; i < size() - 1; i++) {
     ans += (addition.getData() + ", ");
     addition = addition.getNext();
   }
   return (ans + addition.getData() + "]");
 }
 public String remove(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node removed = new Node(get(index));
   if (size() == 1) {
     start = null;
     end = null;
   } else if (index == 0) {
     Node removedRight = new Node(get(index + 1));
     removedRight.setPrev(null);
   } else if (index == size - 1) {
     Node removedLeft = new Node(get(index - 1));
     removedLeft.setNext(null);
   } else {
     Node removedLeft = new Node(get(index - 1));
     Node removedRight = new Node(get(index + 1));
     removedLeft.setNext(removedRight);
     removedRight.setPrev(removedLeft);
   }
   return (removed.getData());
 }
 /*
*@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
*@postcondition: The size of other is reduced to 0.
*@postcondition: The size of this is now the combined sizes of both original lists
*/
public void extend(MyLinkedList other){
    Node ending1 = this.end;
    Node starting2 = other.start;
    Node ending2 = other.end;
    ending1.setNext(starting2);
    starting2.setPrev(ending1);
    ending1 = ending2;
}

 //Any helper method that returns a Node object MUST BE PRIVATE!
}
