#!/usr/bin/env python
# -*- coding: utf-8 -*-


from threading import Thread
from time import sleep
import numpy as np

import curses

stdscr = curses.initscr()

def display_info(str, x, y, colorpair=2):
    '''''使用指定的colorpair显示文字'''
    global stdscr
    stdscr.addstr(y, x,str, curses.color_pair(colorpair))
    # stdscr.refresh()

def get_ch_and_continue():
    '''''演示press any key to continue'''
    global stdscr
    #设置nodelay，为0时会变成阻塞式等待
    stdscr.nodelay(0)
    #输入一个字符
    ch=stdscr.getch()
    #重置nodelay,使得控制台可以以非阻塞的方式接受控制台输入，超时1秒
    stdscr.nodelay(1)
    return True

def set_win():
    '''''控制台设置'''
    global stdscr
    #使用颜色首先需要调用这个方法
    curses.start_color()
    #文字和背景色设置，设置了两个color pair，分别为1和2
    curses.init_pair(1, curses.COLOR_GREEN, curses.COLOR_BLACK)
    curses.init_pair(2, curses.COLOR_RED, curses.COLOR_BLACK)
    #关闭屏幕回显
    # curses.noecho()
    #输入时不需要回车确认
    curses.cbreak()
    #设置nodelay，使得控制台可以以非阻塞的方式接受控制台输入，超时1秒
    stdscr.nodelay(1)

def unset_win():
    '''控制台重置'''
    global stdstr
    #恢复控制台默认设置（若不恢复，会导致即使程序结束退出了，控制台仍然是没有回显的）
    curses.nocbreak()
    stdscr.keypad(0)
    curses.echo()
    #结束窗口
    curses.endwin()




def threaded_function(ao ):
    set_win()
    get_ch_and_continue()
    while True:
        for x in range(len(ao)):
            for y in range(len(ao[0])):
                n = ao[x][y]
                display_info('%s'%n if n != out else '*' , y, x)
        stdscr.refresh()
        sleep(1)
    unset_win()








vacant = 0 ; a_spherule = 1; out=2; # a_spherule:有小球在该位置, vacant:该位置是空的

ao=[
    [out,out,out,out,       out,        out,      out,out,out,out],
    [out,out,out,out,       out,        out,      out,out,out,out],
    [out,out,out,out,       out,        out,      out,out,out,out],
    [out,out,out,a_spherule,a_spherule,a_spherule,out,out,out,out],
    [out,out,out,a_spherule,a_spherule,a_spherule,out,out,out,out],
    [out,out,out,a_spherule,a_spherule,a_spherule,out,out,out,out],
    [out,out,out,a_spherule,vacant ,  vacant,     out,out,out,out],
    [out,out,out,out,       out,        out,      out,out,out,out],
    [out,out,out,out,       out,        out,      out,out,out,out],
    [out,out,out,out,       out,        out,      out,out,out,out]
]
#ao out


def x_positive_border_all_vacant(x,y):
    x = len(ao) - 1
    for y in range(len(ao[0])):
        if ao[x][y] == a_spherule:return False
    return True

def x_negative_border_all_vacant():
    x = 0
    for y in range(len(ao[0])):
        if ao[x][y] == a_spherule:return False
    return True

def y_positive_border_all_vacant():
    y = len(ao[0]) - 1
    for x in range(len(ao)):
        if ao[x][y] == a_spherule:return False
    return True

def y_negative_border_all_vacant():
    y = 0
    for x in range(len(ao)):
        if ao[x][y] == a_spherule:return False
    return True

def update_ui():
    # print(ao)
    pass

at_x_positive_border = lambda x,y: ao[x+1][y]==out
at_x_negative_border = lambda x,y: ao[x-1][y]==out
at_y_positive_border= lambda x,y: ao[x][y+1]==out
at_y_negative_border = lambda x,y: ao[x][y-11]==out

get_x_positive_next = lambda x,y: ao[x+1][y]
get_x_negative_next = lambda x,y: ao[x-1][y]
get_y_positive_next= lambda x,y: ao[x][y+1]
get_y_negative_next= lambda x,y: ao[x][y-1]

to_x_positive=1; to_x_negative=2; to_y_positive=3; to_y_negative=4


thread = Thread(target=threaded_function, args=(ao, ))
thread.start()

# -----> y
#|
#| :x
#v
flog = open("log.txt","w")
extrusion_vacant = False #推出所有空白了?
# extrusion_vacant = True #推出所有空白了?
while not extrusion_vacant:
    d=np.random.randint(to_x_positive,to_y_negative+1,(len(ao),len(ao[0]))) #move direction
    ds = '\n'.join('\t'.join('%s' % x for x in y) for y in d)
    print('%s\n'%ds, file=flog, flush=True)
    # print(d)
    for x in range(len(ao)):
        for y in range(len(ao[0])):
            if   ao[x][y] in [out,vacant]:continue
            aos = '\n'.join('\t'.join('%s' % x for x in y) for y in ao)
            if d[x][y] == to_x_positive:
                if at_x_positive_border(x,y):continue
                if get_x_positive_next(x,y) == a_spherule : continue
                t=ao[x + 1][y]; ao[x + 1][y] = ao[x][y]; ao[x][y] = t;
                print("x_positive %s,%s\n%s" % (x, y,aos ), file=flog, flush=True )
                # if x_positive_border_all_vacant() or x_negative_border_all_vacant() or y_positive_border_all_vacant() or y_negative_border_all_vacant(): extrusion_vacant=True
            elif d[x][y] == to_x_negative:
                if at_x_negative_border(x, y): continue
                if get_x_negative_next(x,y) == a_spherule : continue
                t=ao[x-1][y]; ao[x-1][y] = ao[x][y]; ao[x][y] = t;
                print("x_negative %s,%s\n%s" % (x, y,aos ), file=flog, flush=True  )
                # if x_positive_border_all_vacant() or x_negative_border_all_vacant() or y_positive_border_all_vacant() or y_negative_border_all_vacant(): extrusion_vacant = True
            elif d[x][y] == to_y_positive:
                if at_y_positive_border(x, y): continue
                if get_y_positive_next(x,y) == a_spherule : continue
                t=ao[x][y+1]; ao[x][y+1] = ao[x][y]; ao[x][y] = t;
                print("y_positive %s,%s\n%s" % (x, y,aos ), file=flog , flush=True )
                # if x_positive_border_all_vacant() or x_negative_border_all_vacant() or y_positive_border_all_vacant() or y_negative_border_all_vacant(): extrusion_vacant = True
            elif d[x][y] == to_y_negative:
                if at_y_negative_border(x, y): continue
                if get_y_negative_next(x,y) == a_spherule : continue
                t=ao[x][y-1]; ao[x][y-1] = ao[x][y]; ao[x][y] = t;
                print("y_negative %s,%s\n%s" % (x, y,aos ), file=flog, flush=True )
                # if x_positive_border_all_vacant() or x_negative_border_all_vacant() or y_positive_border_all_vacant() or y_negative_border_all_vacant(): extrusion_vacant = True
            print('%s %s\n' % (x,y), file=flog, flush=True)
debug=0