package com.job_room.annoouncement_service.rest.message;

public class Pagination {
    private int currentPage;
    private Long totalItems;
    private int totalPages;
    private int pageSize;
    public Pagination(){}

    public Pagination(int currentPage, Long totalItems, int totalPages, int pageSize) {
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "currentPage=" + currentPage +
                ", totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                '}';
    }
}
