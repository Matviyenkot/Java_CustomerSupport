package LineClasses;

import java.time.LocalDate;

public class QueryLine extends AbstractLine{

    private LocalDate dateFrom;

    private LocalDate dateTo;

    public QueryLine(String serviceId, String questionTypeId, String responseType, String dates) {
        checkServiceId(serviceId);
        checkQuestionTypeId(questionTypeId);
        this.responseType = responseType;

        setDateFrames(dates);
    }

    public QueryLine(String serviceId, String responseType, String dates) {
        checkServiceId(serviceId);
        this.responseType = responseType;

        setDateFrames(dates);
    }

    private void setDateFrames(String dates){

        String[] datesArr = dates.split("-");

        switch (datesArr.length){
            case 2: this.dateFrom = stringToDate(datesArr[0]);
                    this.dateTo = stringToDate(datesArr[1]);
                    break;
            case 1: this.dateFrom = stringToDate(datesArr[0]);
                    this.dateTo = LocalDate.MAX;
                    break;
        }
    }

    private boolean equalService(WaitingTimeline waitingTimeline){

        if(this.getServiceId() == waitingTimeline.getServiceId()){
            if(this.getVariationId() == waitingTimeline.getVariationId()){
                return true;
            }
            else if(this.getVariationId() == 0){
                return true;
            }
        }
        else if(this.getServiceId() == 0){
            return true;
        }
        return false;
    }

    private boolean equalQuestions(WaitingTimeline waitingTimeline){

        if(this.questionTypeId == waitingTimeline.getQuestionTypeId()){
            if(this.categoryId == waitingTimeline.getCategoryId()){
                if(this.subCategoryId == waitingTimeline.getSubCategoryId()){
                    return true;
                }
                else if(this.subCategoryId == 0){
                    return true;
                }
            }
            else if(this.categoryId == 0){
                return true;
            }
        }
        else if(this.questionTypeId == 0){
            return true;
        }

        return false;
    }

    public int checkEqualToTimeline(WaitingTimeline waitingTimeline){

        //here check equals between customer ask and query
        if(this.equalService(waitingTimeline) && this.equalQuestions(waitingTimeline)
                && this.responseType.equals(waitingTimeline.getResponseType())
                && this.dateFrom.isBefore(waitingTimeline.getDateOfAsk())
                && this.dateTo.isAfter(waitingTimeline.getDateOfAsk())){
            return Integer.parseInt(waitingTimeline.getTime());
        }

        return 0;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "QueryLine{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType='" + responseType + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
