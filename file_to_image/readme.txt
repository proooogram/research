python file_to_image.py C:\Windows\system32\mstsc.exe
python file_to_image.py C:\Windows\system32\notepad.exe


#linux
mkdir ./images/
find /bin/ -type f | xargs -I@ python3 file_to_image.py @


#windows powershell admin
cd file_to_image
get-childitem "C:\windows\System32"  | foreach {python file_to_image.py $_.fullname}