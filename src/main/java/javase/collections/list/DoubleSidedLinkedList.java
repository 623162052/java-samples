package javase.collections.list;

import java.util.Iterator;

/**
 * 
 * @author Matthew
 * @description 双向链表，默认有一个空的节点
 */
public class DoubleSidedLinkedList {
	private Node rootNode = null;
	private int flag = 0;
	
	public DoubleSidedLinkedList(){
		rootNode = new Node(null,null,null);
		rootNode.previous = rootNode;
		rootNode.previous = rootNode;
	}
		
	//内部类
	private class Node{
		Object value;
		Node previous;
		Node next;
		
		public Node(Object value, Node previous, Node next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}
	
	//取得特定索引处的节点
	private Node getNode(int index){
		Node temp = rootNode;
		if(index > flag || index < 0){
			System.out.println("输入不正确");
			System.exit(0);
		}else{
			if(index <= (flag+1)/2){
				for(int i = 0; i < index; i++){
					temp = temp.next;			
				}
			}else{
				for(int j = flag+1; j > flag; j--){
					temp = temp.previous;		
				}
			}
		}	
		return temp;
	}
	
	
	//添加节点
	protected void add(Object obj){
		Node node = new Node(obj,null,null);
		
		node.previous = rootNode.previous;
		rootNode.previous.next = node;	
		node.next = rootNode;
		rootNode.previous = node;
		flag++;
	}
	
	//删除某个节点
	protected void delete(int index){
		Node node = getNode(index);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		flag--;
	}
	
	
	//取得特定索引处的节点内的对象
	protected Object getObj(int x){
		Node temp = rootNode;
		if(x > flag || x < 0){
			System.out.println("输入不正确");
			System.exit(0);
		}else{
			if(x <= (flag+1)/2){
				for(int i = 0; i < x; i++){
					temp = temp.next;			
				}
			}else{
				for(int j = flag+1; j > flag; j--){
					temp = temp.previous;		
				}
			}
		}	
		return temp.value.toString();
	}
	
	//返回双向链表的大小，空的rootNode不算
	protected int getFlag(){
		return flag;
	}
	
	//迭代器
	class LinkedListIterator implements Iterator<Object>{
		
		private Node node = rootNode;
		
		//判断是否遍历完成
		@Override
		public boolean hasNext() {
			return node.next != rootNode;
		}
		
		
		
		@Override
		public Object next() {
			node = node.next;
			return node.value;
		}

		@Override
		public void remove() {
			if(node == rootNode){
				System.out.println("当前指向根节点");
				next();
			}else{
				Node temp = node.next;
				node.previous.next = node.next;
				node.next.previous = node.previous;
				flag--;
				node = temp;
				
			}	
			
		}
	}
	
	//得到一个迭代器
	public Iterator<Object> iterator(){
		return new LinkedListIterator();
	}
	
	public static void main(String[] args){
		DoubleSidedLinkedList test = new DoubleSidedLinkedList();
		test.add("abc");
		test.add("def");
		test.add("ghi");
		test.add("jkl");
		test.add("jkl");
		
//		System.out.println("双向链表一共存放了  " + test.getFlag() + " 个节点");	
//		System.out.println(test.getObj(1));
//		System.out.println(test.getObj(4));
//		
//		test.delete(4);
//		System.out.println(test.getFlag());
		
		Iterator<?> iterator = test.iterator();
		System.out.println("遍历开始");
		while(iterator.hasNext()){
			iterator.remove();
		}
		
		System.out.println(test.getFlag());
		System.out.println("遍历结束");
		
	}
	
}



















