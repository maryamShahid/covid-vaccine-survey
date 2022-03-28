# Covid-19 Vaccine Survey Page

A survey page for Covid-19 vaccine information

This project is implemented for testing purposes.

## How To Install & Run The Android App

- Go to Android Studio 
- Perform: File -> New -> Project From Version Control...
- Paste https://github.com/maryamShahid/covid-vaccine-survey.git to URL and click 'Clone'
- Install an emulator on your Android Studio which has at least Android 5.0 (API Level 21)
- Click 'Run' and your survey application should be running on your emulator.

## How To Run The Tests
- Install Appium
- Open Appium, then do the following:
  - Go to Advanced
  - Write localhost in 'Server Address' input
  - Write 4723 in 'Server Port' input
  - Click on 'Edit Configurations'
  - Fill ANDROID_HOME with the address of your android SDK (something like: C:\Users\userName\AppData\Local\Android\Sdk).
  - Fill JAVA_HOME with the address of your Java JDK (something like: C:\Program Files\Java\jdk1.8.0_271)
  - Click 'Save and Restart'
  - Click 'Start Server'
- Run test\src\main\java\test.java file (test folder is in the root folder)
- Tests should be running.

### Notes
1. Before you run the tests, your android emulator should be running, and the application must be installed (to install the application, follow the steps above).
2. If your emulator name is changed (from emolator-5554), you need to change line 15 in test\src\main\java\test.java file.
