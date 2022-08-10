public class linkedlist {

  public static void main(String[] args) {
    LL ll = new LL();
    ll.insertLast(10);
    ll.insertLast(20);
    ll.insertLast(30);
    ll.insertLast(40);
    ll.removeAt(3);
   
    ll.print();
    // ll.reverse();
    // ll.print();
    
  
  }
}

class LL {
  private class Node {
    int value = 0;
    Node next = null;
  }

  private Node head = null;
  private int size = 0;

  public void insertLast(int n){
    Node node = new Node();
    node.value = n;

    if(head == null) head = node;
    else {
      Node current = head; 
      while(current.next != null) current = current.next;
      current.next = node;
    }
    size++;
  }



  public void removeAt(int i){
    if(i == 0){
      removeFirst();
      return;
    }
    if(i >= size) return ;
    int count = 0;
    Node current = head;
    while(count < i - 1){
      current = current.next;
      count++;
    }
    current.next = current.next.next;
    size--;
  }

  public void insertAt(int i, int n){
    if(i >= size) return;
    if(i == 0){
      inserFirst(n);
      return;
    }
    Node node = new Node();
    node.value = n;
    Node current = head;
    int count = 0;
    while(count < (i - 1)){
      current = current.next;
      count++;
    }
    Node temp = current.next;
    System.out.println("came here");
    current.next = node;
    node.next = temp;
    size++;

  }

  public void inserFirst(int n){
    Node node = new Node();
    node.value = n;
    Node temp = head;
    head = node;
    node.next = temp;
    size++;
  }

  public void reverse(){
    Node current = head.next;
    Node previous = head;
    while(current != null){
      Node store = current.next;
      current.next = previous;
      previous = current;
      current = store;
    }
    head = previous;
    int count = 0;
    Node c = head;
    while(count < size - 1){
      c = c.next;
      count++;
    }
    c.next = null;
  }

  public int getFirst(){
    if(head == null) return -1;
    return head.value;
  }

  public int getLast(){
    if(head == null) return -1;
    Node current = head;
    while(current.next != null){
       current = current.next;
    }
    return current.value;
  }

  public void removeFirst(){
    if(head == null) return;
    head = head.next;
    size--;
  }

  public void removeLast(){
    if(head == null) return;
    if(head.next.next == null) head.next = null;
    Node current = head;
    while(current.next.next != null){
      current = current.next;
    }
    current.next = null; 
    size--;
  }

  public void print(){
    Node current = head;
    while(current != null){
       System.out.println(current.value);
       current = current.next;
    }
  }

  public int indexOf(int n){
    Node current = head;
    int count = 0;
    while(current != null){
      if(n == current.value) return count;
       current = current.next;
       count++;
    }
    return -1;
  }

  public int size(){
    return size;
  }

  public void clear(){
    head = null;
    size = 0;
  }

}
