[README.md](https://github.com/user-attachments/files/22125646/README.md)
# 🌞 Single Axis Solar Tracker and Cleaner

This project demonstrates a **single-axis solar tracking system** with an integrated **cleaning & cooling mechanism**.  
The system automatically adjusts the solar panel to follow the sun and optimizes energy capture.

---

## 📌 Project Overview
- Tracks the sun’s position using **LDR sensors**.  
- Uses **Arduino / Java** to control servo motors.  
- Increases solar energy capture by **20–30%** compared to fixed panels.  
- Includes **panel cleaning and cooling system** to maintain efficiency.  

---

## 🛠️ Technologies Used
- **Arduino IDE (C++)** for microcontroller control.  
- **Java (simulation + Firmata control)** for testing and PC-Arduino communication.  
- **Servo motors + LDRs + NodeMCU/Arduino + motor driver**.  

---

## 📂 Project Structure
```
single-axis-solar-tracker-and-cleaner/
│── arduino-code/
│   └── SolarTracker.ino
│── java-code/
│   ├── SolarTracker.java
│   └── SolarTrackerFirmata.java
```

---

## ▶️ How to Run
### Arduino
1. Open `SolarTracker.ino` in Arduino IDE.  
2. Connect Arduino board and upload.  
3. Place solar panel prototype under sunlight.  

### Java (Simulation)
```bash
cd java-code
javac SolarTracker.java
java SolarTracker
```

### Java (Arduino with Firmata)
1. Upload **StandardFirmata** sketch to Arduino from Arduino IDE.  
2. Install **Firmata4j** library in your Java project.  
3. Run:
```bash
cd java-code
javac SolarTrackerFirmata.java
java SolarTrackerFirmata
```

---

## 👥 Contributors
- R. Krishna Kanth  
- S. Jaswanth  
- P. Satyaswaroop  
- G. Om Sai  
- Ravuri Harsha  
- Arunesh Bhatt  

---

## 📜 License
This project is open-source under the **MIT License**.
