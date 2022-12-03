public class ToolStore extends NormalLoc {
    Weapon weapon;

    public ToolStore(Player player) {
        super(player, "Magaza  ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------Magazaya Hosgeldiniz-------");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zirhlar");
        System.out.println("3 - Cikis Yap");
        System.out.print("Seciminiz : ");
        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Gecersiz deger, tekrar giriniz : ");
            selectCase = input.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();

                break;
            case 3:
                System.out.println("Bir daha bekleriz !");
                return true;

        }
        return true;
    }

    public void printWeapon() {
        System.out.println("-------Silahlar-------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "- " + w.getName() + " --> Para : " + w.getPrice() + ", Hasar : " + w.getDamage());
        }
    }

    public void buyWeapon() {
        System.out.print("Alacaginiz Silahin ID numarasini giriniz : ");
        int selectWeaponID = input.nextInt();

        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Gecersiz deger, tekrar giriniz : ");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır ! ");
            } else {
                System.out.println(selectedWeapon.getName() + " silahini satin aldiniz !");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                System.out.println("Onceki Silahiniz : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni Silahiniz : " + this.getPlayer().getInventory().getWeapon().getName());

            }
        }
    }

    public void printArmor() {
        System.out.println("-------Zirhlar-------");
        for (Armor a: Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " < Para : " + a.getPrice() + ", Zirh : " + a.getBlock() );

        }
    }
    public void buyArmor(){
        System.out.print("Bir Zirh secin : ");

        int selectArmorID = input.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
            System.out.println("Gecersiz deger, tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

        if (selectedArmor != null){
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz bulunmamaktadir.");
            }else{
                System.out.println(selectedArmor.getName() + " zirini satın aldınız !");
                int balance = getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Kalan Bakiye : " + this.getPlayer().getMoney()); 
            }
        }

    }

}
