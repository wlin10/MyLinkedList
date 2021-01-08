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
   end.setNext(another);
   this.size += 1;
   return true;
}
 public void add(int index, String value) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node another = new Node(value);
   end.setNext(another);
   size += 1;
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
   return "";
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
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
