import matplotlib.pyplot as plt
import numpy as np
import sys



# dt=np.dtype([('r', int), ('g', int),('b', int)])
# fpath = "D:/program/x86/KingRoot/adb.exe"

# print("me.py file_path. eg: me.py D:/program/x86/KingRoot/adb.exe")
fpath = "D:/program/x86/KingRoot/adb.exe"
print("process:%s"%fpath)
c=np.fromfile(fpath,dtype=np.uint8)
c=np.resize(c,int(len(c)/3)*3)
c3=np.reshape(c,( -1,3))
rgb=c3
rgb3=np.true_divide(rgb,256)
pn = len(rgb3)
xn = int(np.sqrt(pn)); yn = int(pn/xn)
coordinate1D=np.linspace(0,pn,pn)
x=np.true_divide(coordinate1D,xn)
y=np.fmod(coordinate1D,yn)
fig, ax = plt.subplots()
image_name = fpath.replace("/","_").replace("\\","-").replace(":","=").replace(".","!")
fig.canvas.set_window_title(image_name)
plt.title(fpath)
ax.scatter(x, y, s=0.1, facecolors=rgb3, alpha=0.6)
plt.show()
# plt.savefig("./images/%s"%image_name,dpi=200)

