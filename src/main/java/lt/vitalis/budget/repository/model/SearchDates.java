package lt.vitalis.budget.repository.model;

import java.time.LocalDateTime;

public class SearchDates {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public SearchDates(){

    }

    public SearchDates(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
