package com.mycompany.lukegreen_assignment03_csc311;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * contains all the member variables and methods to make up the
 * PrimaryController class for this GUI
 *
 * @author Luke Green
 */
public class PrimaryController {

    //the List views
    @FXML
    private ListView lvPriorityQueue;
    @FXML
    private ListView lvQueue;
    @FXML
    private ListView lvSet;

    //the text fields
    @FXML
    private TextField pqIterator;
    @FXML
    private TextField qIterator;
    @FXML
    private TextField sIterator;
    @FXML
    private TextField DataText;

    //all of the buttons
    @FXML
    private Button addButton;
    @FXML
    private Button add5Button;
    @FXML
    private Button clearButton;
    @FXML
    private Button pqNext;
    @FXML
    private Button pqReset;
    @FXML
    private Button qNext;
    @FXML
    private Button qReset;
    @FXML
    private Button sNext;
    @FXML
    private Button sReset;

    //the combobox
    @FXML
    private ComboBox Collections;

    //add items to combo box
    ObservableList<String> comboItems = FXCollections.observableArrayList("ALL", "PRIORITY QUEUE", "QUEUE", "SET");

    //member varibles for collections
    PriorityQueue priorityQueue = new PriorityQueue();
    Queue queue = new LinkedList();
    Set set = new HashSet();

    Iterator<String> iter1;
    Iterator<String> iter2;
    Iterator<String> iter3;

    //count used for iterators below list views
    //helps decide which element to cuurrently be at
    //these basically represent how many elements in the iterator should be at any given time
    int SetIteratorCount = 1;
    int QueueIteratorCount = 1;
    int PriorityQueueIteratorCount = 1;

    /**
     * basically just adds items to combo box, and set default selection
     */
    @FXML
    public void initialize() {
        ObservableList<String> pq = lvPriorityQueue.getItems();
        ObservableList<String> q = lvQueue.getItems();
        ObservableList<String> s = lvSet.getItems();

        Collections.setValue("All");
        Collections.setItems(comboItems);
    }

    /**
     * will add data from data text field into the set collection, and display
     * it on the list view will reset the set iterator to start
     */
    @FXML
    private void addDataToSet() {
        if (!DataText.getText().equals("")) {
            //add data to set
            set.add(DataText.getText());
            ObservableList<String> s = lvSet.getItems();
            s.clear();
            DataText.clear();
            Iterator<String> iter;
            iter = set.iterator();
            String setIter = iter.next();
            sIterator.setText(setIter);

            Iterator<String> iterWhole;
            iterWhole = set.iterator();
            //add all elements of set to list view
            while (iterWhole.hasNext()) {
                s.add(iterWhole.next());
            }
        }
    }

    /**
     * will add data from data text field into the queue collection, and display
     * it on the list view will reset the queue iterator to the start
     */
    @FXML
    private void addDataToQueue() {
        if (!DataText.getText().equals("")) {
            //add data to queue
            queue.add(DataText.getText());
            ObservableList<String> q = lvQueue.getItems();
            q.clear();
            DataText.clear();
            Iterator<String> iter;
            iter = queue.iterator();
            String queueIter = iter.next();
            qIterator.setText(queueIter);

            Iterator<String> iterWhole1;
            iterWhole1 = queue.iterator();
            //add data to list view from queue
            while (iterWhole1.hasNext()) {
                q.add(iterWhole1.next());
            }
        }
    }

    /**
     * will add data from data text field into priority queue collection, and
     * display it on the list view will reset the priority queue iterator to the
     * start
     */
    @FXML
    private void addDataToPriorityQueue() {
        if (!DataText.getText().equals("")) {
            //add data to priorty queue
            priorityQueue.add(DataText.getText());
            ObservableList<String> pq = lvPriorityQueue.getItems();
            pq.clear();
            DataText.clear();
            Iterator<String> iter;
            iter = priorityQueue.iterator();
            String priorityQueueIter = iter.next();
            pqIterator.setText(priorityQueueIter);

            Iterator<String> iterWhole2;
            iterWhole2 = priorityQueue.iterator();
            //build list view from priority queue
            while (iterWhole2.hasNext()) {
                pq.add(iterWhole2.next());
            }
        }
    }

