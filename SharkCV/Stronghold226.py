'''
Running on a Raspberry Pi 2B:
- /proc/cpuinfo Revision a01041
- lscpu Max 900MHz
- Ubuntu 15.04/3.18.0-25-rpi2 (2015/07/05)
Including all OpenCV and NetworkTable processing this averages:
- 7 FPS with Microsoft LifeCam HD 3000 (-vw 640 -vh 480)
- 29 FPS with Microsoft LifeCam HD 3000 (-vw 320 -vh 240)

Running on a Raspberry Pi 2B:
- /proc/cpuinfo Revision a21041
- lscpu Max 900MHz
- Raspbian Jessie 4.1.17-v7+ #838 (2016/02/09)
Including all OpenCV and NetworkTable processing this averages:
- 5 FPS with Microsoft LifeCam HD 3000 (-vw 640 -vh 480)
- 20 FPS with Microsoft LifeCam HD 3000 (-vw 320 -vh 240)
'''

import copy

# from networktables import NetworkTable
# import logging
# logging.basicConfig(level=logging.DEBUG)
# NetworkTable.setIPAddress("127.0.0.1")
# NetworkTable.setClientMode()
# NetworkTable.initialize()
# cr = NetworkTable.getTable("SharkCV/myContoursReport")

# import cv2
# import numpy as np

# import dot3k.backlight
# import dot3k.joystick
# import dot3k.lcd

def Stronghold226(frame):
	orig = copy.deepcopy(frame)
	
	# THRESHOLD
	frame.colorHSV()
	mask = frame.threshold([75,155,55], [100,255,255])
	# mask = frame.threshold([0,130,65], [30,225,150])
	
	# TWEAKS
	mask.dilate(size=6, iterations=2)
	
	# CONTOUR PROCESSING
	mask.contoursFilter(area=(100,-1))
	mask.contoursSort('area')
	if len(mask.contours) > 0:
		mask.contoursFilter(area=(mask.contours[0].area,-1))
	
	# DEBUG OUTPUT
	mask.contoursDraw(orig, color=(44,62,229))
	
	# Publish ContoursReport
	# for idx, cnt in enumerate(step_3_0):
		# table = cr.getSubTable(str(idx))
		# table.putValue('area', cnt['area'])
		# table.putValue('width', cnt['width'])
		# table.putValue('height', cnt['height'])
		# table.putValue('centerX', cnt['centerX'])
		# table.putValue('centerY', cnt['centerY'])
		
	# dot3k.lcd.clear()
	# if len(mask.contours) == 0:
		# dot3k.backlight.rgb(255, 127, 0)
		# dot3k.lcd.set_cursor_position(0, 0)
		# dot3k.lcd.write("NONE NONE NONE")
		# dot3k.lcd.set_cursor_position(0, 1)
		# dot3k.lcd.write("NONE NONE NONE")
		# dot3k.lcd.set_cursor_position(0, 2)
		# dot3k.lcd.write("NONE NONE NONE")
	# for cnt in sorted(mask.contours, key=lambda c: c.area, reverse=True)[:1]:
		# cv2.drawContours(orig._ndarray, [cnt._ndarray], -1, (0,255,0), 2)
		# dot3k.backlight.rgb(0, 127, 255)
		# dot3k.lcd.set_cursor_position(0, 0)
		# dot3k.lcd.write('1/' + str(len(mask.contours)) + ' @ ' + str(cnt.centerX) + ',' + str(cnt.centerY))
		# dot3k.lcd.set_cursor_position(0, 1)
		# dot3k.lcd.write(str(cnt.width)+ 'x' + str(cnt.height) + ' = ' + str(cnt.area))
		
	return orig