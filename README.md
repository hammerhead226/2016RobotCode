# 2016RobotCode
Code for the 2016 season robot.

## Development Software
#### Installing JDK and Eclipse
1. Install the latest [Java SE Development Kit 8 (Windows x64)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
2. Install the latest [Eclipse IDE for Java Developers (64 bit)](https://eclipse.org/downloads/eclipse-packages/).
3. Follow the [2016 FRC Control System](https://wpilib.screenstepslive.com/s/4485/m/13809/l/599681-installing-eclipse-c-java) Eclipse setup instructions.
    1. The code deployment error "roboRIO Image does not match plugin, allowed image version: ##" means you need to update your Eclipse plugins.
    2. Numerous "(class) cannot be resolved to a type" errors may indicate a bad project build path, you should re-create the project.

#### Installing National Instruments Software
1. Strongly consider uninstalling all existing National Instruments products from the "National Instruments Software" installer.
3. Install [FRC 2016 Update Suite](http://www.ni.com/download/first-robotics-software-2016/5773/en/) using the serial number from your most recent kit of parts, and activate the software when prompted.
    1. If asked for a password it is `@Ahead)Together!FRC^2016`.
    2. You may need to [enable .NET Framework 3.5](https://wpilib.screenstepslive.com/s/4485/m/13809/l/599671-installing-the-frc-2016-update-suite-all-languages).
3. Run "NI Update Service" (you may need to find this online and install manually) and install all critical updates, but no patches.

#### Updating roboRIO
1. Make sure you followed all of the National Instruments software instructions above.
2. Connect to the roboRIO via its USB type B port.
3. Browse to the roboRIO's [web page](http://172.22.11.2/#Home).
    1. Login with username "admin" and empty password.
    2. Update the roboRIO's firmware with the newest file in `C:\Program Files (x86)\National Instruments\Shared\Firmware\cRIO\76F2`.
4. Run the roboRIO imaging tool at `C:\Program Files (x86)\National Instruments\LabVIEW 2015\project\roboRIO Tool` (or the newest version that contains this tool) and format with the newest file (should match the competition season year).
    1. If "getting startup settings" hangs restart your computer and try again.

#### Configuring Wireless
* [OpenMesh OM5P-AN](https://wpilib.screenstepslive.com/s/4485/m/13503/l/144986-programming-your-radio-for-home-use)
* [D-Link DAP-1522](http://wpilib.screenstepslive.com/s/3120/m/8559/l/91405-programming-your-radio-for-home-use) (NI install with tools no longer available)
