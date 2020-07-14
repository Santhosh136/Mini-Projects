import numpy as np
import cv2
from detecto import core, utils, visualize

# used for prediction
def predict(img):
	# loading the model
	model = core.Model.load('models/model_new.pth',['cloud'])

	# predicting the objects
	labels, boxes, scores = model.predict(img)

	# creating a list of box coordinates
	l1 = []
	for i in range(len(scores)):
		if(scores[i]>0.3):
			l1.append(boxes[i].numpy())

	# thresholding the image
	img = cv2.imread("input.jpg")
	img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
	thresh, img = cv2.threshold(img,0, 255, cv2.THRESH_OTSU)

	# creating a black image
	output = np.zeros(shape = img.shape)

	# copying the regions
	for i in l1:
		tx,ly,bx,ry = int(i[1]),int(i[0]),int(i[3]),int(i[2])
		output[tx:bx,ly:ry] = img[tx:bx,ly:ry]

	# applying filters
	kernel = np.ones((2,2))
	eroded_img = cv2.erode(output, kernel, iterations = 2)

	# saving the file inside the static folder
	cv2.imwrite("static/output.jpg",eroded_img)
