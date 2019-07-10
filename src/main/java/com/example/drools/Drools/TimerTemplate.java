package com.example.drools.Drools;

import org.springframework.stereotype.Component;

@Component
public class TimerTemplate {


    public static final String workTimerST = "wordImport(rules) ::=<<\n" +
            "package com.w.iot;\n" +
            "import java.text.SimpleDateFormat;\n" +
            "import java.util.Date;\n" +
            " \n" +
            "global java.text.SimpleDateFormat fmt;\n" +

            "<rules; separator=\"\\n\\n\">\n" +
            ">>\n" +
            "\n" +
            "ruleValue(condition,action,rule) ::=<<\n" +
            "rule \"<rule.name>\"\n" +
            "\t\ttimer(cron: */1 * * * * ?)\n" +
            "\t\twhen\n" +
            "\t\t   eval(true)\n" +
            " \t\tthen\n" +
            "          System.out.println(fmt.format(new Date()));  \n" +
            "end\n" +
            ">>\n";
}
