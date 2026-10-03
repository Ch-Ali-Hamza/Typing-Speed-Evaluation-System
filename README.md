# Typing Speed Evaluation System

Developed as an **Object-Oriented Programming (OOP) Semester Project**.

---

## Description

The **Typing Speed Evaluation System** is a desktop application written in Java featuring a graphical user interface (GUI) built with Java Swing. It provides real-time measurement and analysis of typing speed (Words Per Minute), accuracy percentage, and mistake tracking. The system incorporates account tier management (Free vs. Premium users), dynamic text prompt generation across multiple difficulty levels, live visual text feedback, performance scoring, persistent generic leaderboards, user history tracking, and history export capabilities.

---

## Features

* **User Authentication & Account Tiers**: Register and authenticate as either a **Free User** or **Premium User**.
* **Dynamic Difficulty Levels**: Text prompts categorized into Easy, Medium, and Hard difficulty levels are loaded dynamically from external text files (`easy.txt`, `medium.txt`, `hard.txt`).
* **Tier-Based Feature Access**:
  * *Free Users*: Automatically assigned Easy difficulty text prompts.
  * *Premium Users*: Granted access to difficulty level selection (Easy, Medium, Hard) and performance history exporting.
* **Interactive Swing GUI**: Real-time typing interface with color-coded character feedback (blue for correct characters, red for errors) and live updates for elapsed time, WPM, and mistakes.
* **Automated Performance Analysis**: Calculates Words Per Minute (WPM based on standard 5-character word lengths), accuracy percentage, and total mistake count upon completing or submitting a test.
* **Global Leaderboard System**: Bounded generic leaderboard structure (`Leaderboard<T extends Result>`) that ranks and displays top 10 performance scores across all users.
* **User Typing History**: View personal historical typing test records sorted by performance.
* **History Export (Premium Exclusive)**: Premium users can export their complete typing history to a local text file using an interactive file chooser.
* **Binary Serialization Persistence**: User profiles and leaderboard test history persist locally using Java Object Serialization (`users.dat` and `results.dat`).

---

## OOP Concepts Used

* **Classes and Objects**: Encapsulates real-world domain models into structured Java classes such as `User`, `Result`, `Leaderboard`, `TextGenerator`, `FeedbackAnalyzer`, `TypingTest`, and Swing GUI frames.
* **Encapsulation**: Protects internal fields (`username`, `password`, `wpm`, `accuracy`, `mistakes`, `results`) using `private` and `protected` access modifiers, providing controlled access via public getters, setters, and domain logic methods (`checkPassword()`, `getWPM()`, `getAccuracy()`).
* **Inheritance**: Subclasses `FreeUser` and `PremiumUser` inherit core user attributes and authentication methods from the abstract parent class `User`.
* **Polymorphism**:
  * *Method Overriding*: Derived classes override abstract/interface methods (`isPremium()`, `typingMode()`).
  * *Runtime Polymorphic Decisions*: The application controller and GUI dynamically evaluate user instance types (`user instanceof PremiumUser`) to unlock tier-specific features like difficulty selection and history exporting.
* **Abstraction**:
  * Abstract base class `User` defines user identity contracts while leaving tier-specific functionality to subclasses.
  * Interface `TypingBehavior` specifies typing behavior contracts.
  * Inner interface `TypingTestListener` decouples the GUI presentation layer from test evaluation logic.
* **Constructors**: Explicit parameterized constructors initialize object states cleanly across all system components and pass essential dependencies (e.g., passing shared `Leaderboard` instances between screens).
* **Generics**: Bounded generic class `Leaderboard<T extends Result>` ensures type safety and code reusability when storing and sorting test result collections.
* **File Handling & Serialization**:
  * *Character File Processing*: `TextGenerator` reads prompt text files line by line using `BufferedReader` and `FileReader`.
  * *Binary Serialization*: `Leaderboard` and `LoginScreen` save and load object lists (`ArrayList<User>`, `ArrayList<Result>`) using `ObjectOutputStream` and `ObjectInputStream`.
  * *File Export Writing*: `ExportScreen` writes user history report files using `FileWriter` and `JFileChooser`.

---

