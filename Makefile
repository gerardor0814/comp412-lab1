JFLAGS = -g
JC = javac.SUFFIXES: .java .class.java.class:$(JC) $(JFLAGS) $*.java

CLASSES = \
Dijkstra3.java\
DirGraph.java\
FibDijkstra.java\
FibHeap.java\
MinDijkstra.java\
MinHeap.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class