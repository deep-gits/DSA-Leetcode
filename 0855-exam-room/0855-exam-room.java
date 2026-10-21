class ExamRoom {
    private int n;
    private List<Integer> students;

    public ExamRoom(int n) {
        this.n = n;
        this.students = new ArrayList<>();
    }
    
    public int seat() {
        if (students.isEmpty()) {
            students.add(0);
            return 0;
        }
        
        int maxDist = students.get(0);
        int seat = 0;
        
        // Check distance between the start and the first student
        for (int i = 0; i < students.size() - 1; i++) {
            int prev = students.get(i);
            int curr = students.get(i + 1);
            int dist = (curr - prev) / 2;
            
            if (dist > maxDist) {
                maxDist = dist;
                seat = prev + dist;
            }
        }
        
        // Check distance between the last student and the end of the room
        if (n - 1 - students.get(students.size() - 1) > maxDist) {
            seat = n - 1;
        }
        
        // Insert the student's seat while keeping the list sorted
        int idx = 0;
        while (idx < students.size() && students.get(idx) < seat) {
            idx++;
        }
        students.add(idx, seat);
        
        return seat;
    }
    
    public void leave(int p) {
        students.remove(Integer.valueOf(p));
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */