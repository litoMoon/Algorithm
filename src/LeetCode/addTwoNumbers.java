package LeetCode;

public class addTwoNumbers {
    public ListNode addNumbers(ListNode l1, ListNode l2) {
        //拿一个标志位表示进位
        int flag=0,num1=0,num2=0,newValue=0;
        ListNode ResultList=new ListNode();
        ListNode cur=ResultList;
        while(l1!=null && l2!=null){
            num1=l1.val;
            num2=l2.val;
            int aim=num1+num2+flag;
            if(aim>9) flag=1;
            else flag=0;
            newValue=(aim)%10;
            cur.next=new ListNode(newValue);
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            num1=l1.val;
            int aim=num1+flag;
            if(aim>9) flag=1;
            else flag=0;
            newValue=(aim)%10;
            cur.next=new ListNode(newValue);
            cur=cur.next;
            l1=l1.next;
        }
        while(l2!=null){
            num2=l2.val;
            int aim=num2+flag;
            if(aim>9) flag=1;
            else flag=0;
            newValue=(aim)%10;
            cur.next=new ListNode(newValue);
            cur=cur.next;
            l2=l2.next;
        }
        if(flag==1)  cur.next=new ListNode(1);
        return ResultList;
    }
}
