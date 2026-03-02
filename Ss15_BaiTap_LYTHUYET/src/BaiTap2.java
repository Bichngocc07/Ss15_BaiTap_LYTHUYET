import java.util.LinkedList;
import java.util.Queue;

public class BaiTap2 {

    // =========================
    // LỚP PATIENT
    // =========================
    static class Patient {
        private String id;
        private String name;
        private int age;

        public Patient(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }

        public void setId(String id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setAge(int age) { this.age = age; }

        @Override
        public String toString() {
            return id + " - " + name + " (" + age + " tuổi)";
        }
    }

    // =========================
    // LỚP QUẢN LÝ HÀNG ĐỢI
    // =========================
    static class PatientQueue {

        private Queue<Patient> queue = new LinkedList<>();

        // enqueue
        public void addPatient(Patient p) {
            queue.add(p);
            System.out.println("\n[THÊM] " + p);
            displayQueue();
        }

        // dequeue
        public Patient callNextPatient() {
            if (queue.isEmpty()) {
                System.out.println("\n[KHÁM] Không còn bệnh nhân!");
                return null;
            }

            Patient p = queue.poll();
            System.out.println("\n[KHÁM] Đang khám: " + p);
            displayQueue();
            return p;
        }

        // peek
        public Patient peekNextPatient() {
            if (queue.isEmpty()) {
                System.out.println("\n[PEEK] Không có bệnh nhân chờ.");
                return null;
            }

            Patient p = queue.peek();
            System.out.println("\n[PEEK] Bệnh nhân tiếp theo: " + p);
            return p;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        // hiển thị
        public void displayQueue() {
            if (queue.isEmpty()) {
                System.out.println("Hàng đợi trống.");
                return;
            }

            System.out.println("---- DANH SÁCH ĐANG CHỜ ----");
            for (Patient p : queue) {
                System.out.println(p);
            }
        }
    }

    // =========================
    // MAIN TEST
    // =========================
    public static void main(String[] args) {

        PatientQueue pq = new PatientQueue();

        pq.addPatient(new Patient("BN01", "Nguyen Van A", 25));
        pq.addPatient(new Patient("BN02", "Tran Thi B", 40));
        pq.addPatient(new Patient("BN03", "Le Van C", 32));

        pq.peekNextPatient();

        pq.callNextPatient();
        pq.callNextPatient();
        pq.callNextPatient();
        pq.callNextPatient(); // test rỗng
    }
}
