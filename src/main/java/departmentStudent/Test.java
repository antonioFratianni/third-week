package departmentStudent;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Department department = new Department();
        department.setDepName("ComputerScience");

        Student student1 = new Student();
        student1.setFirstName("Mario");
        student1.setLastName("Rossi");
        student1.setDepartment(department);

        Student student2 = new Student();
        student2.setFirstName("Luigi");
        student2.setLastName("Bianchi");
        student2.setDepartment(department);

        Set<Student> studSet = new HashSet<Student>();
        studSet.add(student1);
        studSet.add(student2);
        department.setStudents(studSet);
        session.save(department);

        session.getTransaction().commit();
        session.close();
    }
}
