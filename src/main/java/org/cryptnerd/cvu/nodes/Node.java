package org.cryptnerd.cvu.nodes;

public class Node {

	public String data;
	public Node next;

	public Node(String data) {
		this.data = data;
		this.next = null;
	}

	public void setNextNode(Node node) {
		this.next = node;
	}
	public static void main(String[] args) {
		Node firstNode = new Node("I am a Node!");
		System.out.println(firstNode.data);
		System.out.println(firstNode.next.data);
	}

}
