
import java.util.Stack;

public class BaiTap3 {


    static class MedicationProcessChecker {

        private Stack<String> stack = new Stack<>();

        // reset stack
        public void reset() {
            stack.clear();
        }

        // kiểm tra quy trình
        public boolean checkProcess(String[] actions) {

            reset();
            System.out.println("Bắt đầu kiểm tra quy trình...\n");

            for (int i = 0; i < actions.length; i++) {

                String action = actions[i];

                if (action.equalsIgnoreCase("PUSH")) {
                    stack.push("MED");
                    System.out.println("Bước " + (i+1) + ": PUSH -> Phát thuốc");

                }
                else if (action.equalsIgnoreCase("POP")) {

                    if (stack.isEmpty()) {
                        System.out.println("Bước " + (i+1) + ": POP -> LỖI! Hoàn tất khi chưa phát thuốc");
                        return false;
                    }

                    stack.pop();
                    System.out.println("Bước " + (i+1) + ": POP -> Hoàn tất phát thuốc");
                }
                else {
                    System.out.println("Bước " + (i+1) + ": LỖI! Lệnh không hợp lệ: " + action);
                    return false;
                }
            }

            // kết thúc ca trực
            if (!stack.isEmpty()) {
                System.out.println("\nKẾT THÚC CA: Còn thuốc chưa phát xong!");
                return false;
            }

            System.out.println("\nKẾT THÚC CA: Quy trình hợp lệ ✔");
            return true;
        }
    }

    public static void main(String[] args) {

        MedicationProcessChecker checker = new MedicationProcessChecker();

        // Test 1: Hợp lệ
        String[] process1 = {"PUSH", "PUSH", "POP", "POP"};
        System.out.println("=== TEST 1 ===");
        checker.checkProcess(process1);

        // Test 2: POP khi rỗng
        String[] process2 = {"POP", "PUSH"};
        System.out.println("\n=== TEST 2 ===");
        checker.checkProcess(process2);

        // Test 3: Kết thúc chưa hoàn tất
        String[] process3 = {"PUSH", "PUSH", "POP"};
        System.out.println("\n=== TEST 3 ===");
        checker.checkProcess(process3);
    }
}

