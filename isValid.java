/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

class Solution {
    public boolean isValid(String s) {
        // if (s.length() == 0) {
        //     return true;
        // }

        if (s.length() % 2 != 0) {
            return false;
        }

        StringBuilder open = new StringBuilder();   // stores the open signs

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                open.append(ch);
            } else {
                if (open.length() == 0) {
                    return false;
                }

                char corresponding = open.charAt(open.length() - 1);

                if (ch == ')') {
                    if (corresponding != '(') {
                        return false;
                    }
                } else if (ch == ']') {
                    if (corresponding != '[') {
                        return false;
                    }
                } else if (ch == '}') {
                    if (corresponding != '{') {
                        return false;
                    }
                }

                open.deleteCharAt(open.length() - 1);
            }
        }

        return open.length() == 0;
    }
}
