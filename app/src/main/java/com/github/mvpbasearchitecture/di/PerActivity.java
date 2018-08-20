package com.github.mvpbasearchitecture.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by gk.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}

