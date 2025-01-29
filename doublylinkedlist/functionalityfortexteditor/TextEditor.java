package day_01.doublylinkedlist.functionalityfortexteditor;
public class TextEditor {

    // Node representing a state in the text editor
    private class State {
        String content;
        State next;
        State prev;

        public State(String content) {
            this.content = content;
            this.next = null;
            this.prev = null;
        }
    }

    private State currentState;
    private int maxHistorySize = 10;
    private int size = 0;

    // Initialize the text editor
    public TextEditor() {
        currentState = null;
    }

    // Add a new state to the history
    public void addState(String newContent) {
        if (currentState == null) {
            currentState = new State(newContent);
        } else {
            State newState = new State(newContent);
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;
        }

        if (size >= maxHistorySize) {
            removeOldestState();
        } else {
            size++;
        }
    }

    // Undo to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
        } else {
            System.out.println("No more undo operations.");
        }
    }

    // Redo to the next state
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
        } else {
            System.out.println("No more redo operations.");
        }
    }

    // Display the current text
    public void displayState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.content);
        } else {
            System.out.println("No content.");
        }
    }

    // Remove the oldest state if history exceeds the limit
    private void removeOldestState() {
        if (currentState != null && currentState.prev != null) {
            currentState.prev.next = null;
            currentState = currentState.prev;
            size--;
        }
    }
}
