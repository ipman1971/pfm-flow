package com.ipman1971.pfm.preprocessor.utils;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by jcorredera on 6/07/17.
 */
@Getter
@ToString
public final class FieldPosition {

    private final int start;
    private final int end;

    private FieldPosition(int start, int end) {
        this.start=start;
        this.end=end;
    }

    public static FieldPosition of(int start, int end) {
        return new FieldPosition(start,end);
    }

}
