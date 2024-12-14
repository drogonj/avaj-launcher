
all:
	find * -name "*.java" > sources.txt
	javac -d out @sources.txt

test:
	java -cp out avaj_launcher.Main scenario.txt

clean:
	find src -name "*.class" -exec rm -f {} +
	rm -f sources.txt