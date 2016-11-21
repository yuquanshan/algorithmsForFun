import sys, os, random, time

def main():
	fd = open('categories','r')
	lines = fd.readlines()
	fd.close()
	cats = []
	for l in lines:
		cats.append(l.replace('\n',''))
	random.seed(time.time())
	num = random.randint(0,len(cats)-1)
	files = os.listdir(cats[num])
	questions = []
	for f in files:
		if '.java' in f and '.dumb' not in f:
			questions.append(f)
	cont = True;
	os.chdir(cats[num])
	while(cont):
		num = random.randint(0,len(questions)-1)
		fd = open(questions[num],'r')
		lines = fd.readlines()
		fd.close()
		flag = False
		for l in lines:
			if flag:
				print l
				if '*/' in l:
					break
			if '/**' in l:
				cont = False
				flag = True
				print l


if __name__ == '__main__':
	main()