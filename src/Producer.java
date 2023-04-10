public class Producer extends Thread {

    Buffer bfr;
    int number;
    
    //constructor
    public Producer(int number, Buffer bfr) {
        this.number=number;
        this.bfr=bfr;
    }

    @Override
    public void run() {

        if (number > 0) { // add 1 first
            bfr.produce(Integer.toString(1));
        }

        for (int i = 2; i <= number ; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }

            }
            if (flag == true) {

                bfr.produce(Integer.toString(i));
            }
            if (i == number) {
                bfr.SetCheck(true);            
            }

        }

    }

}
