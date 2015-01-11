package com.athlete.sports;

import com.parse.ui.ParseLoginDispatchActivity;

/**
 * Created by PSD on 1/11/15.
 */
public class DispatchActivity extends ParseLoginDispatchActivity {
    @Override
    protected Class<?> getTargetClass() {
        return IntroPage.class;
    }
}
