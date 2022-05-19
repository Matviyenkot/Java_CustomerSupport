package LineClasses;

import java.util.ArrayList;
import java.util.List;

public class CompareLines {


    public void showAverageTime(String ask){

        String[] askArr = ask.split("\n");

        List<Integer> queryIdList = new ArrayList<>();
        List<WaitingTimeline> waitingTimelineList = new ArrayList<>();

        //finding all queries
        for (int i = 1; i < askArr.length; i++) {
            if (askArr[i].startsWith("D")) {
                queryIdList.add(i);
            }
        }

        //place where we should start from finding new Customer's asks
        int startOfAddingNewCustomerAsks = 0;

        //finding all customers asks which pass to the query
        for (int queryId : queryIdList){

            QueryLine queryLine = createQueryLine(askArr, queryId);

            startOfAddingNewCustomerAsks = createWaitingTimeLineList(askArr, waitingTimelineList
                    , queryId, startOfAddingNewCustomerAsks);

            String result = showWaitingTime(waitingTimelineList, queryLine);

            System.out.println(result);
        }

    }

    private QueryLine createQueryLine(String[] askArr, int queryId){
        String[] queryArr = askArr[queryId].split(" ");

        QueryLine queryLine = null;

        switch (queryArr.length) {
            case 5:
                queryLine = new QueryLine(queryArr[1], queryArr[2], queryArr[3], queryArr[4]);
                break;
            case 4:
                queryLine = new QueryLine(queryArr[1], queryArr[2], queryArr[3]);
                break;
        }

        return queryLine;
    }

    private int createWaitingTimeLineList(String[] askArr, List<WaitingTimeline> waitingTimelineList
            , int queryId, int startOfAddingNewCustomerAsks){

        //adding customers asks to list
        for (int i = startOfAddingNewCustomerAsks; i < queryId; i++) {

            if (!askArr[i].startsWith("C")) {
                continue;
            }
            String[] customerAsk = askArr[i].split(" ");

            WaitingTimeline waitingTimeline = new WaitingTimeline(customerAsk[1], customerAsk[2], customerAsk[3], customerAsk[4], customerAsk[5]);

            waitingTimelineList.add(waitingTimeline);
        }

        startOfAddingNewCustomerAsks = queryId;

        //return id, where should start next adding from
        return startOfAddingNewCustomerAsks;
    }

    private String showWaitingTime(List<WaitingTimeline> waitingTimelineList, QueryLine queryLine){


        int sum = 0;
        int countOfCheckedAsks = 1;

        for (WaitingTimeline line : waitingTimelineList) {
            int waitingTime = queryLine.checkEqualToTimeline(line);
            if(waitingTime == 0)
                continue;
            sum += waitingTime;
            countOfCheckedAsks++;
        }

        if (sum != 0) {
            return Integer.toString(sum / (countOfCheckedAsks - 1));
        } else {
            return ("-");
        }
    }

}
