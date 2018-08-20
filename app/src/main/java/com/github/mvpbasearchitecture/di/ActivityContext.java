package com.github.mvpbasearchitecture.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by gk.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}
