package com.job_room.annoouncement_service.model.json_type;

import org.hibernate.dialect.PostgreSQL95Dialect;

import java.sql.Types;

/**
 * @Description: Customize PostgreSQL dialect
 * @Author: caijun
 */
public class JsonbPostgresDialect extends PostgreSQL95Dialect {
    public JsonbPostgresDialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
