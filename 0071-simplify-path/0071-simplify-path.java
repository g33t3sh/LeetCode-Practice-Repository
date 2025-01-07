import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        StringBuilder simplifiedPath = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            simplifiedPath.insert(0, "/" + stack.pop());
        }
        
        return simplifiedPath.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/a/./b/../../c/";
        String simplifiedPath = solution.simplifyPath(path);
        System.out.println(simplifiedPath); 
    }
}