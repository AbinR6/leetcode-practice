/*
==========================================
Problem: Merge Two Sorted Lists (LeetCode #21)
------------------------------------------
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list and return it.

Time Complexity: O(n + m)
Space Complexity: O(1) (in-place)
Difficulty: Easy
------------------------------------------
Approach 1: Iterative Merge (Two-Pointer)
Approach 2: Recursive Merge
==========================================
*/

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    // Constructor used to initialize node with value
    ListNode(int val) {
        this.val = val;
    }

    // Constructor kept for completeness, marked as intentionally unused
    @SuppressWarnings("unused")
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Convert "[1,2,3]" string into linked list
    static ListNode deserialize(String input) {
        input = input.replaceAll("\\[|\\]|\\s", "");
        if (input.isEmpty()) return null;
        String[] parts = input.split(",");
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (String s : parts) {
            cur.next = new ListNode(Integer.parseInt(s));
            cur = cur.next;
        }
        return dummy.next;
    }

    // Convert linked list to "[1,2,3]" string
    static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class MergeTwoSortedLists {

    // Approach 1: Iterative Merge (Two-Pointer)
    ListNode mergeTwoLists_Iterative(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    // Approach 2: Recursive Merge
    ListNode mergeTwoLists_Recursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists_Recursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_Recursive(list1, list2.next);
            return list2;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        ListNode l1 = ListNode.deserialize("[1,2,4]");
        ListNode l2 = ListNode.deserialize("[1,3,4]");

        ListNode merged1 = obj.mergeTwoLists_Iterative(l1, l2);
        System.out.println("Iterative Merge: " + ListNode.serialize(merged1));

        // Recreate lists for recursive test
        l1 = ListNode.deserialize("[1,2,4]");
        l2 = ListNode.deserialize("[1,3,4]");
        ListNode merged2 = obj.mergeTwoLists_Recursive(l1, l2);
        System.out.println("Recursive Merge: " + ListNode.serialize(merged2));
    }
}

/*
Example:
Input:  list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

------------------------------------------
Approach 1: Iterative (Best for efficiency)
Approach 2: Recursive (Cleaner, uses extra stack space)
*/
