/** Given an absolute path for a file (Unix-style), simplify it.
*
* For example,
* path = "/home/", => "/home"
* path = "/a/./b/../../c/", => "/c"
*
* public String simplifyPath(String path)
*/

import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        if(path == null || path.length() == 0)
        	return path;
        int offset = 0;
        Stack<String> stack = new Stack<String>();
        while(offset < path.length()){
        	String tmp = extractDir(path, offset);
        	offset += tmp.length();
        	if(tmp.equals("/") || tmp.equals("/."))
        		continue;
        	else if(tmp.equals("/..")){
        	    if(!stack.isEmpty())
        		    stack.pop();
        	}else
        		stack.push(tmp);
        }
        if(stack.isEmpty())
        	return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    private static String extractDir(String path, int offset){
    	StringBuilder sb = new StringBuilder();
    	sb.append(path.charAt(offset++));
    	while(offset < path.length() && path.charAt(offset) != '/')
    		sb.append(path.charAt(offset++));
    	return sb.toString();
    }
}