    /**
     * will add data from data text field into all collections, and display it
     * on the list views will reset the iterators to start on all collections
     */
    @FXML
    private void addDataToAll() {
        if (!DataText.getText().equals("")) {
            //add data to set
            set.add(DataText.getText());
            ObservableList<String> s = lvSet.getItems();
            s.clear();

            //add to queue
            queue.add(DataText.getText());
            ObservableList<String> q = lvQueue.getItems();
            q.clear();

            //add to priority queue
            priorityQueue.add(DataText.getText());
            ObservableList<String> pq = lvPriorityQueue.getItems();
            pq.clear();

            DataText.clear();

            Iterator<String> iter1;
            iter1 = set.iterator();
            String setIter = iter1.next();
            sIterator.setText(setIter);
            Iterator<String> iterWhole;
            iterWhole = set.iterator();
            //build list view from set
            while (iterWhole.hasNext()) {
                s.add(iterWhole.next());
            }

            Iterator<String> iter2;
            iter2 = queue.iterator();
            String queueIter = iter2.next();
            qIterator.setText(queueIter);
            Iterator<String> iterWhole1;
            iterWhole1 = queue.iterator();
            //build list view form queue
            while (iterWhole1.hasNext()) {
                q.add(iterWhole1.next());
            }

            Iterator<String> iter3;
            iter3 = priorityQueue.iterator();
            String priorityQueueIter = iter3.next();
            pqIterator.setText(priorityQueueIter);
            Iterator<String> iterWhole2;
            iterWhole2 = priorityQueue.iterator();
            //build list view from priority queue
            while (iterWhole2.hasNext()) {
                pq.add(iterWhole2.next());
            }
        }
    }

    /**
     * add a specific string to the set, used when adding 5 randoms will also
     * reset the iterator to the start (don't know if you wanted that but it
     * seemed that way in the documentation)
     *
     * @param g string to be added to the set
     */
    @FXML
    private void addRandomToSet(String g) {
        //add param to set
        set.add(g);
        ObservableList<String> s = lvSet.getItems();
        s.clear();
        DataText.clear();
        Iterator<String> iter;
        iter = set.iterator();
        String setIter = iter.next();
        sIterator.setText(setIter);

        Iterator<String> iterWhole;
        iterWhole = set.iterator();
        //build lsit view from set
        while (iterWhole.hasNext()) {
            s.add(iterWhole.next());
        }
    }

    /**
     * add a specific string to the queue, used when adding 5 randoms will also
     * reset the iterator to the start (don't know if you wanted that but it
     * seemed that way in the documentation)
     *
     * @param g string to be added to the queue
     */
    @FXML
    private void addRandomToQueue(String g) {
        //add param to queue
        queue.add(g);
        ObservableList<String> q = lvQueue.getItems();
        q.clear();
        DataText.clear();
        Iterator<String> iter;
        iter = queue.iterator();
        String queueIter = iter.next();
        qIterator.setText(queueIter);

        Iterator<String> iterWhole1;
        iterWhole1 = queue.iterator();
        //build list view from queue
        while (iterWhole1.hasNext()) {
            q.add(iterWhole1.next());
        }
    }

    /**
     * add a specific string to the priority queue, used when adding 5 randoms
     * will also reset the iterator to the start (don't know if you wanted that
     * but it seemed that way in the documentation)
     *
     * @param g string to be added to the priority queue
     */
    @FXML
    private void addRandomToPriorityQueue(String g) {
        //add param to priority queue
        priorityQueue.add(g);
        ObservableList<String> pq = lvPriorityQueue.getItems();
        pq.clear();
        DataText.clear();
        Iterator<String> iter;
        iter = priorityQueue.iterator();
        String priorityQueueIter = iter.next();
        pqIterator.setText(priorityQueueIter);

        Iterator<String> iterWhole2;
        iterWhole2 = priorityQueue.iterator();
        //build list view from priority queue
        while (iterWhole2.hasNext()) {
            pq.add(iterWhole2.next());
        }
    }

