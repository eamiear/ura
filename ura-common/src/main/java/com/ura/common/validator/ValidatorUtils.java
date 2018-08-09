/**
 * @author eamiear
 * @date 2018/8/1 0:36
 */

package com.ura.common.validator;


import com.ura.common.utils.URAException;
import javafx.beans.value.ObservableValueBase;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     *  对象校验
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws URAException 校验不通过
     */
    public static void validateEntity(Object object, Class<?>... groups) throws URAException{
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object,groups);
        if (constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = constraintViolations.iterator().next();
            throw new URAException(constraint.getMessage());
        }
    }
}
