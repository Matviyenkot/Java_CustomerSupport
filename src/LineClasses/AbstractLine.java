package LineClasses;

import java.time.LocalDate;

public abstract class AbstractLine {

    protected int serviceId;//1-20

    protected int variationId;//1-3

    protected int questionTypeId;//1-10

    protected int categoryId;//1-20

    protected int subCategoryId;//1-5

    protected String responseType;//P/N

    protected void checkQuestionTypeId(String questionTypeIdStr){

        if(questionTypeIdStr.equals("*")){
            return;
        }

        String[] questions = questionTypeIdStr.split("\\.");

        switch (questions.length){
            case 3: this.subCategoryId = Integer.parseInt(questions[2]);
            case 2: this.categoryId = Integer.parseInt(questions[1]);
            case 1: this.questionTypeId = Integer.parseInt(questions[0]);
                break;
        }
    }

    protected void checkServiceId(String serviceIdStr){

        if(serviceIdStr.equals("*")){
            return;
        }

        String[] services = serviceIdStr.split("\\.");

        switch (services.length){
            case 2: this.variationId = Integer.parseInt(services[1]);
            case 1:
                this.serviceId = Integer.parseInt(services[0]);
                break;
        }
    }

    protected LocalDate stringToDate(String date){

        String[] dateSplit = date.split("\\.");

        LocalDate localDate = LocalDate.of(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[0]));

        return localDate;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVariationId() {
        return variationId;
    }

    public void setVariationId(int variationId) {
        this.variationId = variationId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
