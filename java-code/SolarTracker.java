public class SolarTracker {

    int servoh = 170;
    int servohLimitHigh = 150;
    int servohLimitLow = 40;

    int servov = 45;
    int servovLimitHigh = 120;
    int servovLimitLow = 60;

    int ldrlt = 0, ldrrt = 0, ldrld = 0, ldrrd = 0;

    void setup() {
        writeHorizontal(120);
        writeVertical(70);
        delay(2500);
    }

    void loop() {
        int lt = analogRead(ldrlt);
        int rt = analogRead(ldrrt);
        int ld = analogRead(ldrld);
        int rd = analogRead(ldrrd);

        int dtime = 10, tol = 90;

        int avt = (lt + rt) / 2;
        int avd = (ld + rd) / 2;
        int avl = (lt + ld) / 2;
        int avr = (rt + rd) / 2;

        int dvert = avt - avd;
        int dhoriz = avl - avr;

        if (Math.abs(dvert) > tol) {
            if (avt > avd) servov++;
            else servov--;

            if (servov > servovLimitHigh) servov = servovLimitHigh;
            if (servov < servovLimitLow) servov = servovLimitLow;

            writeVertical(servov);
        }

        if (Math.abs(dhoriz) > tol) {
            if (avl > avr) servoh--;
            else servoh++;

            if (servoh > servohLimitHigh) servoh = servohLimitHigh;
            if (servoh < servohLimitLow) servoh = servohLimitLow;

            writeHorizontal(servoh);
        }

        delay(dtime);
    }

    void writeHorizontal(int angle) {
        System.out.println("Horizontal Servo -> " + angle);
    }

    void writeVertical(int angle) {
        System.out.println("Vertical Servo -> " + angle);
    }

    int analogRead(int pin) {
        return (int)(Math.random() * 1024); // simulate LDR
    }

    void delay(int ms) {
        try { Thread.sleep(ms); } 
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public static void main(String[] args) {
        SolarTracker tracker = new SolarTracker();
        tracker.setup();
        while (true) tracker.loop();
    }
}
