package com.maviron.spring.springdemo.ifdemo;

/**
 * 构建一条完整的责任链路
 */
public class ActionHandlerFactory {
    
    private ActionHandler headHandler;
    
    private ActionHandlerFactory(){
        headHandler = new HeadHandler();
        ActionHandler actionHandler1 = new ActionHandler1();
        ActionHandler actionHandler2 = new ActionHandler2();
        // ActionHandler actionHandler3 = new ActionHandler3();
        // ActionHandler actionHandler4 = new ActionHandler4();
        // ActionHandler actionHandler5 = new ActionHandler5();

        ActionHandler tailHandler = new TailHandler();
        
        // 构建一条完整的责任链
        headHandler.setSuccessor(actionHandler1).setSuccessor(actionHandler2).setSuccessor(tailHandler);
    }

    private static class SingletonHolder{
        private static ActionHandlerFactory instance=new ActionHandlerFactory();
    }

    public static ActionHandlerFactory getInstance(){
        return SingletonHolder.instance;
    }
        
    public void doAction(String actionCode) {
        headHandler.doHandler(actionCode);
    }

    public static void main(String[] args) {
        ActionHandlerFactory.getInstance().doAction("action1");
    }
}