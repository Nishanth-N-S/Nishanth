import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BottomUpApproach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int[] coins = {1,2,5};

		Node head = new Node(0, null, new ArrayList<>());

		while(head != null && head.num != sum) {
			for(int i = 0; i<coins.length; i++) {
				int num = head.num+coins[i];
				if(num > sum) {
					break;
				}
				head.addChild(new Node(num, head, new ArrayList<>()));
			}
			head = head.getLastNode();
		}

		if(head == null) {
			System.out.println("Combination not possible");
		}else {
            printCoins(head);
		}

	}
	
	private static void printCoins(Node head){
		if(head.parent == null) {
			return;
		}
		printCoins(head.parent);
		System.out.println(head.num-head.parent.num);
	}

	static class Node{
		private int num;
		private Node parent;
		private List<Node> children;

		Node(int num, Node parent, List<Node> nodes){
			this.num = num;
			this.parent = parent;
			this.children = nodes;
		}

		private void addChild(Node node) {
			children.add(node);
		}
		
		private Node getLastNode() {
			if(children.size()==0) {
				if(parent==null) {
					return null;
				}
				parent.children.remove(this);
				return parent.getLastNode();
			}
			return children.get(children.size()-1);
		}
	}

}
