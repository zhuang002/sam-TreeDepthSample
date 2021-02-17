import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static int[][] tree=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadInput();
		System.out.println(treeDepth(1));
		// System.out.println(treeDepth(root));

	}

	private static int treeDepth(int i) {
		// TODO Auto-generated method stub
		ArrayList<Integer> children=getChildren(i);
		if (children.isEmpty()) {
			return 0;
		}
		int maxDepth=Integer.MIN_VALUE;
		for (Integer subNode:children) {
			int depth=treeDepth(subNode);
			if (maxDepth<depth) {
				maxDepth=depth;
			}
		}
		
		return maxDepth+1;
	}

	private static ArrayList<Integer> getChildren(int node) {
		// TODO Auto-generated method stub
		ArrayList<Integer> subNodes=new ArrayList<>();
		for (int i=1;i<tree.length;i++) {
			if (tree[node][i]==1) {
				subNodes.add(i);
			}
		}
		return subNodes;
	}

	private static void ReadInput() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int lines=sc.nextInt();
		int nodes=sc.nextInt();
		tree=new int[nodes+1][nodes+1];
		for (int i=0;i<nodes+1;i++) {
			for (int j=0;j<nodes+1;j++) {
				tree[i][j]=0;
			}
		}
		for (int i=0;i<lines;i++) {
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			tree[n1][n2]=1;
		}
		
	}

}
