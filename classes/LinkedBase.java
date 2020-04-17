package eg.edu.alexu.csd.datastructure.queue.cs73;
class node{
    // here we create our node
   private Object data;
   private node next;
   // since we created our variables to be private we create methods to use them
    public void setData(Object data1){
        this.data=data1;
    }
    public void setNext (node next1){
        this.next=next1;
    }
    public Object getData(){
        return data;
    }
    public node getNext(){
        return next;
    }
}

public class LinkedBase implements ILinkedBased,IQueue  {
    /*here we create a head to use it when we get element and a tail to help
    use add elements so that we don't go into loops
     */
   private node head;
   private node tail;
   private int size =0;

    public void enqueue(Object item){
        //here we create a node and set its data as the given item
        node hold = new node();
        hold.setData(item);
        //then we check if the size is zero we make that node the head and the tail
        if(size==0){
            head=hold;
            tail=hold;
            size++;
        }else {
            /*
            if the size is not zero then we add the node at the end of the list
            then we make it the new tail
             */
            tail.setNext(hold);
            tail=hold;
            size++;
        }

    }
    public Object dequeue(){
        //first we check if the size is zero because then the queue is empty and we throe an exception
        if(size==0){
            throw new  RuntimeException("queue is empty");
        }
        //we set the object in the first node (the head) to a temp holder to be able to return it
        Object n =head.getData();
        //we make the head point at the next node to make the garbage collector delete the first node
        head=head.getNext();
        size--;
        return n;
    }
    public boolean isEmpty(){
        // here we check the size if its equal to zero we return true and if not then we return false
        if (size==0){
            return true;
        }else {
            return false;
        }
    }
    public int size(){
        // here we simply return the size
        return size;
    }
}
