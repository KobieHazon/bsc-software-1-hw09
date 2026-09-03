JAVAC ?= javac
JAVA ?= java
BUILD_DIR := build
SOURCES := $(shell find src tests -name '*.java')

.PHONY: compile test clean

compile:
	mkdir -p $(BUILD_DIR)
	$(JAVAC) -encoding UTF-8 -Xlint:all -Werror -d $(BUILD_DIR) $(SOURCES)

test: compile
	$(JAVA) -cp $(BUILD_DIR) RunHw9Checks
	$(JAVA) -cp $(BUILD_DIR) il.ac.tau.cs.sw1.ex9.starfleet.StarfleetManagerTester >/tmp/bsc-software-1-hw09-starfleet-smoke.txt

clean:
	rm -rf $(BUILD_DIR)
