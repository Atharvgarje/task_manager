# CLI Task Manager

> Week 1 project — Java Basics + Git

A command-line task manager built to practice: OOP, Collections, File I/O, StringBuilder, toString, equals, Switch, and Ternary operators.

## Project Structure

```
src/
└── com/taskmanager/
    ├── Main.java         ← entry point, command loop
    ├── Task.java         ← model class (OOP, toString, equals)
    ├── TaskManager.java  ← business logic (ArrayList, loops)
    └── FileHandler.java  ← file persistence (Scanner, BufferedWriter)
```

## How to Run

### Option A — VS Code
1. Install "Extension Pack for Java" from VS Code marketplace
2. Open the `task-manager` folder
3. Open `Main.java` → click **Run** above `main()`

### Option B — Command Line
```bash
# Compile all files
javac -d bin src/com/taskmanager/*.java

# Run
java -cp bin com.taskmanager.Main
```

## Commands
```
add <task>       → add Buy groceries
list             → show all tasks
complete <num>   → complete 1
delete <num>     → delete 2
help             → show commands
exit             → quit
```

## Concepts Practiced
- [x] Classes, Objects, Constructors, `this`
- [x] Encapsulation (private fields + getters)
- [x] `toString()` and `equals()` overrides
- [x] `ArrayList` vs arrays
- [x] Enhanced for-loop, do-while loop
- [x] Switch expressions (Java 14+)
- [x] Ternary operator
- [x] File I/O — `Scanner`, `BufferedWriter`
- [x] `StringBuilder`
- [x] Exception handling (`NumberFormatException`, `IOException`)
- [x] Git — init, add, commit, branching

## Git Practice
```bash
git init
git add .
git commit -m "week 1: initial task manager"

# Create a feature branch
git checkout -b feature/add-priority

# After changes:
git add .
git commit -m "feat: add priority levels to tasks"
git checkout main
git merge feature/add-priority
```