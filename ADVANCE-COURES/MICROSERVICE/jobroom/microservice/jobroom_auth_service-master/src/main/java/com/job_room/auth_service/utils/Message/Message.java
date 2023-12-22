package com.job_room.auth_service.utils.Message;

public class Message {
    public enum Success{
        INSERTED_SUCCESS("YOU HAVE INSERTED SUCCESS!"),
        FOUNDED("YOU HAVE FOUND ALL DATA!"),
        FOUND_ONE("YOU HAVE FOUND!"),
        DELETED_SUCCESS("YOU HAVE DELETED SUCCESS!");

        String msg;
        Success(String msg){
            this.msg=msg;
        }

        public String getMsg() {
            return msg;
        }
    }
    public enum Error{
        INSERTED_FAILD("YOU HAVE INSERTED FAILD!"),
        MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
        COULD_NOT_CREATE_USER_PROFILE("Could not create user profile"),
        COULD_NOT_UPDATE_USER_PROFILE("Could not update user profile"),
        COULD_NOT_DELETE_USER_PROFILE("Could not delete user profile"),
        NO_RECORD_FOUND("NO RECORD FOUND FOR PROVIDER ID"),
        NO_RECORD_FOUND_ALL("NO RECORD!"),
        FORRIGN_KEY("NO​ VALUE FOREIGN KEY IN OTHER TABLE!"),
        DELETED_FAILD("NO RECORD FOR DELETE!"),
        RECORD_ALREADY_EXISTS("Record already exists"),
        INTERNAL_SERVER_ERROR("Something went wrong. Please repeat this operation later.");
        String msg;
        Error(String msg){
            this.msg=msg;
        }
        public String getMsg() {
            return msg;
        }
    }

}
