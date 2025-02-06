[![JUnit Tests](https://github.com/BradTheeStallion/QAP1-SDAT-DEVOPS/actions/workflows/mavenTest.yml/badge.svg)](https://github.com/BradTheeStallion/QAP1-SDAT-DEVOPS/actions/workflows/mavenTest.yml)

# QAP 1

Instructions: [SDAT AND DEV OPS COMBINED QAP 1.pdf](https://github.com/user-attachments/files/18677542/SDAT.AND.DEV.OPS.COMBINED.QAP.1.pdf)

This project expands on a question from [QAP 1](https://github.com/BradTheeStallion/QAP1_Java_BA/blob/main/src/Account.java) of a Java course I did last term, but there have been significant improvements. My main goals were to: Use clean coding practices, set up at least three unit tests, and automate those tests using a GitHub Actions Workflow.

In addition to resources from my instructors, I have consulted the following:

[dev.to](https://dev.to/ewefie/getting-started-with-github-actions-run-junit-5-tests-in-a-java-project-with-maven-20g4)


The following questions are a component of the assignment from my instructor:

1. Explain how your code meets clean code practices by using at least 3 examples of your own code. Screenshots should be used

The first example of clean-code found in this project is in the descriptive test names. There is no ambiguity regarding the subject of the test.

<img width="1033" alt="Screenshot 2025-02-06 at 7 57 16 AM" src="https://github.com/user-attachments/assets/30b4d7fa-5dc0-4780-82d9-f76fb1fb7f2e" />

Next, I'd like to bring your attention to the transferTo() method and how it adheres to the Single Responsibility Principle in that it does one thing - handling money transfers. It delegates the actual withdrawal and deposit operations to their respective methods rather than implementing that logic directly. This makes the code more maintainable and easier to modify without affecting other parts of the system.

<img width="919" alt="Screenshot 2025-02-06 at 8 03 07 AM" src="https://github.com/user-attachments/assets/6219a8cd-a1c0-4187-93ff-87d9ac733c93" />

Lastly, I'd like to highlight an example of error handling. Instead of returning special codes or using complex nested conditions, it uses exceptions for exceptional cases. The error message is descriptive enough to be useful for debugging.

<img width="648" alt="Screenshot 2025-02-06 at 8 07 26 AM" src="https://github.com/user-attachments/assets/54cbfcc6-ed35-45e5-a03d-2f746896680c" />

2. Explain your project. What it does, how it works. Explain the test cases you used

My project is one of the choices provided by my instructor for the project, a simple banking application featuring the ability to create an account, deposit/withdraw money, transfer money between accounts, and output information about the accounts. My test suite covers deposits, withdrawals, and transfers (including scenarios with insuffiecient funds or an invalid acccount).

3. Outline the needed dependencies. Where did you get them from?

The only dependency I used in this particular project was [J-Unit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.12.0-M1).

4. If you had any problems the QAP please explain what happened.

I thoroughly enjoyed this project. The main 'issue' I had was when I took a suggestion from ChatGPT to use Big Decimal for my monetary values and it broke my test suite. I did manage to fix it and it seems Big Decimal is preferred for monetary values in Java so it was a valuable learning experience.

I hope you enjoyed this project, and please don't hesitate to reach out if you have any questions or comments. 
