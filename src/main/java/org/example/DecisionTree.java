package org.example;

public class DecisionTree {
    private DecisionTreeNode root;

    public DecisionTree() {
        // Construct the decision tree here
        // For simplicity, let's assume a predefined decision tree
        // You can later extend this to construct the tree from data
        root = constructDecisionTree();
    }

    private DecisionTreeNode constructDecisionTree() {
        // Construct the decision tree based on your dataset and algorithm
        // For simplicity, let's assume a simple decision tree
        DecisionTreeNode rootNode = new DecisionTreeNode("Salary", null);
        DecisionTreeNode decisionNode = new DecisionTreeNode("Expenses", null);
        DecisionTreeNode yesLeaf = new DecisionTreeNode(null, true);
        DecisionTreeNode noLeaf = new DecisionTreeNode(null, false);

        rootNode.addYesBranch(decisionNode);
        rootNode.addNoBranch(noLeaf);

        decisionNode.addYesBranch(yesLeaf);
        decisionNode.addNoBranch(noLeaf);

        return rootNode;
    }

    public boolean shouldGiveLoan(int salary, int expenses) {
        // Start traversing the decision tree based on input data
        return traverseDecisionTree(root, salary, expenses);
    }

    private boolean traverseDecisionTree(DecisionTreeNode node, int salary, int expenses) {
        if (node == null)
            return false;

        if (node.question != null && node.value != null) {
            // Check the condition
            if (node.question.equals("Salary")) {
                if (salary >= (int) node.value)
                    return traverseDecisionTree(node.yesBranch, salary, expenses);
                else
                    return traverseDecisionTree(node.noBranch, salary, expenses);
            } else if (node.question.equals("Expenses")) {
                if (expenses <= (int) node.value)
                    return traverseDecisionTree(node.yesBranch, salary, expenses);
                else
                    return traverseDecisionTree(node.noBranch, salary, expenses);
            }
        }

        return (boolean) node.value; // Leaf node reached, return decision
    }
}
