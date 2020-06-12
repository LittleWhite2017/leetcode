package solution.offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 */
public class CQueue {
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;
    public CQueue() {
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if(stackB.size() != 0){
            return stackB.pop();
        }else{
            if(stackA.size() == 0){
                return -1;
            }
            while(stackA.size() != 0){
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }
    }
}
