/*
 * @(#)BlinkElement.java	1.2 01/02/22
 *
 * Project Name Project
 *
 * Author: Govind Thirumalai 
 */





package core.ui;

import java.lang.*;
import core.util.*;
import core.ui.*;

/**
 * The BlinkElement class returns a string in an HTML <BLINK></BLINK> format.
 * <BR><BR>
 * Usage:
 * BlinkElement str = new BlinkElement("Hello World!");
 * <BR>
 * str.getHTMLTag();
 * <BR><BR>
 * output: <BLINK>Hello World!</BLINK>
 * <BR><BR>
 * You can also use this as:
 * <BR><BR>
 * return (new BlinkElement("Hello World!").getHTMLTag());
 * <BR>
 *
 * @version	1.0
 * @author	Govind Thirumalai
 * @since	1.0
 */

public class BlinkElement extends HTMLElementObject {

    /**
     * Constructs this object,
     *
     */

    public BlinkElement() {
	super();
    }

   /**
     * Constructs this object with the specified statement, input parameters
     * and output parameters.
     *
     * @param str		the string to be in blink tag.
     */

    public BlinkElement(String str) {

	super(str);

    }

    /**
     * Constructs the HTML tag.
     */

    protected final void setHTMLTag() {

        StringBuffer buf = new StringBuffer();

        if (str != null) {
            buf.append("<");
            buf.append(BLINK);
	    buf.append(">");
            buf.append(str);
            buf.append("</");
	    buf.append(BLINK);
	    buf.append(">");
	    tag = buf.toString();
        }

    }
}

