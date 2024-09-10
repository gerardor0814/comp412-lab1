/**
 * 0 - MEMOP: load, store
 * 1 - LOADI: loadI
 * 2 - ARITHOP: add, sub, mult, lshift, rshift
 * 3 - OUTPUT: output
 * 4 - NOP: nop
 * 5 - CONSTANT: a non-negative integer
 * 6 - REGISTER: ‘r’ followed by a constant
 * 7 - COMMA: ‘,’
 * 8 - INTO: “=>”
 * 9 - EOF: input has been exhausted
 * 10 - EOL: end of the current line
 */


public class IRNode {
    int[] operands;
    int line;
    int opCategory;
    int opCode;
    IRNode next;
    IRNode prev;

    public IRNode() {
        operands = new int[12];
    }

    public void setNext(IRNode next) {
        this.next = next;
    }

    public void setPrev(IRNode prev) {
        this.prev = prev;
    }

    public void setOperands(int value, int index) {
        operands[index] = value;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setOpType(int opCategory, int opCode) {
        this.opCategory = opCategory;
        this.opCode = opCode;
    }

}
