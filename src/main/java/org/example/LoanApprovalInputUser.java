package org.example;

import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.util.Scanner;

public class LoanApprovalInputUser {
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

//        // Step 5: Accept input for client's data
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the following details for the client:");
//        System.out.print("Loan ID: ");
//        int loanId = scanner.nextInt();
//        System.out.print("Number of Dependents: ");
//        int noOfDependents = scanner.nextInt();
//        System.out.print("Education (0 for Not Graduate, 1 for Graduate): ");
//        int education = scanner.nextInt();
//        System.out.print("Self Employed (0 for No, 1 for Yes): ");
//        int selfEmployed = scanner.nextInt();
//        System.out.print("Annual Income: ");
//        double incomeAnnum = scanner.nextDouble();
//        System.out.println("Loan Amount: ");
//        double loanAmount = scanner.nextDouble();
//        System.out.println("Loan Term (Years): ");
//        int loanTerm = scanner.nextInt();
//        System.out.println("Credit Score: ");
//        int cibilScore = scanner.nextInt();
//        System.out.println("Residential Assets: ");
//        double residentialAssets = scanner.nextDouble();
//        System.out.print("Commercial Assets: ");
//        double commercialAssets = scanner.nextDouble();
//        System.out.print("Luxury Assets: ");
//        double luxuryAssets = scanner.nextDouble();
//        System.out.print("Bank Assets: ");
//        double bankAssets = scanner.nextDouble();
//        // Similarly, accept input for other attributes...
//
//        // Step 6: Create a new instance representing the client's data
//        Instances unlabeled = new Instances(testData, 0, 1); // Create an empty dataset
//        unlabeled.setClassIndex(unlabeled.numAttributes() - 1); // Set class attribute index
//
//        //loan_id, no_of_dependents, education, self_employed, income_annum, loan_amount, loan_term, cibil_score, residential_assets_value, commercial_assets_value, luxury_assets_value, bank_asset_value
//        // Create a new instance with the client's data
//        DenseInstance instance = new DenseInstance(12); // 12 is the number of attributes
//        instance.setValue(0, loanId);
//        instance.setValue(1, noOfDependents);
//        instance.setValue(2, education);
//        instance.setValue(3, selfEmployed);
//        instance.setValue(4, incomeAnnum);
//        instance.setValue(5, loanAmount);
//        instance.setValue(6, loanTerm);
//        instance.setValue(7, cibilScore);
//        instance.setValue(8, residentialAssets);
//        instance.setValue(9, commercialAssets);
//        instance.setValue(10, luxuryAssets);
//        instance.setValue(11, bankAssets);
//        // Similarly, set values for other attributes...
//        unlabeled.add(instance);
//
//        // Step 7: Predict loan status for the client
//        double predictedLabel = decisionTree.classifyInstance(unlabeled.instance(1));
//        String predictedLoanStatus = unlabeled.classAttribute().value((int) predictedLabel);
//
//        // Step 8: Output predicted loan status for the client
//        System.out.println("Predicted Loan Status for the client: " + predictedLoanStatus);


        // Step 9: Debugging - Count instances where loan was not approved
        int notApprovedCount = 0;
        for (int i = 0; i < testData.numInstances(); i++) {
            double actualLabel = decisionTree.classifyInstance(testData.instance(i));
            String actualLoanStatus = testData.classAttribute().value((int) actualLabel);
            if (actualLoanStatus.equals(" Rejected")) {
                notApprovedCount++;
                System.out.println(testData.instance(i));
            }
        }
        System.out.println("Number of instances where loan was not approved in the test data: " + notApprovedCount);

//        // Step 10: Debugging - Print actual and predicted loan status for test instances
//        System.out.println("\nActual vs. Predicted Loan Status for Test Instances:");
//        for (int i = 0; i < testData.numInstances(); i++) {
//            double actualLabel = decisionTree.classifyInstance(testData.instance(i));
//            String actualLoanStatus = testData.classAttribute().value((int) actualLabel);
//            double predictedLabelTest = decisionTree.classifyInstance(testData.instance(i));
//            String predictedLoanStatusTest = testData.classAttribute().value((int) predictedLabelTest);
//            if (!actualLoanStatus.equals(predictedLoanStatusTest)){
//                System.out.println("Instance " + i + ": Actual = " + actualLoanStatus + ", Predicted = " + predictedLoanStatusTest);
//            }
//        }
    }
}
