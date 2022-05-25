package random;


public class C04倒数第k个结点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode index = head;
        int count = 1;
        while (index != null){
            index = index.next;
            count++;
        }
        ListNode res = head;
        for (int i = 0; i < count-k; i++) {
            res = res.next;
        }
        return res;
    }

    private class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
}
