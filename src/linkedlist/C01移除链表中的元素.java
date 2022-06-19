package linkedlist;


public class C01移除链表中的元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode list = new ListNode();
        list.next = head;
        ListNode temp = list;
        while (head != null){
            if (head.val == val){
                temp.next = head.next;
            }else {
                temp = head;
            }
            head = head.next;
        }
        return list.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}