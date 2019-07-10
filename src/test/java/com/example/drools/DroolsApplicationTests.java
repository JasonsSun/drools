package com.example.drools;

import com.example.drools.vo.ResultEvent;
import com.example.drools.vo.Server;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsApplicationTests {

//    @Test
//    public void contextLoads() {
//    }
@Test
public void timerTest() throws InterruptedException {
    KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
    InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
    kBase.addPackages(kb.getKnowledgePackages());
    // 执行规则createKnowledgeSession()
//    kSession = ;
//    final KieSession kieSession = kBase.newKieSession();
    final KieSession kieSession = createKnowledgeSession();
    ResultEvent event = new ResultEvent();
    kieSession.setGlobal("event", event);

    final Server server = new Server(1);

    new Thread(new Runnable() {
        public void run() {
            kieSession.fireUntilHalt();
        }
    }).start();

    FactHandle serverHandle = kieSession.insert(server);

    for (int i = 8; i <= 15; i++) {
        Thread.sleep(2000);
        server.setTimes(++i);
        kieSession.update(serverHandle, server);
    }

    Thread.sleep(3000);
    kieSession.halt();
    System.out.println(event.getEvents());
}

    private KieSession createKnowledgeSession() {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("ksession-rule");
        return kSession;
    }

}
