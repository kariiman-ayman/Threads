import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

	private Queue <String> bfr = new LinkedList<String>();

        private int bfrSize;
        int count = 0;
        Boolean check = false;
        String item = " ";
        
        //constructor
        public Buffer(int bfrSize){
          this.bfrSize = bfrSize;
        }
        
        public void SetCheck(Boolean check){
           this.check=check;
        }

        public synchronized void produce(String item) {
          while (bfr.size() == bfrSize) {
            try {
              wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

          this.bfr.add(item);
          count++;
          notify();
        }
        public synchronized String consume() {
          while (bfr.isEmpty()) {
            try {
              wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          item = bfr.remove();
          count--;
          notify();
          return item;
        }
}
