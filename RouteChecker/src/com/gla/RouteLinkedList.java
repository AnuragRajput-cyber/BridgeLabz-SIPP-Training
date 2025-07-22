package com.gla;

public class RouteLinkedList<T extends Checkpoint> {
    private Node<T> head;

    public void addCheckpoint(T checkpoint) {
        Node<T> newNode = new Node<>(checkpoint);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public boolean removeCheckpoint(String checkpointId) {
        if (head == null) return false;

        if (head.data.getCheckpointId().equals(checkpointId)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.getCheckpointId().equals(checkpointId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public T findCheckpoint(String checkpointId) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.getCheckpointId().equals(checkpointId))
                return current.data;
            current = current.next;
        }
        return null;
    }

    public double computeTotalDistance() {
        double total = 0.0;
        Node<T> current = head;
        while (current != null) {
            total += current.data.getDistance();
            current = current.next;
        }
        return total;
    }

    public double computeTotalPenalty() {
        double total = 0.0;
        Node<T> current = head;
        while (current != null) {
            total += current.data.calculatePenalty();
            current = current.next;
        }
        return total;
    }

    public boolean checkCriticalCheckpointsPresent() {
        boolean deliveryFound = false;
        boolean fuelFound = false;

        Node<T> current = head;
        while (current != null) {
            if (current.data instanceof DeliveryCheckpoint)
                deliveryFound = true;
            if (current.data instanceof FuelCheckpoint)
                fuelFound = true;
            current = current.next;
        }

        return deliveryFound && fuelFound;
    }

    public void printRoute() {
        Node<T> current = head;
        int index = 1;
        while (current != null) {
            T cp = current.data;
            String status = cp.isDelayed() ? "Delayed" : "On Time";
            System.out.printf("%d. %s – %s – %s – Penalty: %.1f%n",
                    index++,
                    cp.getType(),
                    cp.getLocationName(),
                    status,
                    cp.calculatePenalty());
            current = current.next;
        }
    }
}
