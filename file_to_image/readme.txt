python file_to_image.py C:\Windows\system32\mstsc.exe
python file_to_image.py C:\Windows\system32\notepad.exe


#linux
mkdir ./images/
find /bin/ -type f | xargs -I@ python3 file_to_image.py @


#windows powershell admin
复制 c:\windows\system32\目录到 d:\tmp\下 （因为权限问题）
cd file_to_image
get-childitem "d:\tmp\windows\System32"  | foreach {python file_to_image.py $_.fullname}