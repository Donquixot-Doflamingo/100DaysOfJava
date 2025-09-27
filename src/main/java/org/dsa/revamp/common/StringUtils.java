package org.dsa.revamp.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

    public static boolean isEmpty(String input) {
        input = Objects.isNull(input) ? input : input.trim();
        return Objects.isNull(input) || input.isBlank() || input.equalsIgnoreCase("null");
    }
}
