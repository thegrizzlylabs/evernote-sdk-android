package com.evernote.client.android.tasks;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author rwondratschek
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TaskResult {
    String id() default "";
}
