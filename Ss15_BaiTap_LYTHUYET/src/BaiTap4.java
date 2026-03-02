import java.util.LinkedList;
import java.util.Queue;

public class BaiTap4 {

 
    static class EmergencyPatient {
        private String id;
        private String name;
        private int priority; // 1 = cấp cứu, 2 = thường

        public EmergencyPatient(String id, String name, int priority) {
            this.id = id;
            this.name = name;
            this.priority = priority;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public int getPriority() { return priority; }

        public void setId(String id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setPriority(int priority) { this.priority = priority; }

        @Override
        public String toString() {
            String type = (priority == 1) ? "CẤP CỨU" : "THƯỜNG";
            return id + " - " + name + " [" + type + "]";
        }
    }

    static class EmergencyQueue {

        private Queue<EmergencyPatient> urgentQueue = new LinkedList<>();
        private Queue<EmergencyPatient> normalQueue = new LinkedList<>();

        // thêm bệnh nhân
        public void addPatient(EmergencyPatient p) {
            if (p.getPriority() == 1) {
                urgentQueue.add(p);
                System.out.println("\n[THÊM] " + p + " -> vào hàng CẤP CỨU");
            } else {
                normalQueue.add(p);
                System.out.println("\n[THÊM] " + p + " -> vào hàng THƯỜNG");
            }
            displayQueue();
        }

        // gọi khám
        public EmergencyPatient callNextPatient() {
            EmergencyPatient next;

            if (!urgentQueue.isEmpty()) {
                next = urgentQueue.poll();
            } else if (!normalQueue.isEmpty()) {
                next = normalQueue.poll();
            } else {
                System.out.println("\nKhông còn bệnh nhân!");
                return null;
            }

            System.out.println("\n[KHÁM] Đang khám: " + next);
            displayQueue();
            return next;
        }

        // hiển thị
        public void displayQueue() {

            if (urgentQueue.isEmpty() && normalQueue.isEmpty()) {
                System.out.println("Phòng khám trống.");
                return;
            }

            System.out.println("---- HÀNG ĐỢI HIỆN TẠI ----");

            System.out.println("CẤP CỨU:");
            if (urgentQueue.isEmpty()) System.out.println(" (không có)");
            for (EmergencyPatient p : urgentQueue)
                System.out.println("  " + p);

            System.out.println("THƯỜNG:");
            if (normalQueue.isEmpty()) System.out.println(" (không có)");
            for (EmergencyPatient p : normalQueue)
                System.out.println("  " + p);
        }
    }

    public static void main(String[] args) {

        EmergencyQueue eq = new EmergencyQueue();

        eq.addPatient(new EmergencyPatient("BN01","Nguyen Van A",2));
        eq.addPatient(new EmergencyPatient("BN02","Tran Thi B",2));
        eq.addPatient(new EmergencyPatient("BN03","Le Van C",1));
        eq.addPatient(new EmergencyPatient("BN04","Pham Thi D",2));
        eq.addPatient(new EmergencyPatient("BN05","Hoang Van E",1));

        eq.callNextPatient();
        eq.callNextPatient();
        eq.callNextPatient();
        eq.callNextPatient();
        eq.callNextPatient();
        eq.callNextPatient();
    }
}


