import java.util.Stack;

public class BaiTap1 {

    static class EditAction {
        private String description;
        private String time;

        public EditAction(String description, String time) {
            this.description = description;
            this.time = time;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return time + " - " + description;
        }
    }


    static class MedicalRecordHistory {

        private Stack<EditAction> history = new Stack<>();

        // PUSH
        public void addEdit(EditAction action) {
            history.push(action);
            System.out.println("\n[ADD] " + action);
            displayHistory();
        }

        // POP (UNDO)
        public EditAction undoEdit() {
            if (history.isEmpty()) {
                System.out.println("\n[UNDO] Không có dữ liệu để hoàn tác!");
                return null;
            }

            EditAction removed = history.pop();
            System.out.println("\n[UNDO] Đã hoàn tác: " + removed);
            displayHistory();
            return removed;
        }

        // PEEK
        public EditAction getLatestEdit() {
            if (history.isEmpty()) {
                System.out.println("\n[PEEK] Chưa có chỉnh sửa nào.");
                return null;
            }

            EditAction latest = history.peek();
            System.out.println("\n[PEEK] Chỉnh sửa gần nhất: " + latest);
            return latest;
        }

        public boolean isEmpty() {
            return history.isEmpty();
        }

        // HIỂN THỊ STACK
        public void displayHistory() {
            if (history.isEmpty()) {
                System.out.println("Stack rỗng.");
                return;
            }

            System.out.println("---- LỊCH SỬ (MỚI -> CŨ) ----");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    public static void main(String[] args) {

        MedicalRecordHistory history = new MedicalRecordHistory();

        // Bác sĩ chỉnh sửa bệnh án
        history.addEdit(new EditAction("Thêm chẩn đoán: Viêm họng", "09:00"));
        history.addEdit(new EditAction("Cập nhật nhiệt độ: 38.7°C", "09:05"));
        history.addEdit(new EditAction("Kê thuốc Amoxicillin", "09:10"));

        // Xem chỉnh sửa gần nhất
        history.getLatestEdit();

        // Undo nhiều lần
        history.undoEdit();
        history.undoEdit();
        history.undoEdit();
        history.undoEdit(); // test rỗng
    }
}
