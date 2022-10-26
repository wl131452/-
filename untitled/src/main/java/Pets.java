public class Pets {
    private String petName;//宠物名

    public Pets(String petName, String pet_type, Integer master) {
        this.petName = petName;
        this.pet_type = pet_type;
        this.master = master;
    }

    private String pet_type;//宠物品种
    private Integer master;//宠物主人编号

    public Integer getMaster() {
        return master;
    }

    public String getPet_type() {
        return pet_type;
    }

    public String getPetName() {
        return petName;
    }
}
