# Manual

This is the manual for SSegEmu. This is meant as proof of concept to demonstrate how to make interactive simulations for hardware (Verilog) code. It is expected that by inspecting the code (which is made up of re-usable components) and the description you will be able to make simulations for other scenarios of your choice. I have opted to choose a seven segment display as my use-case. 
<img src="https://github.com/ImanHosseini/SSegEmu/raw/master/scrnshot.JPG" width="750" />
<br> 
## Dependencies
You need **java** and **vvp** (http://iverilog.icarus.com/) to run this program. 
## Running the jar
To run the jar (from bash or cmd):
```bash
$java -jar SSegEmu.jar
```
Then you can interact with the seven segment display.
## How does it work?
Usually for digital system design courses Quartus (or other commercial tools) are used for design and verification. I decided to try working with **free**, **open source** tool called [**Icarus**](http://iverilog.icarus.com/) for synthesis and simulation. You can compile verilog files via **iverilog** and then simulate your code using **vvp**. (It also supports gtkwave, free software to use waveforms) The next insight is that you can use system functions in Verilog to write/read to/from file, and **stdout** and **stdin** are files with predefined file descriptors **0x80000001-2**. <br>
SSegEmu spawns a **vvp** process and acts as a layer between **vvp** and the user. You type inputs into the console and the java process relays your input to **vvp**, and into the inputs of the module under test, and **vvp** relays the output back to the java process which then renders the seven segment display. So you can have live interaction with your module.
<img src="https://github.com/ImanHosseini/SSegEmu/raw/master/diagram.png" />



