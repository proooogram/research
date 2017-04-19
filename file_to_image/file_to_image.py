import matplotlib.pyplot as plt
import numpy as np
import sys



# dt=np.dtype([('r', int), ('g', int),('b', int)])
# fpath = "D:/program/x86/KingRoot/adb.exe"
# fpath = "D:\TDDownload\赤道与北极.mp3"
print("me.py file_path. eg: me.py D:/program/x86/KingRoot/adb.exe")
fpath = sys.argv[1]
c=np.fromfile(fpath,dtype=np.uint8)
c=np.resize(c,int(len(c)/5)*5)
c3=np.reshape(c,( -1,5))
x,y,rgb=c3[:,0], c3[:,1], c3[:,2:5]
rgb3=np.true_divide(rgb,256)

fig, ax = plt.subplots()
fig.canvas.set_window_title(fpath.replace("/","_").replace("\\","-").replace(":","="))
plt.title(fpath)
ax.scatter(x, y, s=0.1, facecolors=rgb3, alpha=0.6)
plt.show()


