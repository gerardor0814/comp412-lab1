// COMP 412, Rice University
// ILOC Front End
//
// This file should parse correctly
//
  loadI 27  => r1 //Hello
  loadI 27=>r1
  load  r1 => r2
  load  r1 => r2
  load  r1 =>r2
  lshi
  add   r1,r2 => r3
  sub   r3, r4 => r5
  mult  r5, r6 => r10
  lshift  r0, r3 => r2
  rshift  r2, r3 => r2
  output 1024
  nop