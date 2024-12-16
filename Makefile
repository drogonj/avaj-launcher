
all:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt

test t: re
	@java -cp src edu.fortytwo.ngalzand.avaj_launcher.Simulator scenario.txt
	@cat simulation.txt
	@make --no-print-directory clean

clean c:
	@find src -name "*.class" -exec rm -f {} +

	@rm -f sources.txt
	@rm -f simulation.txt

re: clean all