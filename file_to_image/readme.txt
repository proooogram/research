python file_to_image.py C:\Windows\system32\mstsc.exe
python file_to_image.py C:\Windows\system32\notepad.exe


#linux
mkdir ./images/
find /bin/ -type f | xargs -I@ python3 file_to_image.py @


#windows powershell admin
复制 c:\windows\system32\目录到 d:\tmp\下 （因为权限问题）
cd file_to_image
get-childitem "d:\tmp\windows\System32"  | foreach {python file_to_image.py $_.fullname}


cd .\tt\qq_work\
junction images D:\agui\Documents\research\file_to_image\img\qq-at-ms-windows\images
get-childitem "D:\program\x86\Tencent\QQ\Bin"  | foreach {python D:\agui\Documents\research\file_to_image\file_to_image.py $_.fullname}

cd .\tt\weixin_work\
junction images D:\agui\Documents\research\file_to_image\img\weixin-at-ms-windows\images
get-childitem "D:\program\x86\Tencent\WeChat"  | foreach {python D:\agui\Documents\research\file_to_image\file_to_image.py $_.fullname}

cd D:\tt\TeamViewer_work
junction images D:\agui\Documents\research\file_to_image\img\TeamViewer-at-ms-windows\images
get-childitem "D:\program\x86\TeamViewer"  | foreach {python D:\agui\Documents\research\file_to_image\file_to_image.py $_.fullname}

cd D:\tt\xshell-work
junction images D:\agui\Documents\research\file_to_image\img\xshell-at-ms-windows\images
get-childitem "D:\program\x86\NetSarang\Xshell 5"  | foreach {python D:\agui\Documents\research\file_to_image\file_to_image.py $_.fullname}

cd D:\tt\jdk8-work
junction images D:\agui\Documents\research\file_to_image\img\jdk8-at-ms-windows\images
get-childitem "D:\program\x64\Java\jdk1.8.0_111\bin"  | foreach {python D:\agui\Documents\research\file_to_image\file_to_image.py $_.fullname}

cd D:\tt\jdk8-work
junction images D:\agui\Documents\research\file_to_image\img\jdk8-at-ms-windows\images
get-childitem -recurse "D:\program\x64\Java\jdk1.8.0_111\"  | where { ! $_.PSIsContainer } | foreach {python D:\agui\Documents\research\file_to_image\file_to_image.py $_.fullname}
