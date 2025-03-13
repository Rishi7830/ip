# Kohli Chatbot - User Guide

## Introduction
Kohli is a command-line chatbot designed to help users efficiently manage tasks. With Kohli, you can add different types of tasks, mark tasks as completed, find tasks, and save your task list for future use. This guide will walk you through how to use Kohli and its available features.

## Quick Start

1. Ensure **Java 17** or above is installed on your computer.
2. Download the latest **Kohli.jar** file from the repository.
3. Open a terminal and navigate to the folder containing **Kohli.jar**.
4. Run the chatbot using the command:
   ```sh
   java -jar Kohli.jar
   ```
5. Start entering commands to interact with the chatbot.
6. Refer to the features below for details on available commands.

## Features

### 1. Viewing Help: `help`
Displays a message explaining how to use the chatbot.
#### Format:
```sh
help
```

### 2. Adding a To-Do Task: `todo`
Adds a simple task without a specific deadline.
#### Format:
```sh
todo <task description>
```
**Example:**
```sh
todo Buy groceries
```

### 3. Adding a Deadline Task: `deadline`
Adds a task with a specific deadline.
#### Format:
```sh
deadline <task description> /by <yyyy-mm-dd hhmm>
```
**Example:**
```sh
deadline Submit report /by 2024-04-15 2359
```

### 4. Adding an Event Task: `event`
Adds a task with a specific start and end time.
#### Format:
```sh
event <task description> /from <yyyy-mm-dd hhmm> /to <yyyy-mm-dd hhmm>
```
**Example:**
```sh
event Team meeting /from 2024-04-15 1400 /to 2024-04-15 1600
```

### 5. Listing All Tasks: `list`
Displays all tasks in the list.
#### Format:
```sh
list
```

### 6. Marking a Task as Done: `mark`
Marks a specific task as completed.
#### Format:
```sh
mark <task number>
```
**Example:**
```sh
mark 2
```

### 7. Unmarking a Task: `unmark`
Marks a specific task as incomplete.
#### Format:
```sh
unmark <task number>
```
**Example:**
```sh
unmark 2
```

### 8. Deleting a Task: `delete`
Removes a specific task from the list.
#### Format:
```sh
delete <task number>
```
**Example:**
```sh
delete 3
```

### 9. Finding a Task: `find`
Searches for tasks containing a keyword.
#### Format:
```sh
find <keyword>
```
**Example:**
```sh
find report
```

### 10. Exiting the Chatbot: `bye`
Ends the chatbot session.
#### Format:
```sh
bye
```

## Saving and Loading Tasks
Kohli automatically saves tasks to a file when you exit and reloads them when you restart the chatbot.

## FAQ
### Q: How do I install Java 17?
Visit [Java’s official site](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) to download and install Java 17.

### Q: Can I edit the task list manually?
Yes, tasks are saved in a text file. You can edit it, but incorrect formatting may cause errors.

### Q: What happens if I enter an invalid command?
Kohli will display an error message and prompt you to enter a valid command.

## Known Issues
- Incorrect formatting of dates or commands may result in errors.
- Manual modifications to the task file may cause the chatbot to malfunction.
- Tasks exceeding the file storage limit may not be saved properly.

## Command Summary
| Action         | Format                                      | Example                                      |
|---------------|-------------------------------------------|---------------------------------------------|
| Help          | `help`                                    | `help`                                     |
| Add To-Do    | `todo <task>`                             | `todo Buy groceries`                        |
| Add Deadline | `deadline <task> /by <yyyy-mm-dd hhmm>`  | `deadline Submit report /by 2024-04-15 2359` |
| Add Event    | `event <task> /from <yyyy-mm-dd hhmm> /to <yyyy-mm-dd hhmm>` | `event Team meeting /from 2024-04-15 1400 /to 2024-04-15 1600` |
| List Tasks   | `list`                                    | `list`                                     |
| Mark Task    | `mark <task number>`                      | `mark 2`                                   |
| Unmark Task  | `unmark <task number>`                    | `unmark 2`                                 |
| Delete Task  | `delete <task number>`                    | `delete 3`                                 |
| Find Task    | `find <keyword>`                          | `find report`                              |
| Exit         | `bye`                                     | `bye`                                      |



Now you're ready to manage your tasks efficiently with Kohli! 🚀
