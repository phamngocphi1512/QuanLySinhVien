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
            "0" -> {
                println("Đã thoát chương trình.")
                return
            }
            else -> println("Chức năng đang được cập nhật hoặc lựa chọn không hợp lệ!")
        }
    }
}