package com.beanbiscuit.moneytree.brokerclient.utility;

import java.lang.reflect.Field;

public class ObjectPrettyPrint {

    private ObjectPrettyPrint() {}

    /**
     *
     * @param object
     * @return
     */
    public static String print(Object object) {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( object.getClass().getName() );
        result.append( " {" );
        result.append(newLine);
        Field[] fields = object.getClass().getDeclaredFields();

        for ( Field field : fields  ) {
            result.append("  ");
            try {
                field.setAccessible(true);
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append(field.get(object));
            } catch (IllegalAccessException ex ) {
                result.append(newLine);
                continue;
            }
            result.append(newLine);
        }

        result.append("}");
        return result.toString();
    }
}