data class Student(
    val id: String,
    val name: String,
    val age: Int,
    val major: String,
    val gpa: Double
)

fun displayStudent(student: Student) {
    println("ID: ${student.id} | Name: ${student.name} | Age: ${student.age} | Major: ${student.major} | GPA: ${student.gpa}")
}

fun main() {
    val students = mutableListOf(
        Student("SV01", "Phạm Ngọc Phi", 20, "Thiết kế đa phương tiện", 8.8),
        Student("SV02", "Nguyễn Văn An", 21, "Công nghệ phần mềm", 9.2),
        Student("SV03", "Trần Thị Bích", 19, "Mạng máy tính", 4.5),
        Student("SV04", "Lê Hoàng Cường", 22, "Thiết kế đa phương tiện", 7.5),
        Student("SV05", "Đặng Minh Tuấn", 20, "Hệ thống thông tin", 8.0)
    )

    while (true) {
        println("\n========== STUDENT MANAGEMENT ==========")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student (Theo một phần tên)")
        println("4. Calculate average GPA (Của một ngành)")
        println("5. Find student with highest GPA")
        println("6. Remove student")
        println("--- Chức năng Thống kê & Lọc ---")
        println("7. Đếm số sinh viên có GPA >= 8.0")
        println("8. Đếm số sinh viên có GPA < 5.0")
        println("9. Tìm sinh viên lớn tuổi nhất")
        println("10. Tìm sinh viên có GPA từ 7.0 đến 8.5")
        println("11. Tìm tất cả sinh viên thuộc một ngành")
        println("--- Chức năng Sắp xếp ---")
        println("12. Sắp xếp sinh viên theo GPA giảm dần")
        println("13. Hiển thị 3 sinh viên có GPA cao nhất")
        println("14. Sắp xếp sinh viên theo tuổi")
        println("15. Sắp xếp sinh viên theo tên")
        println("0. Exit")
        println("========================================")
        print("Choose: ")

        when (readlnOrNull()?.trim()) {
            "1" -> {
                print("Nhập Student ID: "); val id = readln()
                print("Nhập Full Name: "); val name = readln()
                print("Nhập Age: "); val age = readln().toIntOrNull() ?: 0
                print("Nhập Major: "); val major = readln()
                print("Nhập GPA: "); val gpa = readln().toDoubleOrNull() ?: 0.0
                students.add(Student(id, name, age, major, gpa))
                println("=> Thêm sinh viên thành công!")
            }
            "2" -> {
                println("--- Danh sách sinh viên ---")
                if (students.isEmpty()) println("Danh sách trống.")
                else students.forEach { displayStudent(it) }
            }
            "3" -> {
                print("Nhập từ khóa tên cần tìm: ")
                val keyword = readln()
                val found = students.filter { it.name.contains(keyword, ignoreCase = true) }
                if (found.isEmpty()) println("=> Không tìm thấy.")
                else found.forEach { displayStudent(it) }
            }
            "4" -> {
                print("Nhập ngành cần tính GPA trung bình: ")
                val major = readln()
                val filtered = students.filter { it.major.equals(major, ignoreCase = true) }
                if (filtered.isNotEmpty()) println("=> ĐTB ngành $major: ${filtered.map { it.gpa }.average()}")
                else println("=> Không có sinh viên ngành này.")
            }
            "5" -> {
                val highest = students.maxByOrNull { it.gpa }
                if (highest != null) {
                    println("=> Sinh viên có GPA cao nhất:"); displayStudent(highest)
                } else println("Danh sách trống.")
            }
            "6" -> {
                print("Nhập ID cần xóa: ")
                val id = readln()
                if (students.removeIf { it.id.equals(id, ignoreCase = true) }) println("=> Đã xóa sinh viên $id.")
                else println("=> Không tìm thấy sinh viên.")
            }
            "7" -> println("=> Số sinh viên GPA >= 8.0: ${students.count { it.gpa >= 8.0 }}")
            "8" -> println("=> Số sinh viên GPA < 5.0: ${students.count { it.gpa < 5.0 }}")
            "9" -> {
                val oldest = students.maxByOrNull { it.age }
                if (oldest != null) {
                    println("=> Sinh viên lớn tuổi nhất:"); displayStudent(oldest)
                }
            }
            "10" -> {
                val found = students.filter { it.gpa in 7.0..8.5 }
                if (found.isEmpty()) println("=> Không có sinh viên nào.")
                else found.forEach { displayStudent(it) }
            }
            "11" -> {
                print("Nhập ngành: ")
                val major = readln()
                val found = students.filter { it.major.equals(major, ignoreCase = true) }
                if (found.isEmpty()) println("=> Không có sinh viên ngành $major.")
                else found.forEach { displayStudent(it) }
            }
            "12" -> {
                println("--- Danh sách sắp xếp GPA giảm dần ---")
                students.sortedByDescending { it.gpa }.forEach { displayStudent(it) }
            }
            "13" -> {
                println("--- Top 3 sinh viên có GPA cao nhất ---")
                students.sortedByDescending { it.gpa }.take(3).forEach { displayStudent(it) }
            }
            "14" -> {
                println("--- Danh sách sắp xếp theo tuổi ---")
                students.sortedBy { it.age }.forEach { displayStudent(it) }
            }
            "15" -> {
                println("--- Danh sách sắp xếp theo tên ---")
                students.sortedBy { it.name }.forEach { displayStudent(it) }
            }
            "0" -> {
                println("Đã thoát chương trình.")
                return
            }
            else -> println("Chức năng đang được cập nhật hoặc lựa chọn không hợp lệ!")
        }
    }
}