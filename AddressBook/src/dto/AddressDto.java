package dto;

// Data Transfer Object, VO(value object)
public class AddressDto{
    // 서류철에서 한개의 데이터
    private String name;
    private int age;
    private String phone;
    private String address;
    private String memo;

    public AddressDto() {
    }

    public AddressDto(String name, int age, String phone, String address, String memo) {
        super();
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String toString() {
        return "|| 이름: " + name + " || 나이: " + age + " || 전화번호: " + phone + " || 주소: " + address + " || 메모: " + memo+ " ||";
    }
}
