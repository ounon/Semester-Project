# Semester-Project

## Code Editor

# Context
Exercises of introductory level programming often require a simple control mechanism,
such as giving predefined parameters and observing the program's output. In exercise
sessions, we often provide students with answers so that they can verify their results.
However, we are not able to check their replies one by one. Thus, in 2019-2020, we
used the JupyterHub system and tested students' output with expected outputs to
automate this approach. However, this system did not work well, because i) we had to
write all test cases from scratch by instructor ii) cells of a Jupyter notebook process
Java codes differently.

# Description
Many online programming courses/challenge websites implement simple input/output
testing (e.g., Hackerrank), running the user's code with predefined inputs and
comparing the results to expected outputs. In this project, we propose developing an
online coding environment using the approach mentioned earlier for the University of
Lausanne students.
The list of tools we are planning to use:
• Spring Boot (microservices)
• JSF + PrimeFaces (UI component library for JSF-based apps)
• JDoodle (API that provides services for online compilers)
• Database: PostgreSQL || MySQL (we are flexible on this one)
• Server: Tomcat (Spring Boot uses Embedded Tomcat as the default server)
