import matplotlib
matplotlib.use('TkAgg')
# matplotlib.use('Agg')
import matplotlib.pyplot as pyplot
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import sys



# dt=np.dtype([('r', int), ('g', int),('b', int)])
# fpath = "D:/program/x86/KingRoot/adb.exe"

# print("me.py file_path. eg: me.py D:/program/x86/KingRoot/adb.exe")
# fpath = sys.argv[1]
fpath = "D:/program/x86/KingRoot/adb.exe"
print("process:%s"%fpath)
fbin=np.fromfile(fpath,dtype=np.uint8)
bin5=np.resize(fbin,int(len(fbin)/6)*6)
bin=np.reshape(bin5,( -1,6))
x,y,z,color_byte=bin[:,0], bin[:,1], bin[:,2], bin[:,3:6]
color0To1=np.true_divide(color_byte,256)

fig= pyplot.figure(figsize=(19.2, 9.83),dpi=100 )
ax = fig.add_subplot(111, projection='3d')
image_name = fpath.replace("/","_").replace("\\","-").replace(":","=").replace(".","!")
fig.canvas.set_window_title(image_name)
pyplot.title(fpath)
ax.scatter(x, y, z, s=0.1, facecolors=color0To1, alpha=0.6)
pyplot.show()
# fig.savefig("./images3d/%s"%image_name,dpi=100 )
