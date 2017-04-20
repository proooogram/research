import matplotlib
matplotlib.use('TkAgg')
import matplotlib.pyplot as pyplot
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import sys


def increse(d,k):
    d[k] -=1
    return d[k]

# print("me.py file_path. eg: me.py D:/program/x86/KingRoot/adb.exe")
fpath = sys.argv[1]
# fpath = "D:/program/x86/KingRoot/adb.exe"
print("process:%s"%fpath)
fbin=np.fromfile(fpath,dtype=np.uint8)
bin5=np.resize(fbin,int(len(fbin)/5)*5)
bin=np.reshape(bin5,( -1,5))
xy,color_byte=bin[:,0:2], bin[:,2:5]
xy_ = [np.uint16(  np.bitwise_or(np.left_shift(i[0],8), i[1]) ) for i in xy]
xy_unique, xy_index , xy_counts= np.unique(xy_, return_index=True, return_counts=True)
mod = np.average(xy_counts) * np.std(xy_counts) *2
xy_unique_count = dict(zip(xy_unique, xy_counts))
xy_z=[ np.array([i,increse(xy_unique_count,i)])  for i in xy_]
xyz = np.array([  np.array([np.uint8(np.right_shift(np.bitwise_and(i[0],0xff00), 8)), np.uint8(np.bitwise_and(i[0],0x00ff)) ,np.uint32(i[1])])  for i in xy_z])
x,y,z=xyz[:,0:1], xyz[:,1], xyz[:,2]
color0To1=np.true_divide(color_byte,256)

fig= pyplot.figure(figsize=(19.2, 9.83),dpi=100 )
# fig= pyplot.figure( )
ax = fig.add_subplot(111, projection='3d')
image_name = fpath.replace("/","_").replace("\\","-").replace(":","=").replace(".","!")
fig.canvas.set_window_title(image_name)
pyplot.title(fpath)
ax.scatter(x, y, z, s=0.1, facecolors=color0To1, alpha=0.6)
# pyplot.show()
fig.savefig("./images3d/%s"%image_name,dpi=100 )

