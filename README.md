# Virtual Memory Management Simulator

I Nazakat Ali 23k-2081 , developed this project for the Operating Systems course at FAST NUCES University. This virtual memory simulation was built using the Java programming language within the Intellij development environment.

The project offers a hands-on simulation of virtual memory management, capturing key concepts and techniques commonly found in Operating Systems. It covers areas like memory traces, page faults, and scheduling, integrating both the Round Robin and First-In-First-Out (FIFO) scheduling algorithms. Additionally, it demonstrates several page replacement algorithms, including FIFO, Least Recently Used (LRU), and Second-Chance FIFO.

***************************************************************
**Project Implementation:**

To structure the simulation, multiple classes were designed, each serving a specific role in the system:

- **Process Class:** Represents a process with its key attributes such as Process ID, Arrival Time, Duration, and Page References.
  
- **PageReplacement Class:** Implements various page replacement algorithms to manage memory more efficiently.

- **FileInput Class:** Handles the reading of a configuration file or generates a random configuration within defined limits.

- **UserInterface Class:** Provides the Graphical User Interface (GUI) of the simulator, connecting the various algorithms and functions from different classes.

- **MyThread Class:** Inherits from the Thread class and is used to create threads for various operations, as well as for each individual process in the simulation.

- **FCFS Class:** Implements the First-Come-First-Serve (FCFS) scheduling algorithm, calculating waiting time and turnaround time for each process, and computing the averages for all processes.

***************************************************************
**How the Program Works:**

Upon launching the program, users are presented with an interface that allows them to select data either from a pre-existing configuration file or a randomly generated one. After choosing the memory size and page replacement algorithms, users can click the "Simulate" button to view the results. The simulation supports FIFO, LRU, and Second-Chance FIFO page replacement algorithms, offering insights into the performance of each algorithm in a memory management scenario.
