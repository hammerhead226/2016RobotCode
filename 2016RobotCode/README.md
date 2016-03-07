# 2016RobotCode
Code for the 2016 season robot.

### Installation
##### National Instruments
- Install "FRC 2016 Update Suite" - http://www.ni.com/download/first-robotics-software-2015/5773/en/

##### Java and Eclipse
- Install "Java SE Development Kit 8" (Windows x64) - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Install "Eclipse IDE for C/C++ Developers" (Windows 64 bit) - http://www.eclipse.org/downloads/
- Follow the WPILib ScreenSteps instructions starting with "Install Eclipse Java Development Tools" - http://wpilib.screenstepslive.com/s/4485/m/13503/l/145002-installing-eclipse-c-java

##### Setting up build path in Eclipse
- he wpilib plugin adds some classpath variables to your workspace, so if you've deleted yours or have created a new one, you'll need to add them again.

- If you create a new Robot Java Project the wpilib plugin will automatically add the classpath variables. Otherwise, follow the steps below to add them manually:
- Open the Preferences window and navigate to: Java > Build Path > Classpath Variables
- Add the following classpath variables, substituting <User> with your username:
- networktables: C:/Users/<User>/wpilib/java/current/lib/NetworkTables.jar
- networktables.sources: C:/Users/<User>/wpilib/java/current/lib/NetworkTables-sources.jar
- wpilib: C:/Users/<User>/wpilib/java/current/lib/WPILib.jar
- wpilib.sources: C:/Users/<User>/wpilib/java/current/lib/WPILib-sources.jar

##### Vision Tracking
- Install "GRIP Computer Vision Engine" - https://github.com/WPIRoboticsProjects/GRIP/releases
