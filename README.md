🛠️ Prime Number Generator using Multi-Threaded Buffers in Java
================================================

🧾 Project Description 
------------------------

This is a Java project that simulates a real-life buffering scenario where a producer schedules prime numbers in a queue and a consumer writes them in a file. The user can decide the number of primes to be generated, and the application uses multiple threads to perform multiple actions simultaneously, reducing the time elapsed.

📋 Requirements
-----------------

- Java Development Kit (JDK) 8 or higher
- Integrated Development Environment (IDE) for Java, such as Eclipse or IntelliJ IDEA

💻 How to Run
-----------------

1. Clone or download the repository to your local machine.
2. Import the project to your IDE.
3. Build the project to generate the executable file.
4. Run the executable file to launch the GUI.
5. Enter the value of N in the input field and click on the "Generate Primes" button to start the process.
6. The GUI will display the largest prime number found between 0 and N, the number of prime numbers generated, and the time elapsed since the start of processing.

🤖 How It Works
-----------------

The Producer thread generates prime numbers up to N and schedules them in a queue. The Consumer thread writes the prime numbers from the queue to a file. The application uses multiple threads to perform these tasks simultaneously, reducing the time elapsed.
The Consumer thread holds a lock when it starts and releases it when the ready queue is empty. It must notify all other threads when it releases the lock.

🎨 About the GUI
-----------------
The GUI displays the following information:
- Largest prime number found between 0 and N
- Number of prime numbers generated
- Time elapsed since the start of processing

To use the GUI, follow these steps:
1. Enter the value of N in the input field.
2. Click on the "Generate Primes" button to start the process.
3. The GUI will update in real-time as the application generates and writes prime numbers to the file.

🔍 Conclusion
----------------

This Java project demonstrates the use of multiple threads to perform multiple tasks simultaneously, reducing the time elapsed. It simulates a real-life buffering scenario where a producer schedules prime numbers in a queue and a consumer writes them in a file. The GUI provides a user-friendly interface to input the value of N and display the results of the processing.

Thank you for checking out this project! If you have any feedback or suggestions, please feel free to reach out.
