package com.gla;

class InventoryNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryNode next;

    InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManagementSystem {

    public InventoryNode addAtBeginning(InventoryNode head, String itemName, int itemId, int quantity, double price) {
        InventoryNode node = new InventoryNode(itemName, itemId, quantity, price);
        node.next = head;
        return node;
    }

    public InventoryNode addAtEnd(InventoryNode head, String itemName, int itemId, int quantity, double price) {
        InventoryNode node = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            return node;
        }
        InventoryNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        return head;
    }

    public InventoryNode addAtIndex(InventoryNode head, int index, String itemName, int itemId, int quantity, double price) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
        if (index == 0) {
            return addAtBeginning(head, itemName, itemId, quantity, price);
        }
        InventoryNode curr = head;
        int count = 0;
        while (curr != null && count < index - 1) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        InventoryNode node = new InventoryNode(itemName, itemId, quantity, price);
        node.next = curr.next;
        curr.next = node;
        return head;
    }

    public InventoryNode removeById(InventoryNode head, int itemId) {
        if (head == null) return null;
        if (head.itemId == itemId) return head.next;
        InventoryNode curr = head;
        while (curr.next != null) {
            if (curr.next.itemId == itemId) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }

    public boolean updateQuantity(InventoryNode head, int itemId, int newQuantity) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public InventoryNode searchById(InventoryNode head, int itemId) {
        InventoryNode curr = head;
        while (curr != null) {
            if (curr.itemId == itemId) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public double totalInventoryValue(InventoryNode head) {
        double totalSum = 0;
        InventoryNode temp = head;
        while (temp != null) {
            totalSum += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalSum;
    }

    public InventoryNode sortByPrice(InventoryNode head) {
        if (head == null) return null;
        boolean swapped;
        do {
            swapped = false;
            InventoryNode curr = head;
            while (curr.next != null) {
                if (curr.price > curr.next.price) {
                    String tempName = curr.itemName;
                    curr.itemName = curr.next.itemName;
                    curr.next.itemName = tempName;

                    int tempId = curr.itemId;
                    curr.itemId = curr.next.itemId;
                    curr.next.itemId = tempId;

                    int tempQty = curr.quantity;
                    curr.quantity = curr.next.quantity;
                    curr.next.quantity = tempQty;

                    double tempPrice = curr.price;
                    curr.price = curr.next.price;
                    curr.next.price = tempPrice;

                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
        return head;
    }

    public void displayInventory(InventoryNode head) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        InventoryNode curr = head;
        while (curr != null) {
            System.out.println("Item ID: " + curr.itemId +
                    ", Name: " + curr.itemName +
                    ", Quantity: " + curr.quantity +
                    ", Price: " + curr.price);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        InventoryNode head = null;

        head = ims.addAtEnd(head, "Laptop", 101, 5, 50000);
        head = ims.addAtEnd(head, "Mouse", 102, 10, 500);
        head = ims.addAtBeginning(head, "Keyboard", 103, 7, 1500);
        head = ims.addAtIndex(head, 1, "Monitor", 104, 3, 12000);

        System.out.println("Inventory before sorting:");
        ims.displayInventory(head);

        head = ims.sortByPrice(head);

        System.out.println("\n after sorting by price:");
        ims.displayInventory(head);

        double totalValue = ims.totalInventoryValue(head);
        System.out.println("\nTotal Inventory Value: " + totalValue);

        ims.updateQuantity(head, 102, 15);
        System.out.println("\n after updating quantity of item ID 102:");
        ims.displayInventory(head);

        head = ims.removeById(head, 103);
        System.out.println("\nInventory after removing item ID 103:");
        ims.displayInventory(head);
    }
}
