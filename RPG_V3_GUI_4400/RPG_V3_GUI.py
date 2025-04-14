# Other version on VMWARE - was command line
# this is using tkinter - paging like system

"""DESPITE - THE ERRORS, IT WORKS......."""

import tkinter as tk
import sys

restart = True

rooms = {"hall": {"north": "garage",
                  "east": "stairs",
                  "south": "kitchen",
                  "west": "garden"},
         "kitchen": {"north": "hall",
                     "south": "lounge",
                     "item": "water"},
         "lounge": {"north": "kitchen",
                    "south": "office",
                    "item": "corpse"},
         "office": {"north": "lounge",
                    "item": "monster"},
         "garage": {"north": "basement",
                    "south": "hall",
                    "item": "object"},
         "basement": {"south": "garage",
                      "item": "sword"},
         "garden": {"east": "hall",
                    "south": "gate"},
         "gate": {"north": "garden",
                  "item": "archer"},
         "stairs": {"east": "landing",
                    "west": "hall"},
         "landing": {"north": "door_locked",
                     "south": "master_bedroom",
                     "west": "stairs"},
         "toilet": {"south": "landing",
                    "item": "shield"},
         "door_locked": {"north": "toilet",
                         "south": "landing",
                         "item": "lock"},
         "master_bedroom": {"north": "landing",
                            "item": "key"}
         }


class Gui_App(tk.Tk):
    def __init__(self):
        tk.Tk.__init__(self)
        self._frame = None
        self.switch_frame(hall)

    def switch_frame(self, frame_class):
        new_frame = frame_class(self)
        if self._frame is not None:
            self._frame.destroy()
        self._frame = new_frame
        self._frame.pack()

    def restart(self):
        global inventory, water_timer, water_flag, currentRoom, rooms, restart
        inventory = []
        water_timer = 3
        water_flag = False
        currentRoom = 'hall'

        rooms = {"hall": {"north": "garage",
                          "east": "stairs",
                          "south": "kitchen",
                          "west": "garden"},
                 "kitchen": {"north": "hall",
                             "south": "lounge",
                             "item": "water"},
                 "lounge": {"north": "kitchen",
                            "south": "office",
                            "item": "corpse"},
                 "office": {"north": "lounge",
                            "item": "monster"},
                 "garage": {"north": "basement",
                            "south": "hall",
                            "item": "object"},
                 "basement": {"south": "garage",
                              "item": "sword"},
                 "garden": {"east": "hall",
                            "south": "gate"},
                 "gate": {"north": "garden",
                          "item": "archer"},
                 "stairs": {"east": "landing",
                            "west": "hall"},
                 "landing": {"north": "door_locked",
                             "south": "master_bedroom",
                             "west": "stairs"},
                 "toilet": {"south": "landing",
                            "item": "shield"},
                 "door_locked": {"north": "toilet",
                                 "south": "landing",
                                 "item": "lock"},
                 "master_bedroom": {"north": "landing",
                                    "item": "key"}
                 }

        self.destroy()
        restart = True

    def convert_str_class(self, string):
        global currentRoom, water_timer, water_flag, inventory
        if string in ["north", "east", "south", "west"]:
            move = "go " + string
        else:
            move = "get " + rooms[currentRoom]["item"]
        move = move.lower().split()

        if move[0] == "go":
            if move[1] in rooms[currentRoom]:
                if rooms[currentRoom][move[1]] == "door_locked":
                    if "key" in inventory:
                        if currentRoom == "landing":
                            currentRoom = rooms[currentRoom][move[1]]
                            currentRoom = rooms[currentRoom][move[1]]
                            self.switch_frame(getattr(sys.modules[__name__], currentRoom))

                        else:
                            move = "go south"
                            move = move.lower().split()
                            currentRoom = rooms[currentRoom][move[1]]
                            self.switch_frame(getattr(sys.modules[__name__], currentRoom))
                    else:
                        print("you cant go there!")
                else:
                    currentRoom = rooms[currentRoom][move[1]]
                    self.switch_frame(getattr(sys.modules[__name__], currentRoom))
                if water_flag:
                    water_timer -= 1
                if water_timer == 0:
                    tk.Label(self, text="You died of old age!").pack()
                    self.switch_frame(restart_page)
        if move[0] == "get":
            if "item" in rooms[currentRoom] and move[1] in rooms[currentRoom]["item"]:
                if rooms[currentRoom]["item"] == "corpse":
                    rooms[currentRoom]["item"] = "rusty_sword"
                    inventory += [rooms[currentRoom]["item"]]
                    del rooms[currentRoom]["item"]
                    self.switch_frame(getattr(sys.modules[__name__], currentRoom))
                elif rooms[currentRoom]["item"] == "water":
                    tk.Label(self, text="You drank the water").pack()
                    tk.Label(self, text=" You feel older by the second").pack()
                    water_timer -= 1
                    water_flag = True
                    del rooms[currentRoom]["item"]
                    self.switch_frame(getattr(sys.modules[__name__], currentRoom))
                else:
                    inventory += [move[1]]
                    del rooms[currentRoom]["item"]
                    self.switch_frame(getattr(sys.modules[__name__], currentRoom))

            else:
                print("cant get ", move[1])

        # gaming winning logic
        if "item" in rooms[currentRoom] and "archer" in rooms[currentRoom]["item"]:
            if "shield" in inventory:
                if currentRoom == "gate":
                    tk.Label(self, text="you hold the shield high, escaping the archers arrows").pack()
                    self.switch_frame(restart_page)
            else:
                tk.Label(self, text="the archer gets an arrow to your chest, bleeding out you die").pack()
                self.switch_frame(restart_page)
        if "item" in rooms[currentRoom] and "monster" in rooms[currentRoom]["item"]:
            if "sword" in inventory and "rusty_sword" in inventory:
                if currentRoom == "office":
                    tk.Label(self,
                             text="you run at the beast, swinging the rusty_sword, it shatteres against the beasts hide").pack()
                    tk.Label(self, text="it roars in pain, blasting you in fire").pack()
                    if "shield" in inventory:
                        tk.Label(self, text="you block the fire with your shield and slay the beast").pack()
                        self.switch_frame(restart_page)
                    else:
                        tk.Label(self, text="you melt under its withering fiery breath").pack()
                        self.switch_frame(restart_page)
            elif "sword" in inventory:
                if currentRoom == "office":
                    tk.Label(self, text="you killed the beast").pack()
                    self.switch_frame(restart_page)
            elif "rusty_sword" in inventory:
                if currentRoom == "office":
                    tk.Label(self, text="your sword shatters, you die").pack()
                    self.switch_frame(restart_page)
            else:
                tk.Label(self, text="the beast ate you").pack()
                self.switch_frame(restart_page)


