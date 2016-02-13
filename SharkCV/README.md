# Stronghold226.py
How to set up a Raspberry Pi 2B for use with `SharkCV` for FRC Stronghold.

## Linux Setup

#### Distro Installation
1. Format your SD card with SD Association's SD Formatter 4.0 (https://www.sdcard.org/downloads/formatter_4).
2. Download and copy NOOBS to the root of your SD card (https://www.raspberrypi.org/downloads/noobs).
3. Power on your Raspberry Pi. Install Ubuntu and only Ubuntu. Wait for NOOBS to finish and reboot into Ubuntu.
4. Run through `raspi-config` and set hostname, username, password, locale, keyboard, and SSH options.

#### Update Packages
It is a good idea to perform a full software update before doing anything else. It may be a good idea to hold off on updates during competition season unless you have a significant amount of time to test stability.
```bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get dist-upgrade
```

#### Build mjpg-streamer (Optional)
If you want to stream a webcam attached to the Raspberry Pi you will need to install `mjpg-streamer`:
```bash
sudo apt-get install cmake libraspberrypi-dev libjpeg8-dev imagemagick libv4l-dev
git clone https://github.com/jacksonliam/mjpg-streamer.git
cd mjpg-streamer/mjpg-streamer-experimental
cmake mjpg-streamer input_uvc.so output_http.so
```

#### Install Display-O-Tron 3000 (Optional)
If you want to use the dot3k display for Python debugging output you will need to run the following:
```bash
sudo apt-get install python-dev python-smbus
sudo pip install RPi.GPIO dot3k
```
You will also need to enable SPI and I2C with `raspi-config`.

## Microsoft LifeCam HD 3000
Using the Microsoft LifeCam desktop software set the following settings. The important setting here is low brightness so retro-reflective tape appears with high contrast.
```
TrueColor:      Off
Brightness:     30
White Balance:  4500/Auto
Saturation:     100
Exposure:       -6/Auto
Contrast:       5
PowerLine Fr.:  60 Hz
```

## SharkCV
Grab the latest version of `SharkCV`:
```bash
git clone https://github.com/hammerhead226/SharkCV.git
```
Follow the dependancy installation instructions in the README file.

## Linux Startup
To make `SharkCV` run at startup add the following lines to `/etc/rc.local` (will require root).
```bash
cd [/path/to/SharkCV/folder]
nohup sudo python SharkCV.py [arguments] [module]
```