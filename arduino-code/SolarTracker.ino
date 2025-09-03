#include <Servo.h> 

Servo horizontal; // horizontal servo
int servoh = 170; 
int servohLimitHigh = 150;
int servohLimitLow = 40;

Servo vertical; // vertical servo
int servov = 45; 
int servovLimitHigh = 120;
int servovLimitLow = 60;

// LDR pins
int ldrlt = A1; // left top
int ldrrt = A3; // right top
int ldrld = A0; // left bottom
int ldrrd = A2; // right bottom

void setup(){
  horizontal.attach(3);
  vertical.attach(2);
  horizontal.write(120);
  vertical.write(70);
  delay(2500);
}

void loop() {
  int lt = analogRead(ldrlt);
  int rt = analogRead(ldrrt);
  int ld = analogRead(ldrld);
  int rd = analogRead(ldrrd);

  int dtime = 10; 
  int tol = 90; 

  int avt = (lt + rt) / 2;
  int avd = (ld + rd) / 2;
  int avl = (lt + ld) / 2;
  int avr = (rt + rd) / 2;

  int dvert = avt - avd;
  int dhoriz = avl - avr;

  if (abs(dvert) > tol) {
    if (avt > avd) {
      servov++;
      if (servov > servovLimitHigh) servov = servovLimitHigh;
    } else {
      servov--;
      if (servov < servovLimitLow) servov = servovLimitLow;
    }
    vertical.write(servov);
  }

  if (abs(dhoriz) > tol) {
    if (avl > avr) {
      servoh--;
      if (servoh < servohLimitLow) servoh = servohLimitLow;
    } else {
      servoh++;
      if (servoh > servohLimitHigh) servoh = servohLimitHigh;
    }
    horizontal.write(servoh);
  }

  delay(dtime);
}
