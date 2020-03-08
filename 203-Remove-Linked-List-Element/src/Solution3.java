public class Solution3 {
    public ListNode removeElements(ListNode head,int val){
        if (head == null)
            return null;
        ListNode res = removeElements(head.next,val);
        return head.val == val ? head.next : head;
        }
    }


