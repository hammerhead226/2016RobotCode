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
- 7 FPS with Microsoft LifeCam HD 3000 (-vw 640 -vh 480)
- 28 FPS with Microsoft LifeCam HD 3000 (-vw 320 -vh 240)
'''

import copy
import time  # DEBUG

from networktables import NetworkTable
import logging
logging.basicConfig(level=logging.DEBUG)  # for pynetworktables
NetworkTable.setIPAddress("roboRIO-226-FRC.local")
NetworkTable.setClientMode()
NetworkTable.initialize()
contours = NetworkTable.getTable("SharkCV")

def Stronghold226(frame):
	orig = copy.deepcopy(frame)

	# THRESHOLD
	frame.colorHSV()
	mask = frame.threshold([75,155,55], [100,255,255])

	# TWEAKS
	mask.dilate(size=6, iterations=2)

	# CONTOUR PROCESSING
	mask.contoursFilter(area=(100,-1))
	mask.contoursSort('area')
	if len(mask.contours) > 2:
		mask.contoursFilter(area=(mask.contours[2].area,-1))

	# DEBUG OUTPUT
	# mask.contoursDraw(orig, color=(44,62,229))

	# PUBLISH FRAME INFO
	table_frame = contours.getSubTable('frame')
	table_frame.putNumber('width', mask.width)
	table_frame.putNumber('height', mask.height)

	# PUBLISH ALL CONTOURS
	for idx, cnt in enumerate(mask.contours):
		table_cnt = contours.getSubTable('contours/'+str(idx))
		table_cnt.putNumber('area', cnt.area)
		table_cnt.putNumber('width', cnt.width)
		table_cnt.putNumber('height', cnt.height)
		table_cnt.putNumber('centerX', cnt.centerX)
		table_cnt.putNumber('centerY', cnt.centerY)

	return orig