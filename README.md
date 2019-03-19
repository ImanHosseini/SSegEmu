# SSegEmu
<img src="https://raw.githubusercontent.com/ImanHosseini/SSegEmu/master/scrn.jpg" width="200" />
Emulating a seven-segment display for Verilog debugging purposes. Icarus Verilog has a tool called *vvp* which runs a compiled Verilog file. (compilation is done with *iverilog*) The testbench I made uses **$fgets** to get input which goes into the DUT and the result is sent to stdout via **$display**, which then is used to draw a seven-segment display.

