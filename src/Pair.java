public record Pair(int Category, int Words) {

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

    @Override
    public String toString() {
        String category = "";
        String words = "";
        switch (Category) {
            case 0 -> {
                category = "MEMOP";
                if (Words == 0) {
                    words = "\"load\"";
                } else {
                    words = "\"store\"";
                }
            }
            case 1 -> {
                category = "LOADI";
                words = "\"loadI\"";
            }
            case 2 -> {
                category = "ARITHOP";
                if (Words == 0) {
                    words = "\"add\"";
                } else if (Words == 1) {
                    words = "\"sub\"";
                } else if (Words == 2) {
                    words = "\"mult\"";
                } else if (Words == 3) {
                    words = "\"lshift\"";
                } else if (Words == 4) {
                    words = "\"rshift\"";
                }
            }
            case 3 -> {
                category = "OUTPUT";
                words = "\"output\"";
            }
            case 4 -> {
                category = "NOP";
                words = "\"nop\"";
            }
            case 5 -> {
                category = "CONSTANT";
                words = "\"" + Words + "\"";
            }
            case 6 -> {
                category = "REGISTER";
                words = "\"r" + Words + "\"";
            }
            case 7 -> {
                category = "COMMA";
                words = "\",\"";
            }
            case 8 -> {
                category = "INTO";
                words = "\"=>\"";
            }
            case 9 -> {
                category = "ENDFILE";
                words = "\"\"";
            }
            case 10 -> {
                category = "NEWLINE";
                words = "\"\\n\"";
            }
        }
        return "< " + category + ", " + words + " >";
    }

    public boolean isEOF() {
        return Category == 9;
    }
}
