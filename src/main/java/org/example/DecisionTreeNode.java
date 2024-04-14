package org.example;

import java.util.Map;

public class DecisionTreeNode {
    String question;
    Object value;
    DecisionTreeNode yesBranch;
    DecisionTreeNode noBranch;

    public DecisionTreeNode(String question, Object value) {
        this.question = question;
        this.value = value;
        this.yesBranch = null;
        this.noBranch = null;
    }

    public void addYesBranch(DecisionTreeNode node) {
        this.yesBranch = node;
    }

    public void addNoBranch(DecisionTreeNode node) {
        this.noBranch = node;
    }

    // פונקציה להכרעת החלטה על פי הנתונים
    public boolean decide(Map<String, Object> data) {
        if (this.question == null || this.value == null) {
            // אם אין שאלה או ערך, אנחנו בעלה של ההחלטה
            return true;
        }
        return true;
    }
}