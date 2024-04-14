package org.example;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.File;

public class LoanApprovalClassifier {
    public static void main(String[] args) throws Exception {
        // Step 1: Load dataset from CSV file
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File("C:/Users/yoavz/IdeaProjects/LoanRequest/src/main/java/org/example/loan_approval_dataset.csv"));
        Instances data = loader.getDataSet();

        // Step 2: Set class attribute (assuming the last attribute is the class label)
        data.setClassIndex(data.numAttributes() - 1);

        // Step 2: Preprocess the dataset if needed

        // Step 3: Split the dataset into training and testing sets (e.g., 70% for training, 30% for testing)
        int trainSize = (int) Math.round(data.numInstances() * 0.7);
        int testSize = data.numInstances() - trainSize;
        Instances trainData = new Instances(data, 0, trainSize);
        Instances testData = new Instances(data, trainSize, testSize);

        // Step 4: Train a decision tree classifier
        J48 decisionTree = new J48();
        decisionTree.buildClassifier(trainData);

        // Step 5: Evaluate the classifier
        Evaluation eval = new Evaluation(trainData);
        eval.evaluateModel(decisionTree, testData);

        // Print evaluation results
        System.out.println(eval.toSummaryString("Evaluation Results\n", false));
    }
}
