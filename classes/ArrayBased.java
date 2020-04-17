package eg.edu.alexu.csd.datastructure.queue.cs73;

public class ArrayBased implements IArrayBased,IQueue {
    // we create our variables to start with
   private Object[] arr;
   private int m=0;
   private int f=0;
   private int r=0;
   private int size=0;
    public ArrayBased(int n){
        /* here we create our array and set a variable m to be our max size
        to know our limit
        */
        arr=new Object[n];
        m=n;
    }
    public void enqueue(Object item){
        //first we check if the size is equal to the max and if it is we throw an exception
        if(size==m){
            throw new RuntimeException("queue is full");
        }
        arr[r]=item;
        /* here we check if r is at it max or not which is equal to the max size-1
        and if it is that means that r is standing at the last element and should be rest
        to be the first one
         */
        if(r==m-1){
            r=0;
        }else{
            //here is the general case where we just add one to r
            r=r+1;
        }
        //here we increase the size because we just add an element
        size++;

    }
    public Object dequeue(){
        //here we check if the queue is empty and if it is we throw an exception
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        // we appoint the element at the front of the queue to a temp holder to be able to return it
        Object n =arr[f];
        //here we clear the element in the array to be able to hold another element later
        arr[f]=null;
        /* here we check if f is at it max or not which is equal to the max size-1
        and if it is that means that f is standing at the last element and should be rest
        to be the first one
         */
        if(f==m-1){
            f=0;
        }else{
            //here we just add one because f is at a normal place
            f++;
        }
        //after we are done we subtract 1 from the size and return the temp object
        size--;
        return n;
    }
    public boolean isEmpty(){
        //here we check the size and if it equals zero than the queue is empty and we return true and if not we return false
        if (size==0){
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        // here we simply return the size
        return size;
    }
}
