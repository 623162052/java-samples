package javase.collections.list;

import java.util.Iterator;

/**
 * 
 * @author Matthew
 * @description ˫������Ĭ����һ���յĽڵ�
 */
public class DoubleSidedLinkedList {
	private Node rootNode = null;
	private int flag = 0;
	
	public DoubleSidedLinkedList(){
		rootNode = new Node(null,null,null);
		rootNode.previous = rootNode;
		rootNode.previous = rootNode;
	}
		
	//�ڲ���
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
	
	//ȡ���ض��������Ľڵ�
	private Node getNode(int index){
		Node temp = rootNode;
		if(index > flag || index < 0){
			System.out.println("���벻��ȷ");
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
	
	
	//��ӽڵ�
	protected void add(Object obj){
		Node node = new Node(obj,null,null);
		
		node.previous = rootNode.previous;
		rootNode.previous.next = node;	
		node.next = rootNode;
		rootNode.previous = node;
		flag++;
	}
	
	//ɾ��ĳ���ڵ�
	protected void delete(int index){
		Node node = getNode(index);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		flag--;
	}
	
	
	//ȡ���ض��������Ľڵ��ڵĶ���
	protected Object getObj(int x){
		Node temp = rootNode;
		if(x > flag || x < 0){
			System.out.println("���벻��ȷ");
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
	
	//����˫������Ĵ�С���յ�rootNode����
	protected int getFlag(){
		return flag;
	}
	
	//������
	class LinkedListIterator implements Iterator<Object>{
		
		private Node node = rootNode;
		
		//�ж��Ƿ�������
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
				System.out.println("��ǰָ����ڵ�");
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
	
	//�õ�һ��������
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
		
//		System.out.println("˫������һ�������  " + test.getFlag() + " ���ڵ�");	
//		System.out.println(test.getObj(1));
//		System.out.println(test.getObj(4));
//		
//		test.delete(4);
//		System.out.println(test.getFlag());
		
		Iterator<?> iterator = test.iterator();
		System.out.println("������ʼ");
		while(iterator.hasNext()){
			iterator.remove();
		}
		
		System.out.println(test.getFlag());
		System.out.println("��������");
		
	}
	
}



















