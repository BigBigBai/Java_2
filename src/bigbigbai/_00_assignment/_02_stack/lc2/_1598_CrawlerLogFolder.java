package bigbigbai._00_assignment._02_stack.lc2;

import java.util.Stack;

public class _1598_CrawlerLogFolder {
    // stack
    public int minOperations(String[] logs) {
        int index = 0;

        for (String log : logs) {

            if (log.equals("./")) continue;
            if (index == 0 && log.equals("../")) continue;

            if (index != 0 && log.equals("../")) index--;
            else {
                logs[index++] = log;
            }
        }

        return index;
    }
}