    /**
     * add a specific string to all collections, used when adding 5 randoms will
     * also reset the iterators to the start (don't know if you wanted that but
     * it seemed that way in the documentation)
     *
     * @param g string to be added to all collections
     */
    @FXML
    private void addRandomToAll(String g) {
        //add param to set
        set.add(g);
        ObservableList<String> s = lvSet.getItems();
        s.clear();

        //add param to queue
        queue.add(g);
        ObservableList<String> q = lvQueue.getItems();
        q.clear();

        //add param to priorty queue
        priorityQueue.add(g);
        ObservableList<String> pq = lvPriorityQueue.getItems();
        pq.clear();

        DataText.clear();

        Iterator<String> iter1;
        iter1 = set.iterator();
        String setIter = iter1.next();
        sIterator.setText(setIter);
        Iterator<String> iterWhole;
        iterWhole = set.iterator();
        //build list view from set
        while (iterWhole.hasNext()) {
            s.add(iterWhole.next());
        }

        Iterator<String> iter2;
        iter2 = queue.iterator();
        String queueIter = iter2.next();
        qIterator.setText(queueIter);
        Iterator<String> iterWhole1;
        iterWhole1 = queue.iterator();
        //buiild list view from queue
        while (iterWhole1.hasNext()) {
            q.add(iterWhole1.next());
        }

        Iterator<String> iter3;
        iter3 = priorityQueue.iterator();
        String priorityQueueIter = iter3.next();
        pqIterator.setText(priorityQueueIter);
        Iterator<String> iterWhole2;
        iterWhole2 = priorityQueue.iterator();
        //build list view from priority queue
        while (iterWhole2.hasNext()) {
            pq.add(iterWhole2.next());
        }
    }

    /**
     * checks the appropriate case based off the combo box will handle iterator
     * position, and adding the data from the text field
     */
    @FXML
    private void handleAddButton() {
        //check which collection to add to
        //will reset the iterator position when adding new data
        if (Collections.getValue().equals("SET")) {
            SetIteratorCount = 1;
            addDataToSet();
        } else if (Collections.getValue().equals("QUEUE")) {
            QueueIteratorCount = 1;
            addDataToQueue();
        } else if (Collections.getValue().equals("PRIORITY QUEUE")) {
            PriorityQueueIteratorCount = 1;
            addDataToPriorityQueue();
        } else {
            SetIteratorCount = 1;
            QueueIteratorCount = 1;
            PriorityQueueIteratorCount = 1;
            addDataToAll();
        }
    }

    /**
     * will randomly generate 5 char's and add them to the collection specified
     * by the combo box
     */
    @FXML
    private void handleAdd5Button() {
        //5 random char's
        Random r1 = new Random();
        char c1 = (char) (r1.nextInt(26) + 'a');
        Random r2 = new Random();
        char c2 = (char) (r2.nextInt(26) + 'a');
        Random r3 = new Random();
        char c3 = (char) (r3.nextInt(26) + 'a');
        Random r4 = new Random();
        char c4 = (char) (r4.nextInt(26) + 'a');
        Random r5 = new Random();
        char c5 = (char) (r5.nextInt(26) + 'a');

        //check which collection to add to
        if (Collections.getValue().equals("SET")) {
            //reset set iterator count
            SetIteratorCount = 1;
            //add chars to set one by one
            addRandomToSet(Character.toString(c1));
            addRandomToSet(Character.toString(c2));
            addRandomToSet(Character.toString(c3));
            addRandomToSet(Character.toString(c4));
            addRandomToSet(Character.toString(c5));
        } else if (Collections.getValue().equals("QUEUE")) {
            //reset queue iterator count
            QueueIteratorCount = 1;
            //add 5 chars to queue one by one
            addRandomToQueue(Character.toString(c1));
            addRandomToQueue(Character.toString(c2));
            addRandomToQueue(Character.toString(c3));
            addRandomToQueue(Character.toString(c4));
            addRandomToQueue(Character.toString(c5));
        } else if (Collections.getValue().equals("PRIORITY QUEUE")) {
            //reset pq itertator count
            PriorityQueueIteratorCount = 1;
            //add char to pq one by one
            addRandomToPriorityQueue(Character.toString(c1));
            addRandomToPriorityQueue(Character.toString(c2));
            addRandomToPriorityQueue(Character.toString(c3));
            addRandomToPriorityQueue(Character.toString(c4));
            addRandomToPriorityQueue(Character.toString(c5));
        } else {
            //reset position of all iterator counts
            SetIteratorCount = 1;
            QueueIteratorCount = 1;
            PriorityQueueIteratorCount = 1;
            //add char to all one by one
            addRandomToAll(Character.toString(c1));
            addRandomToAll(Character.toString(c2));
            addRandomToAll(Character.toString(c3));
            addRandomToAll(Character.toString(c4));
            addRandomToAll(Character.toString(c5));
        }
    }

