import matplotlib.pyplot as pyplot
import numpy as np
import sys



# dt=np.dtype([('r', int), ('g', int),('b', int)])
# fpath = "D:/program/x86/KingRoot/adb.exe"

# print("me.py file_path. eg: me.py D:/program/x86/KingRoot/adb.exe")
# fpath = sys.argv[1]
fpath = "D:/program/x86/KingRoot/adb.exe"
print("process:%s"%fpath)
fbin=np.fromfile(fpath,dtype=np.uint8)
bin5=np.resize(fbin,int(len(fbin)/5)*5)
bin=np.reshape(bin5,( -1,5))
xy,color_byte=bin[:,0:2], bin[:,2:5]
_xy = np.ascontiguousarray(xy).view(np.dtype((np.void, xy.dtype.itemsize * xy.shape[1])))
xy_unique, xy_index , xy_counts= np.unique(_xy, return_index=True, return_counts=True)

color0To1=np.true_divide(color_byte,256)

fig, ax = pyplot.subplots()
image_name = fpath.replace("/","_").replace("\\","-").replace(":","=").replace(".","!")
fig.canvas.set_window_title(image_name)
pyplot.title(fpath)
ax.scatter(x, y, s=0.1, facecolors=color0To1, alpha=0.6)
# pyplot.show()
pyplot.savefig("./images/%s"%image_name,dpi=200)

