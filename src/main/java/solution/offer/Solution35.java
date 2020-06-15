package solution.offer;

import struct.Node;

/**
 * 面试题35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution35 {
    public static void main(String[] args) {

        Node node7null = new Node(7);
        Node node130 = new Node(13);
        node130.random = node7null;
        Node node114 = new Node(11);
        Node node102 = new Node(10);
        Node node10 = new Node(1);
        node114.random = node10;
        node10.random = node7null;
        node102.random = node114;
        node7null.next = node130;
        node130.next = node114;
        node114.next =node102;
        node102.next = node10;

        Node node = new Solution35().copyRandomList(node7null);
        System.out.println(node);


    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        copy(head);
        redirectRandom(head);
        return reList(head);
    }

    private Node reList(Node head) {
        // 将链表拆成两个，注意要恢复原有的链表
        Node res = head.next;
        Node tmp = res;

        head.next = head.next.next;//这一步不可缺少，保证第一个复制节点对N N'的分离操作
        head = head.next;
        while(head!=null){
            tmp.next = head.next;
            head.next = head.next.next;
            tmp=tmp.next;
            head = head.next;
        }
        return res;

    }

    private void copy(Node head){
        Node tempNode = head;
        while(tempNode != null){
            Node colneNode = new Node(tempNode.val);
            Node tempNodeNext = tempNode.next;
            tempNode.next = colneNode;
            colneNode.next = tempNodeNext;
            tempNode = tempNodeNext;
        }
    }

    private void redirectRandom(Node head){
        Node tempHead = head;
        while (tempHead!=null){
            Node cloneNode = tempHead.next;
            if(tempHead.random!=null){
                Node direct = tempHead.random;
                cloneNode.random = direct.next;
            }
            tempHead = tempHead.next.next;
        }
    }
}
