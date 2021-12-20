package ua.univer.lesson04;

// A correct implementation of a producer and consumer.
class QQ {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet)
            try {
                wait();

            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        System.out.println("Got: " + n);
        valueSet = false;
        notifyAll();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet)
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notifyAll();
    }
}

class PProducer implements Runnable {
   QQ q;

    PProducer(QQ q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;

        while(true) {
            q.put(i++);
        }
    }
}

class CConsumer implements Runnable {
    QQ q;

    CConsumer(QQ q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while(true) {
            q.get();
        }
    }
}

class PCFixed {
    public static void main(String args[]) {
        QQ q = new QQ();
        new PProducer(q);
        new PProducer(q);
        new CConsumer(q);
        new CConsumer(q);

        System.out.println("Press Control-C to stop.");
    }
}