    /**
     * will clear data from a collection(s) and list view(s) specified by the
     * combo box
     */
    @FXML
    private void handleClearButton() {
        //check which collection to clear
        if (Collections.getValue().equals("SET")) {
            set.clear();
            ObservableList<String> s = lvSet.getItems();
            s.clear();
            sIterator.setText("");
            //reset position of set iterator count
            SetIteratorCount = 1;
        } else if (Collections.getValue().equals("QUEUE")) {
            queue.clear();
            ObservableList<String> q = lvQueue.getItems();
            q.clear();
            qIterator.setText("");
            //reset position of queue iterator count
            QueueIteratorCount = 1;
        } else if (Collections.getValue().equals("PRIORITY QUEUE")) {
            priorityQueue.clear();
            ObservableList<String> pq = lvPriorityQueue.getItems();
            pq.clear();
            pqIterator.setText("");
            //reset position of priority queue iterator count
            PriorityQueueIteratorCount = 1;
        } else {
            //clear set
            set.clear();
            ObservableList<String> s = lvSet.getItems();
            s.clear();
            sIterator.setText("");
            //clear queuue
            queue.clear();
            ObservableList<String> q = lvQueue.getItems();
            q.clear();
            qIterator.setText("");
            //clear priority queue
            priorityQueue.clear();
            ObservableList<String> pq = lvPriorityQueue.getItems();
            pq.clear();
            pqIterator.setText("");
            //reset position of all iterator counts
            SetIteratorCount = 1;
            QueueIteratorCount = 1;
            PriorityQueueIteratorCount = 1;
        }
    }

    /**
     * will move the set iterator to the next spot doesn't move if at the end of
     * the collection only works if not empty
     */
    @FXML
    private void handleSetNextButton() {
        //not crashing here lol
        if (!set.isEmpty()) {
            Iterator<String> iter;
            iter = set.iterator();
            //if iterator is not at end...
            if (SetIteratorCount < set.size()) {
                for (int i = 0; i < SetIteratorCount; i++) {
                    iter.next();
                }
                sIterator.setText(iter.next());
                SetIteratorCount++;
            }
        }
    }

    /**
     * will reset the set iterator to the start only works if not empty
     */
    @FXML
    private void handleSetResetButton() {
        if (!set.isEmpty()) {
            Iterator<String> iter;
            iter = set.iterator();
            sIterator.setText(iter.next());
            SetIteratorCount = 1;
        }
    }

    /**
     * will move the queue iterator to the next spot doesn't move if at the end
     * of the collection only works if not empty
     */
    @FXML
    private void handleQueueNextButton() {
        if (!queue.isEmpty()) {
            Iterator<String> iter;
            iter = queue.iterator();
            //if iterator is not at end...
            if (QueueIteratorCount < queue.size()) {
                for (int i = 0; i < QueueIteratorCount; i++) {
                    iter.next();
                }
                qIterator.setText(iter.next());
                QueueIteratorCount++;
            }
        }
    }

    /**
     * will reset the queue iterator to the start only works if not empty
     */
    @FXML
    private void handleQueueResetButton() {
        if (!queue.isEmpty()) {
            Iterator<String> iter;
            iter = queue.iterator();
            qIterator.setText(iter.next());
            QueueIteratorCount = 1;
        }
    }

    /**
     * will move the priority queue iterator to the next spot doesn't move if at
     * the end of the collection only works if not empty
     */
    @FXML
    private void handlePriorityQueueNextButton() {
        if (!priorityQueue.isEmpty()) {
            Iterator<String> iter;
            iter = priorityQueue.iterator();
            //if iterator is not at end...
            if (PriorityQueueIteratorCount < priorityQueue.size()) {
                for (int i = 0; i < PriorityQueueIteratorCount; i++) {
                    iter.next();
                }
                pqIterator.setText(iter.next());
                PriorityQueueIteratorCount++;
            }
        }
    }

    /**
     * will reset the priority queue iterator to the start only works if not
     * empty
     */
    @FXML
    private void handlePriorityQueueResetButton() {
        if (!priorityQueue.isEmpty()) {
            Iterator<String> iter;
            iter = priorityQueue.iterator();
            pqIterator.setText(iter.next());
            PriorityQueueIteratorCount = 1;
        }
    }

    /**
     * not used
     *
     * @throws IOException secondary root not found
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
