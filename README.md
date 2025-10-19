# Programmer's Calculator

This is a programmer's calculator with a graphical user interface (GUI) built using Java Swing. It supports three number systems: hexadecimal, decimal, and binary, and can perform a variety of arithmetic and bitwise operations.

## Features

*   **Multiple Number Systems:** Switch between hexadecimal, decimal, and binary modes.
*   **Arithmetic Operations:** Perform addition, subtraction, multiplication, and division.
*   **Bitwise Operations:** Perform AND, OR, XOR, NOT, left shift (`<<`), and right shift (`>>`).
*   **Dynamic Button Disabling:** The calculator disables buttons that are not relevant to the current number system mode (e.g., hexadecimal buttons 'A'-'F' are disabled in decimal or binary mode).
*   **User-Friendly Interface:** A clear and intuitive layout for easy operation.

## How to Use

1.  Select the desired number system mode (Hexadecimal, Decimal, or Binary) using the radio buttons on the left.
2.  Enter the first number using the on-screen buttons.
3.  Select an operator (+, -, *, /, AND, OR, XOR, <<, >>).
4.  Enter the second number.
5.  Click the "=" button to see the result.
6.  The "Clear" button resets the calculator.
7.  The "NOT" button performs a bitwise NOT operation on the currently displayed number.

## How to Compile and Run

### Prerequisites

*   Java Development Kit (JDK) installed on your system.

### Compilation

1.  Open your terminal or command prompt.
2.  Navigate to the directory where you saved the `ProgrammerCalculator.java` file.
3.  Compile the Java code using the following command:

    ```bash
    javac ProgrammerCalculator.java
    ```

### Running the Calculator

1.  After successful compilation, run the calculator using the following command:

    ```bash
    java ProgrammerCalculator
    ```

2.  A new window will open with the calculator.