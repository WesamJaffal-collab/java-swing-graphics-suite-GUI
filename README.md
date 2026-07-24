# Interactive Java Swing Graphics & Event Handling Suite

A Java Swing GUI application developed using NetBeans IDE, demonstrating event-driven programming, custom 2D shape rendering, keyboard/mouse input binding, and multi-frame data transmission.

---

## 🌟 Key Features

* **Central Control Dashboard:** Built with `JSplitPane` and `JList` interface allowing users to preview descriptions and launch individual modules dynamically.
* **Basic Graphics Rendering:** Demonstrates fundamental 2D shapes (lines, rectangles, ovals) using Java's `Graphics` API.
* **Keyboard Navigation:** Utilizes Swing's `KeyBindings` (`InputMap` & `ActionMap`) for object movement and real-time color changes.
* **Inter-Frame Data Passing:** Demonstrates data flow between separate application windows (`JFrame` instances).

---

## 🛠️ Tech Stack & Tools

* **Language:** Java (JDK 17+)
* **GUI Toolkit:** Java Swing & AWT
* **IDE:** NetBeans IDE

---

## 🚀 How to Run in NetBeans

1. Clone or download this repository.
2. Open **NetBeans IDE**.
3. Go to **File ➔ Open Project...**
4. Select the project folder and click **Open Project**.
5. Press **F6** (or right-click the project and select **Run**).

---

## 📂 Project Structure

```text
├── nbproject/                # NetBeans project configuration and settings
├── src/
│   └── ss12/
│       ├── Main.java                 # Dashboard launcher with options list & split view
│       ├── BasicDrawingFrame.java    # 2D basic shapes demo using Graphics API
│       ├── KeyboardDrawingFrame.java # Interactive canvas with keyboard event bindings
│       ├── FrameOne.java             # Sender window for inter-frame data transfer
│       └── FrameTwo.java             # Receiver window displaying incoming data
└── README.md                 # Project documentation
