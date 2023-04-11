Threads Assignment Description
----------------------------
Given N numbers and one file, our system simulates a real-life of how buffering is run where a user will decide N to get the prime numbers from 0 to N. 

Somehow, the producer schedules the primes in a queue and consumer will use this queue to write them in the file, so do an application using multiple threads to do multiple actions simultaneously which will reduce the time elapsed.

Note: The consumer thread will hold a lock when it starts and releases it when the ready queue is empty and must notify all other threads.

About the GUI
----------------------------
Our GUI displays the largest prime number found between 0 and N, the number of prime numbers generated as well as time elapsed since the start of processing.
