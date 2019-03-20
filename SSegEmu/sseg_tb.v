module test;

  /* Make a reset that pulses once. */
  reg [3:0] x;
  wire [6:0] z;
  reg true = 1'b1;
  integer r;
  integer fd= 32'h80000000;
  integer stdout = 32'h80000001;
  reg [10*8-1:0] string;
  reg reset = 0;
  hexto7segment h2s(x,z);
  reg [7:0] a0;
  
  initial
	begin
   while (true)  
        begin
            r = $fgets(string,fd);
			r = $sscanf(string, "%x", x);
			 // x = r[3:0];
			#40
			// $display("READ %s",string);
			// $display("REGS %x",x);
			$display("SSEG %x",z);
			$fflush(stdout);
            #10;
        end
	end
		

endmodule // test