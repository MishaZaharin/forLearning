public class ExampleEqualsHashCodeToString {
    class Student {
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Student other = (Student) obj;
            //return this.name == person.name && this.age == person.age;
            if (this.age != other.age)
                return false;
            if (age != other.age)
                return false;
            if (id != other.id)
                return false;
            if (this.name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        public int hashCode() {
            return (int) (31 * id + age + ((name == null) ? 0 : name.hashCode()));
        }

        public String toString() {
            return getClass().getName() + "@name" + name + " id:" + id + " age:" + age;
        }
    }
}
