import os

path = ['./']

class ReName():
	def __init__(self):
		pass

	def findDir(self):
		for route in path:
			for item in os.listdir(route):
				if item.find('.') < 0:
					path.append(os.path.join(route, item))


	def reName(self):
		for directory in path:
			for file in os.listdir(directory):
				if file.find('note') >= 0:
					os.rename(os.path.join(directory, file),os.path.join(directory, 'readMe.md'))
					print(file)


task = ReName()
task.findDir()
task.reName()