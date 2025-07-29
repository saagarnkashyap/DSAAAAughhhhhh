class MyQueue {
    private Stack<Integer> string1;
    private Stack<Integer> string2;

    public MyQueue() {
        string1=new Stack<>();
        string2=new Stack<>();
        
    }
    
    public void push(int x) {
        while(!string1.isEmpty()){
            string2.push(string1.pop());
        }
        string1.push(x);

        while(!string2.isEmpty()){
            string1.push(string2.pop());
        }
    }
    
    public int pop() {
        if(string1.isEmpty()){
            return -1;
        }
        return string1.pop();
    }
    
    public int peek() {
        if(string1.isEmpty()){
            return -1;
        }
        return string1.peek();
    }
    
    public boolean empty() {
        return string1.isEmpty();
    }
}