## Technologies Used

* **Programming Language**: Java (JDK 8+)
* **GUI Framework**: Java Swing (`javax.swing.*`) & AWT (`java.awt.*`)
* **Persistence Mechanism**: Java Object Serialization (`java.io.Serializable`) & File I/O (`java.io.*`)
* **Data Structures**: Java Collections Framework (`ArrayList`, `List`)

---

## Project Structure

```
OPP Project/
├── DashboardScreen.java        # Main menu dashboard screen for authenticated users
├── ExportScreen.java           # GUI for exporting user typing history to text file (Premium)
├── FeedbackAnalyzer.java       # Core engine for calculating WPM, accuracy, and mistakes
├── FreeUser.java               # Concrete User subclass for standard Free accounts
├── HistoryScreen.java          # GUI screen displaying user's past typing test results
├── Leaderboard.java            # Generic class managing leaderboard rankings & persistence
├── LeaderboardScreen.java      # GUI screen displaying top 10 performance rankings
├── LoginScreen.java            # GUI screen for user login, registration, and persistence
├── PremiumUser.java            # Concrete User subclass with premium features enabled
├── Result.java                 # Model class representing a single typing test outcome
├── ResultScreen.java           # GUI screen displaying test summary after completion
├── TextGenerator.java          # Loads and selects text prompts based on difficulty
├── TypingApp.java              # Main application entry point containing main() method
├── TypingBehavior.java         # Interface defining typing behavior specification
├── TypingTest.java             # Controller coordinating text generation, GUI, and scoring
├── TypingTestGUI.java          # Interactive Swing typing interface with real-time feedback
├── User.java                   # Abstract base class for system users
├── easy.txt                    # Easy level sample text prompts
├── medium.txt                  # Medium level sample text prompts
├── hard.txt                    # Hard level sample text prompts
├── Project Report.docx         # Project documentation report (Word document)
├── Project Report.pdf          # Project documentation report (PDF format)
├── Project Report001.pdf       # Additional project report copy
├── Final Project(source code).pdf # Compiled source code document
├── TYPING SPEED EVALUATION SYSTEM.pptx # Project presentation slides
├── UML Class Diagram.png       # Visual class diagram of system architecture
├── rec.mp4                     # Video demonstration recording of system
└── .gitignore                  # Git ignore file for Java & IDE artifacts
```

---

## How to Run

### Prerequisites

Ensure you have Java Development Kit (JDK 8 or higher) installed and configured in your system environment PATH.

### Step 1: Open Terminal / Command Prompt
Navigate to the directory containing the project files:
```bash
cd "path/to/OPP Project"
```

### Step 2: Compile the Source Code
Compile all `.java` files using the Java compiler:
```bash
javac *.java
```

### Step 3: Run the Application
Launch the system entry point:
```bash
java TypingApp
```

---

## Usage

1. **Application Launch**: Starting the application opens the **Login Screen**.
2. **Registration & Login**:
   * Enter a username and password.
   * Click **Register** and choose **Free** or **Premium** account tier.
   * Click **Login** to access the dashboard.
3. **Dashboard Menu**:
   * Click **Start Typing Test** to initiate a test session.
   * Premium users select difficulty (1: Easy, 2: Medium, 3: Hard). Free users automatically start on Easy level.
4. **Typing Test Session**:
   * Type the displayed text prompt into the input field.
   * Typed characters highlight in real-time (blue for correct, red for incorrect).
   * Live statistics (elapsed time, WPM, mistakes) update continuously.
   * Press **Enter** or complete typing the entire prompt to submit.
5. **Score & Results**:
   * View final WPM, accuracy percentage, and mistake metrics on the **Result Screen**.
   * Results are saved automatically to the leaderboard.
6. **Leaderboards & History**:
   * Click **View Global Leaderboard** to see top 10 rankings across all users.
   * Click **View My History** to see personal test history.
   * Premium users can click **Export My History** to save history to a `.txt` file via a file dialog.

---

## Author

**Chaudhry Ali Hamza**  
**BS Cyber Security**  
**COMSATS University Islamabad**  

Developed as an **Object-Oriented Programming (OOP) Semester Project**.
