package com.job_room.schedule_service.util;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class PaginationUtils<R ,T extends Page> implements Page<R> {

    private final ModelMapper modelMapper = new ModelMapper();
    private T data;
    private R returnedValue;
    private Class<R> destinationClass;

    public PaginationUtils(Class<R> destinationClass) {
        this.destinationClass = destinationClass;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int getTotalPages() {
        return data.getTotalPages();
    }

    @Override
    public long getTotalElements() {
        return data.getTotalElements();
    }

    @Override
    public <U> Page<U> map(Function<? super R, ? extends U> converter) {
        return null;
    }

    @Override
    public int getNumber() {
        return data.getNumber();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public int getNumberOfElements() {
        return data.getNumberOfElements();
    }

    @Override
    public List<R> getContent() {

        List<R> content = new ArrayList<>();

        for (Object item : data.getContent()) {
            content.add(modelMapper.map(item, destinationClass));
        }

        return content;
    }

    @Override
    public boolean hasContent() {
        return data.hasContent();
    }

    @Override
    public Sort getSort() {
        return data.getSort();
    }

    @Override
    public boolean isFirst() {
        return data.isFirst();
    }

    @Override
    public boolean isLast() {
        return data.isLast();
    }

    @Override
    public boolean hasNext() {
        return data.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return data.hasPrevious();
    }

    @Override
    public Pageable nextPageable() {
        return data.nextPageable();
    }

    @Override
    public Pageable previousPageable() {
        return data.previousPageable();
    }

    @Override
    public Iterator<R> iterator() {

        List<R> list = new ArrayList<>();

        Iterator<T> itr = data.iterator();

        while (itr.hasNext()) {
            list.add(modelMapper.map(itr.next(), destinationClass));
        }

        return list.iterator();
    }

}
