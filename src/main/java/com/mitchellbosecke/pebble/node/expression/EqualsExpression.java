/*******************************************************************************
 * This file is part of Pebble.
 * 
 * Copyright (c) 2014 by Mitchell Bösecke
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.mitchellbosecke.pebble.node.expression;

import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.EvaluationContext;
import com.mitchellbosecke.pebble.template.PebbleTemplateImpl;
import com.mitchellbosecke.pebble.utils.OperatorUtils;

public class EqualsExpression extends BinaryExpression<Boolean> {

    @Override
    public Boolean evaluate(PebbleTemplateImpl self, EvaluationContext context) throws PebbleException {

        try{
            return OperatorUtils.equals(getLeftExpression().evaluate(self, context),
                    getRightExpression().evaluate(self, context));
        }catch(Exception ex){
            throw new PebbleException(ex, "Could not perform equals comparison", getLineNumber(), self.getName());
        }
    }
}
