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
   return true;
}
 public void add(int index, String value) {

 }
 public String get(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException("index " + index + " is out of range");
   }
   Node ans = start;
   for (int i = 0; i < size(); i++) {
     while (i != index) {
       ans = start.getNext();
     }
   }
   return ans.getData();
 }
 public String set(int index, String value) {
   return "";
 }
 public String toString() {
   return "";
 }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
