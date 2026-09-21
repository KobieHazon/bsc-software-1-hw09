# BSc Software 1 - Homework 9

- Course: BSc Computer Science.
- Available copy: June 2018.
- Assignment brief: The matching Homework 9 handout was not found.
- Maintenance changes: the current version adds local compatibility stubs for the missing riddle scaffold classes `A1`, `A2`, and `A3`, plus a maintained test harness and repeatable Makefile validation.

## Contents

This homework contains a Java object-modeling assignment and small riddle packages:

- `il.ac.tau.cs.sw1.ex9.starfleet` - crew members, officers, Cylons, weapons, spaceships, battle ships, transport ships, and fleet aggregation utilities.
- `il.ac.tau.cs.sw1.ex9.riddles` - compact inheritance, polymorphism, exception, and iterator exercises.

## Tech Stack

- Java 8 language features, validated with Java 11 or newer.
- Plain `javac` and `java`; no external dependencies.
- `make` for repeatable compile, test, and cleanup commands.

## Run

```bash
make test
```

To remove generated files:

```bash
make clean
```

## Notes

The recovered riddle answers referenced hidden scaffold classes that were not present in the local submission. The added `A1`, `A2`, and `A3` files are minimal local scaffolds for compilation and validation only; my recovered `B` answers are preserved.
