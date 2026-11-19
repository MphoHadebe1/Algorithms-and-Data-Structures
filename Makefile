JAVAC = javac

%.class: %.java
	$(JAVAC) $<
clean:
	rm -f *.class
