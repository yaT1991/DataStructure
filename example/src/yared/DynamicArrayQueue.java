package yared;

public class DynamicArrayQueue {

    private int maxSize;

    private int[] queueArray;

    private int top;
    private int end = 0;


     public DynamicArrayQueue(int size) {
         maxSize = size;
         queueArray = new int[maxSize];
         top = -1;
    }


    public void enqueue(int value) {
        if (!isFull()) { 
            top++;
            queueArray[top] = value;
        } else {
            resize(maxSize * 2);
            enqueue(value);
        }
    }

    
     public int dequeue() {
         if (!isEmpty()) {
              return queueArray[end];
       
         }

        if (top < maxSize / 4) {
             resize(maxSize / 2);
             return dequeue(); 
        } else {
             System.out.println("The queue is already empty");
             return -1;
        }
    }


    public int peek() {
        if (!isEmpty()) { 
             return queueArray[end];
        } else {
            System.out.println("The queue is empty");
            return -1;
        }
    }

    private void resize(int newSize) {
         int[] transferArray = new int[newSize];

         for (int i = 0; i < queueArray.length; i++) {
             transferArray[i] = queueArray[i];
             queueArray = transferArray;
         }
         maxSize = newSize;
    }


     public boolean isEmpty() {
         return (top == -1);
     }


     public boolean isFull() {
        return (top + 1 == maxSize);
     }


     public void makeEmpty() { 
         top = -1; 
     
     }

     public static void main(String args[]) {
         DynamicArrayQueue myQueue = new DynamicArrayQueue(2);
            

         myQueue.enqueue(8);
         myQueue.enqueue(2);
         myQueue.enqueue(3);
         myQueue.enqueue(4);
         myQueue.enqueue(5);


        
         System.out.println(myQueue.isEmpty());
         System.out.println(myQueue.isFull()); 
     
    }
}