class hall(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Hall").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class kitchen(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Kitchen").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class lounge(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Lounge").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class office(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Office").pack()

        for keys, values in rooms[currentRoom].items():
            if keys == "item" and values == "monster":
                break
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class garage(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Garage").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class basement(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Basement").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class garden(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Garden").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class gate(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Gate").pack()

        for keys, values in rooms[currentRoom].items():
            if keys == "item" and values == "archer":
                break
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class stairs(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Stairs").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class landing(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Landing").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class toilet(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Toilet").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class door_locked(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The door_Lockeed").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class master_bedroom(tk.Frame):
    def __init__(self, master):
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Location = The Hall").pack()

        for keys, values in rooms[currentRoom].items():
            tk.Button(self, text=values, command=lambda keys=keys, values=values: master.convert_str_class(keys)).pack()
        tk.Label(self, text="Inventory : " + str(inventory)).pack()


class restart_page(tk.Frame):
    def __init__(self, master):
        global restart
        tk.Frame.__init__(self, master)
        tk.Label(self, text="Restart?").pack()
        tk.Button(self, text="restart", command=lambda: master.restart()).pack()
        tk.Button(self, text="quit", command=lambda: master.restart()).pack()
        restart = False


if __name__ == "__main__":
    inventory = []
    water_timer = 3
    water_flag = False

    currentRoom = "hall"

    while restart:
        app = Gui_App()
        app.mainloop()
    print("finished")
