# SSegEmu
<img src="https://raw.githubusercontent.com/ImanHosseini/SSegEmu/master/scrn.jpg" width="200" />
Emulating a seven-segment display for Verilog debugging purposes. Icarus Verilog has a tool called <i>vvp</i> which runs a compiled Verilog file. (compilation is done with <i>iverilog</i>) The testbench I made uses <b>$fgets</b> to get input which goes into the DUT and the result is sent to stdout via <b>$display</b>, which then is used to draw a seven-segment display.

