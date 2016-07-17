# 2016RobotCode
Code for the 2016 season robot.

### Installation
##### National Instruments
- FIRST: Install "NI Software for FRC 2016" - http://www.ni.com/download/labview-for-frc-16.0/5774/en/
	- You may need to create an account to download the software
- SECOND: Install "FRC 2016 Update Suite" - http://www.ni.com/download/first-robotics-software-2016/5773/en/
	- The password is =>    @Ahead)Together!FRC^2016

##### Java and Eclipse
- Install "Java SE Development Kit 8" (Windows x64) - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Install "Eclipse IDE for Java Developers" (Windows 64 bit) - https://www.eclipse.org/downloads/download.php?file=/oomph/epp/neon/R/eclipse-inst-win64.exe
	- In the installer choose "Eclipse IDE for Java Developers"
- Follow the WPILib ScreenSteps instructions starting with "Install Eclipse Java Development Tools" - http://wpilib.screenstepslive.com/s/4485/m/13503/l/145002-installing-eclipse-c-java
	- Start from "Starting Eclipse for the first time", then skip to "Setting up the JDK in eclipse (Java teams only)" and follow the rest of the instructions

##### Setting up build path in Eclipse
- The wpilib plugin adds some classpath variables to your workspace, so if you've deleted yours or have created a new one, you'll need to add them again.

- If you create a new Robot Java Project the wpilib plugin will automatically add the classpath variables. Otherwise, follow the steps below to add them manually:
- Open the Preferences window and navigate to: Java > Build Path > Classpath Variables
- Add the following classpath variables, substituting <User> with your username:
- networktables: C:/Users/<User>/wpilib/java/current/lib/NetworkTables.jar
- networktables.sources: C:/Users/<User>/wpilib/java/current/lib/NetworkTables-sources.jar
- wpilib: C:/Users/<User>/wpilib/java/current/lib/WPILib.jar
- wpilib.sources: C:/Users/<User>/wpilib/java/current/lib/WPILib-sources.jar
