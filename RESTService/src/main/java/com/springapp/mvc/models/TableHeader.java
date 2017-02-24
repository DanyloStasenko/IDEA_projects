package com.springapp.mvc.models;

public class TableHeader {

    private boolean isMovieId;
    private boolean isUserId;
    private boolean isRatingId;
    private boolean isRating;
    private boolean isRatingDate;
    private boolean isUserTitle;
    private boolean isMovieTitle;
    private boolean isMovieDirector;

    public boolean isMovieId() {
        return isMovieId;
    }

    public void setMovieId(boolean isMovieId) {
        this.isMovieId = isMovieId;
    }

    public boolean isUserId() {
        return isUserId;
    }

    public void setUserId(boolean isUserId) {
        this.isUserId = isUserId;
    }

    public boolean isRatingId() {
        return isRatingId;
    }

    public void setRatingId(boolean isRatingId) {
        this.isRatingId = isRatingId;
    }

    public boolean isRating() {
        return isRating;
    }

    public void setRating(boolean isRating) {
        this.isRating = isRating;
    }

    public boolean isRatingDate() {
        return isRatingDate;
    }

    public void setRatingDate(boolean isRatingDate) {
        this.isRatingDate = isRatingDate;
    }

    public boolean isUserTitle() {
        return isUserTitle;
    }

    public void setUserTitle(boolean isUserTitle) {
        this.isUserTitle = isUserTitle;
    }

    public boolean isMovieTitle() {
        return isMovieTitle;
    }

    public void setMovieTitle(boolean isMovieTitle) {
        this.isMovieTitle = isMovieTitle;
    }

    public boolean isMovieDirector() {
        return isMovieDirector;
    }

    public void setMovieDirector(boolean isMovieDirector) {
        this.isMovieDirector = isMovieDirector;
    }

    @Override
    public String toString() {
        return "DatabaseTableHeader{" +
                "isMovieId=" + isMovieId +
                ", isUserId=" + isUserId +
                ", isRatingId=" + isRatingId +
                ", isRating=" + isRating +
                ", isRatingDate=" + isRatingDate +
                ", isUserTitle=" + isUserTitle +
                ", isMovieTitle=" + isMovieTitle +
                ", isMovieDirector=" + isMovieDirector +
                '}';
    }
}
