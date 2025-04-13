import tkinter as tk
import time

class Gui_App(tk.Tk):
    def __init__(self):
        tk.Tk.__init__(self)
        self._frame = None
        self.switch_frame(Main_Menu)


    def switch_frame(self, frame_class):
        new_frame = frame_class(self)
        if self._frame is not None:
            self._frame.destroy()
        self._frame = new_frame
        self._frame.pack()

class Main_Menu(tk.Tk):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Hello and welcome to the number system for 4400").pack()
        tk.Button(self, text="Eng dept", command=lambda: master.switch_frame(Eng_Page)).pack()
        tk.Button(self, text="Ops dept", command=lambda: master.switch_frame(Ops_Page)).pack()
        tk.Button(self, text="Admin dept", command=lambda: master.switch_frame(Admin_Page)).pack()


# Eng Dept
class Eng_Page(tk.Tk):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Eng Dept").pack()
        tk.Button(self, text="Radar", command=lambda: master.switch_frame(Radar_Page)).pack()
        tk.Button(self, text="Compute", command=lambda: master.switch_frame(Comput_Page)).pack()
        tk.Button(self, text="Main Menu", command=lambda: master.switch_frame(Main_Menu)).pack()


class Radar_Page(tk.Tk):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="RADAR, Number is XXXX").pack()
        tk.Button(self, text="Admin dept", command=lambda: master.switch_frame(Main_Menu)).pack()


class Comput_Page(tk.Tk):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Compute, Number is XXXX").pack()
        tk.Button(self, text="Eng dept", command=lambda: master.switch_frame(Main_Menu)).pack()


# Ops pAGES
class Ops_Page(tk.Tk):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Ops Dept, Awaiting Number").pack()


class Admin_Page(tk.Tk):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Admin Page, Awaiting Update").pack()

if __name__ == "__main__":
    app = Gui_App()
    app.mainloop()