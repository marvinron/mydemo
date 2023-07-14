package com.maviron.spring.springdemo.actor.akka.akkademo;

import akka.actor.ActorPath;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.util.Random;
import java.util.Scanner;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ApplicationMaster.java
 * @Description TODO
 * @createTime 2023年07月14日 14:32:00
 */
public class ApplicationMaster {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("demo");
        ActorRef jobManager = system.actorOf(JobManager.props(), "jobManager");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">> ");
            String op = scanner.nextLine();
            switch (op) {
                case "init":
                    jobManager.tell(new InitRequest(3), ActorRef.noSender());
                    break;
                case "fail":
                    ActorPath child = jobManager.path().child("taskManager-" + new Random().nextInt(3));
                    system.actorSelection(child).tell("fail", ActorRef.noSender());
                    break;
                case "stop":
                    jobManager.tell("stop", ActorRef.noSender());
                    System.exit(0);
            }
        }
    }
}
