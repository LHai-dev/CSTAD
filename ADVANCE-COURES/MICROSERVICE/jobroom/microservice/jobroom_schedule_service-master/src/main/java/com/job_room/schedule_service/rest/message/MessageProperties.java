package com.job_room.schedule_service.rest.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageProperties {
    private MessageSource source;
    private MessageSourceAccessor accessor;

    @Autowired
    public void setSource(@Qualifier("messageSource") MessageSource source) {
        this.source = source;
    }

    @PostConstruct
    private void init(){
        accessor = new MessageSourceAccessor(source);
    }

    /** success */
    public String selected(String resourceName){
        return accessor.getMessage("message.selected", new Object[] {resourceName});
    }

    public String selectedOne(String resourceName){
        return accessor.getMessage("message.selected-one", new Object[] {resourceName});
    }


    public String inserted(String resourceName){
        return accessor.getMessage("message.inserted", new Object[] {resourceName});
    }

    public String updated(String resourceName){
        return accessor.getMessage("message.updated", new Object[] {resourceName});
    }

    public String deleted(String resourceName){
        return accessor.getMessage("message.deleted", new Object[] {resourceName});
    }

    /** not found */

    public String hasNoRecords(String resourceName){
        return accessor.getMessage("message.has-no-records", new Object[] {resourceName});
    }
    public String hasNoRecord(String resourceName){
        return accessor.getMessage("message.has-no-record", new Object[] {resourceName});
    }

    /** error */

    public String selectedError(String resourceName){
        return accessor.getMessage("message.selected-error", new Object[] {resourceName});
    }

    public String insertError(String resourceName){
        return accessor.getMessage("message.inserted-error", new Object[] {resourceName});
    }

    public String updatedError(String resourceName){
        return accessor.getMessage("message.updated-error", new Object[] {resourceName});
    }

    public String deletedError(String resourceName,String resourceName2){
        return accessor.getMessage("message.deleted-error", new Object[] {resourceName,resourceName2});
    }

    public String insertedTypeNotFound(String resourceName,String resourceName2){
        return accessor.getMessage("message.inserted-type-not-found", new Object[] {resourceName,resourceName2});
    }

    public String duplicate(String resourceName,String resourceName2){
        return accessor.getMessage("message.duplicate", new Object[] {resourceName,resourceName2});
    }

    public String updatedTypeNotFound(String resourceName,String resourceName2){
        return accessor.getMessage("message.updated-type-not-found", new Object[] {resourceName,resourceName2});
    }

    public String userValidate(String resourceName, String resourceName2){
        return accessor.getMessage("message.user-error", new Object[] {resourceName,resourceName2});
    }


}
