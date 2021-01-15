package org.springboot.demo.bean.handler;

public enum ActionTypeJudger implements ActionTypeJudge{

    TEST{
        public ActionHandler getAction() {
            TestActionHandler testActionHandler = new TestActionHandler();
            return testActionHandler;
        }
    }

}
