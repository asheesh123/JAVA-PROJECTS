public class ThreadExp {

    public static void main(String[] args) {
        Number n = new Number();
        EvenThread et = new EvenThread(n);
        OddThread ot = new OddThread(n);
        et.start();
        ot.start();
    }

}

class EvenThread extends Thread {

    private Number number;

    public EvenThread(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            number.getEven();
        }
    }

}

class OddThread extends Thread {

    private Number number;

    public OddThread(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            number.getOdd();
        }
    }

}

class Number {

    private int currentEven = 0;

    private int currentOdd = 1;

     private StringBuilder odd;
     private StringBuilder even;
     private StringBuilder last;

    {
        odd = new StringBuilder("odd");
        even = new StringBuilder("even");
        last = odd;
    }

    public synchronized void getEven() {
        if (last == even) {
            try {
                 //System.out.println("inside if in even--->" +Thread.currentThread());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("out of if in even--> " + Thread.currentThread());
        int i = currentEven;
        last = even;
        currentEven += 2;
        System.out.println(i);
        notify();
        return;
    }

    public synchronized void getOdd() {
        if (last == odd) {
            try {
                //System.out.println("inside if in odd--->" +Thread.currentThread());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("out of if in odd--> " + Thread.currentThread());

        int i = currentOdd;
        last = odd;
        currentOdd += 2;
        System.out.println(i);
        notify();
        return;
    }
}