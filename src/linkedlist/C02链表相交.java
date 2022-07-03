package linkedlist;

public class C02链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode headALen = headA;
        ListNode headBLen = headB;
        while (headALen != null){
            lengthA++;
            headALen = headALen.next;
        }
        while (headBLen != null){
            lengthB++;
            headBLen = headBLen.next;
        }
        int len;
        ListNode res = null;
        if (lengthA>lengthB){
            len = lengthA - lengthB;
            res = getRes(len,headA,headB);
        }else {
            len = lengthB - lengthA;
            res = getRes(len,headB,headA);
        }
        return res;
    }

    private ListNode getRes(int len, ListNode head1, ListNode head2) {
        while (len > 0){
            head1 = head1.next;
            len--;
        }
        while (head1 != null && head2 != null){
            if (head1 == head2){
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}

