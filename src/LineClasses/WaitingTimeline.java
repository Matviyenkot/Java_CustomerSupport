package LineClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
*
 * C service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date time
 *
 * Values in square brackets are optional.
 * service_id[.variation_id] - service 9.1 represent service 9 of variation 1.
 * question_type_id[.category_id.[sub-category_id]] - question type 7.14.4 represent question type 7
 * category 14 and sub-category 4.
 * P/N - response type ‘P’ (first answer) or ‘N’ (next answer).
 * date - response date format is DD.MM.RRRR, for example, 27.11.2012 (27.november 2012).
 * time - time in minutes represent waiting time.
* */

public class WaitingTimeline extends AbstractLine{

    private LocalDate dateOfAsk;

    private String time;

    public WaitingTimeline(String serviceId, String questionTypeId, String responseType, String dateOfAsk, String time) {
        checkServiceId(serviceId);
        checkQuestionTypeId(questionTypeId);
        this.responseType = responseType;
        this.dateOfAsk = stringToDate(dateOfAsk);
        this.time = time;
    }

    public LocalDate getDateOfAsk() {
        return dateOfAsk;
    }

    public void setDateOfAsk(LocalDate dateOfAsk) {
        this.dateOfAsk = dateOfAsk;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LineClasses.WaitingTimeline{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType='" + responseType + '\'' +
                ", dateOfAsk=" + dateOfAsk +
                ", time=" + time +
                '}';
    }
}
