import org.firmata4j.IODevice;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.Pin;
import java.io.IOException;

public class SolarTrackerFirmata {

    static int servoh = 170, servohLimitHigh = 150, servohLimitLow = 40;
    static int servov = 45, servovLimitHigh = 120, servovLimitLow = 60;

    public static void main(String[] args) throws IOException, InterruptedException {
        IODevice arduino = new FirmataDevice("COM3"); // change COM3 to your Arduino port
        arduino.start();
        arduino.ensureInitializationIsDone();

        Pin servoH = arduino.getPin(3);
        Pin servoV = arduino.getPin(2);

        servoH.setMode(Pin.Mode.SERVO);
        servoV.setMode(Pin.Mode.SERVO);
        servoH.setValue(120);
        servoV.setValue(70);

        while (true) {
            int lt = (int) arduino.getPin(15).getValue(); // A1
            int rt = (int) arduino.getPin(17).getValue(); // A3
            int ld = (int) arduino.getPin(14).getValue(); // A0
            int rd = (int) arduino.getPin(16).getValue(); // A2

            int tol = 90;
            int avt = (lt + rt) / 2, avd = (ld + rd) / 2;
            int avl = (lt + ld) / 2, avr = (rt + rd) / 2;
            int dvert = avt - avd, dhoriz = avl - avr;

            if (Math.abs(dvert) > tol) {
                if (avt > avd) servov++; else servov--;
                if (servov > servovLimitHigh) servov = servovLimitHigh;
                if (servov < servovLimitLow) servov = servovLimitLow;
                servoV.setValue(servov);
            }

            if (Math.abs(dhoriz) > tol) {
                if (avl > avr) servoh--; else servoh++;
                if (servoh > servohLimitHigh) servoh = servohLimitHigh;
                if (servoh < servohLimitLow) servoh = servohLimitLow;
                servoH.setValue(servoh);
            }

            Thread.sleep(10);
        }
    }
}
