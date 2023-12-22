package com.job_room.annoouncement_service.rest.message;

public class Messages {

    private static final String NO_CONTENT = "No Content";

    private static final String FIND_SUCCESS = "You have selected all data successfully";
    private static final String ADD_SUCCESS = "You have added data successfully";
    private static final String GET_ONE_SUCCESS = "You have found the data";
    private static final String UPDATE_SUCCESS = "You have updated data successfully";
    private static final String DELETE_SUCCESS = "You have deleted data successfully";

    private static final String GET_ONE_FAILED = "Content not found";
    private static final String UPDATE_FAILED = "Update failed";
    private static final String DELETE_FAILED = "Delete failed";
    private static final String ADD_FAILED = "Cannot add with an empty field";



    public static String getNoContent() {
        return NO_CONTENT;
    }

    public static String getFindSuccess() {
        return FIND_SUCCESS;
    }

    public static String getAddSuccess() {
        return ADD_SUCCESS;
    }

    public static String getGetOneSuccess() {
        return GET_ONE_SUCCESS;
    }

    public static String getUpdateSuccess() {
        return UPDATE_SUCCESS;
    }

    public static String getDeleteSuccess() {
        return DELETE_SUCCESS;
    }

    public static String getGetOneFailed() {
        return GET_ONE_FAILED;
    }

    public static String getUpdateFailed() {
        return UPDATE_FAILED;
    }

    public static String getAddFailed() {
        return ADD_FAILED;
    }

    public static String getDeleteFailed() {
        return DELETE_FAILED;
    }

}
