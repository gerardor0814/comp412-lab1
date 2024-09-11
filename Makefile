JAVAC = javac
.SUFFIXES: .java .class

# This uses the line continuation character (\) for readability
# You can list these all on a single line, separated by a space instead.
# If your version of make can't handle the leading tabs on each
# line, just remove them (these are also just added for readability).
CLASSES = \
        src/IRNode.java \
        src/Parser.java \
        src/Trio.java \
        src/Scanner.java

classes: $(CLASSES:.java=.class)

build:
	classes


clean:
	    rm  *.class